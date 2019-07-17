package top.treegrowth.lock;

public class Lock {

    private String key;
    private String uid;

    public Lock(String key, String uid) {
        this.key = key;
        this.uid = uid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
