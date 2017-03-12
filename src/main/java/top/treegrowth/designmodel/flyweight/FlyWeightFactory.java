package top.treegrowth.designmodel.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wusi
 * @version 2017/3/12 10:35
 */
public class FlyWeightFactory {

    //初始化缓冲池,依赖倒置原则，使用FlyWeight，static方法始终在内存中存在
    private static Map<String, FlyWeight> pool = new HashMap<>();

    public static FlyWeight get(String key) {
        //注意初始化局部变量
        FlyWeight flyWeight;
        if (pool.containsKey(key)) {
            return pool.get(key);
        } else {
            //根据外部状态，首先创建需要的FlyWeight
            flyWeight = new ConcreteFlyWeight(key);
            //放入到缓冲池中，以便以后使用
            pool.put(key, flyWeight);
            return flyWeight;
        }
    }

    public static FlyWeight getNew(String key) {
        return new ConcreteFlyWeight(key);
    }
}
