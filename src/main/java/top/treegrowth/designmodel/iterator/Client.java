package top.treegrowth.designmodel.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
 * @author wusi
 * @version 2017/3/24 9:09
 */
public class Client {

    public static void main(String[] args) {

        List list = new ArrayList<>();
        Iterator iterator = list.iterator();

    }
}
