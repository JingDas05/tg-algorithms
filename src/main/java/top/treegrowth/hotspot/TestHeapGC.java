package top.treegrowth.hotspot;

/**
 * 测试java堆内存的垃圾回收
 * -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -Xms40M -Xmx40M -Xmn20M
 *
 * @author wusi
 * @version 2017/7/4 21:03.
 */
public class TestHeapGC {
    public static void main(String args[]){
        byte[] b1=new byte[1024*1024/2];
        byte[] b2=new byte[1024*1024*8];
        b2=null;
        b2=new byte[1024*1024*8];
        System.gc();
    }
}
