package top.treegrowth.javasource;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wusi
 * @version 2017/3/24 13:00
 */
public class ListRelation {

    public static void main(String[] args) {
        Apple[] apples = new Apple[]{new Apple(1), new Apple(2)};
        Arrays.sort(apples, new SelfComparator());
    }


    private static class SelfComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple o1, Apple o2) {
            return 0;
        }
    }

    static class Apple {
        private int weight;

        public Apple() {
        }

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
