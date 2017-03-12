package top.treegrowth.designmodel.flyweight;

import java.util.Date;

/**
 * @author wusi
 * @version 2017/3/12 10:48
 */
public class Client {

    public static void main(String[] args) {

        // TODO: 2017/3/12 记录时间这个在哪儿看到一个封装的比较巧妙的方法，应该是effective java,记得找一找
        Date begin = new Date();
        for (int i = 0; i < 100000000; i++) {
            //FlyWeightFactory.get("1");
            FlyWeightFactory.getNew("1");
        }
        System.out.println(new Date().getTime() - begin.getTime());
        //感觉上面两种方法时间差不多，有时享元模式有可能更慢，这个应该是用时间换空间吧
    }
}
