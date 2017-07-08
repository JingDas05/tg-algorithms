package top.treegrowth.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 *
 * @author wusi
 * @version 2017/3/24 13:00
 */
public class ComparatorCus {

    public static void main(String[] args) {
        Apple1[] apple1s = new Apple1[]{new Apple1(3), new Apple1(4)};
        Arrays.sort(apple1s, new SelfComparator4Apple1());
        System.out.println("apple一比较结果：apple0:" + apple1s[0].getWeight() + ",apple1:" + apple1s[1].getWeight());

        Apple2[] apple2s = new Apple2[]{new Apple2(3), new Apple2(4)};
        Arrays.sort(apple2s, new SelfComparator4Apple2());
        System.out.println("apple二比较结果：apple0:" + apple2s[0].getWeight() + ",apple1:" + apple2s[1].getWeight());
    }


    private static class SelfComparator4Apple1 implements Comparator<Apple1> {

        @Override
        public int compare(Apple1 o1, Apple1 o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }

    private static class SelfComparator4Apple2 implements Comparator<Apple2> {

        @Override
        public int compare(Apple2 o1, Apple2 o2) {
            return o1.compareTo(o2);
        }
    }

    static class Apple1 {
        private Integer weight;

        public Apple1() {
        }

        public Apple1(Integer weight) {
            this.weight = weight;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }

    //这个地方可以定义自己的比较规则
    static class Apple2 implements Comparable {
        private Integer weight;

        public Apple2() {
        }

        public Apple2(Integer weight) {
            this.weight = weight;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            Apple2 apple2 = (Apple2) o;
            return this.getWeight().compareTo(apple2.getWeight());
        }
    }
}
