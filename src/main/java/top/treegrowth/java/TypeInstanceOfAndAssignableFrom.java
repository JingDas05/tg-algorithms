package top.treegrowth.java;

/**
 * @author wusi
 * @version 2017/6/8 9:15
 */
public class TypeInstanceOfAndAssignableFrom {

    private Class parentClass = Parent.class;
    private Class childClass = Child.class;
    private Parent parent = new Parent();
    private Child child = new Child();

    public static void main(String[] args) {
        //isAssignableFrom() 前面是parent,后面是child
        System.out.println(Object.class.isAssignableFrom(String.class));
        System.out.println(Object.class.isAssignableFrom(Object.class));

        TypeInstanceOfAndAssignableFrom type = new TypeInstanceOfAndAssignableFrom();
        System.out.println(type.child instanceof Parent);

        System.out.println(type.childClass.isInstance(type.parent));
        System.out.println(type.childClass.isInstance(type.child));

    }

    public class Parent {}

    public class Child extends Parent{}
}
