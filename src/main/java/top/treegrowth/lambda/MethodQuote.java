package top.treegrowth.lambda;


import java.util.function.Function;
import java.util.function.Supplier;

public class MethodQuote {

    public static void main(String[] args) {

        //lambda 表达式
        //定义一个函数式接口的实现
        Function <Integer, Apple> f = (weight) -> new Apple(weight);
        //调用接口
        Apple apple = f.apply(100);
        System.out.println(apple);
        //以上调用的顺序正好与使用时候相反，比如下面的方法 normal

        //方法引用
        Function <Integer, Apple> f1 = Apple::new;
        Apple apple1 = f1.apply(100);
        System.out.println(apple1);

        System.out.println(normal(() -> "我不是方法引用的用法"));
        System.out.println(normal(() -> new Apple(400)));
        //方法引用的调用
        //System.out.println(normal(Apple1::new));
    }

    public static <T> T normal(CustomSupplier<T> custom) {
        //do something
        //这个地方我只是调用了函数式接口的方法，不知道接口的实现是什么
        return custom.get();
    }

    @FunctionalInterface
    interface CustomSupplier<T> {
        T get();
    }

    static class Apple {
        private int weight;

        public Apple() {};

        public Apple(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
