package top.treegrowth.designmodel.prototype;

/**
 *
 * 原型模式，这个主要是实现了Cloneable接口，复制，最初的对象为原型
 *
 *
 *
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
 * @author wusi
 * @version 2017/7/27 8:49
 */
public class Client {

    public static void main(String[] args) {
        // 以下代码说明了复制可以复制基本类型，包含String，但是其他类型的没办法复制
        Thing thing = new Thing();
        thing.setName("张三");
        thing.setList("一一");
        System.out.println("原型的name"+ thing.getName());
        System.out.println("原型的listName"+ thing.getList());
        Thing cloneThing = thing.clone();
        cloneThing.setName("李四");
        cloneThing.setList("二二");
        System.out.println("原型的name"+ thing.getName());
        System.out.println("原型的listName"+ thing.getList());
    }
}
