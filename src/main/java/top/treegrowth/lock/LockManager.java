package top.treegrowth.lock;

import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.UUID;

public class LockManager {

    private String SET_SUCCESS = "OK";
    private String DEL_SUCCESS = "1";
    private String SET_IF_NOT_EXIST = "NX";
    private String SET_WITH_EXPIRE_TIME = "PX";
    private JedisPool JEDIS_POOL = new JedisPool("localhost", 6379);

    private String RELEASE_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    private String RELEASE_SCRIPT1 = "return redis.call('get', KEYS[1])";
    private String LOCK_PREFIX = "LOCK_PREFIX_";

    /**
     * 获取锁
     *
     * @param key        获取锁的key
     * @param expiryTime 锁的失效时间，单位是毫秒
     * @return 获取的锁
     */
    public Lock acquire(String key, Integer expiryTime) {
        Lock lock = new Lock(enrichKey(key), UUID.randomUUID().toString());
        String result = JEDIS_POOL.getResource().set(lock.getKey(), lock.getUid(), SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expiryTime);
        if (SET_SUCCESS.equals(result)) {
            return lock;
        } else {
            return null;
        }
    }

    /**
     * 释放锁
     *
     * @param lock 获取的锁
     * @return 释放是否成功
     */

    public boolean release(Lock lock) {
        if (lock == null) return false;
        Object result = JEDIS_POOL.getResource().eval(RELEASE_SCRIPT, Collections.singletonList(lock.getKey()), Collections.singletonList(lock.getUid()));
        return result.toString().equals(DEL_SUCCESS);

    }

    private String enrichKey(String key) {
        return LOCK_PREFIX + key;
    }
}
