package top.treegrowth.java.statictest;

/**
 * @author wusi
 * @version 2018/4/3 8:45.
 */
public class Data {
    public static void main(String[] args) {
        Data data1 = new Data();
        Data data2 = new Data();
        data1.setNextId(1000);
        System.out.println(data2.getNextId());
    }

    private static int nextId = 0;

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        Data.nextId = nextId;
    }
}
