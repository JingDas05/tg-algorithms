package top.treegrowth.designmodel.flyweight;

import java.util.Date;

/**
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
 * 享元模式
 *
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
