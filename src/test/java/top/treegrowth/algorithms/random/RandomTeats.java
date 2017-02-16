package top.treegrowth.algorithms.random;

import java.util.Random;

public class RandomTeats {

    private static Random random = new Random();

    public static void main(String[] args) {
        int area = 1000000;
        int bound = 2 * (Integer.MAX_VALUE / 3);

        //之前的测试方法，将两个方法分开，但是违反了DRY原则
        //randomNIsBig(area, bound);
        //randomOffical(area, bound);

        //修改传递进匿名函数的方法
        //官方random
        randomAnnoymous(new Compare() {
            @Override
            public boolean process(Object o) {
                int bound = Integer.parseInt(String.valueOf(o));
                return random.nextInt(bound) < bound / 2;
            }
        }, area, bound);

        //自定义random
        randomAnnoymous(new Compare() {
            @Override
            public boolean process(Object o) {
                int bound = Integer.parseInt(String.valueOf(o));
                return random(bound) < bound / 2;
            }
        }, area, bound);

        //修改城lamba8



        //其实可以不用自己写的random，可以直接应用以下的代码
        System.out.print(random.nextInt(1000));
    }

    /**
     * 自定义方法，返回0到n之间的数
     *
     * @param n 产生数的范围
     * @return 位于0到n之间的数
     */
    static int random(int n) {
        //random.nextInt() 返回的是随机10位int型数
        return Math.abs(random.nextInt()) % n;
    }

    /**
     * 用官方的方法进行测试n比较大的情况,返回小于范围一半的数的个数
     *
     * @param area  测试用的总数量
     * @param bound 产生0到bound之间的数
     */
    static void randomOffical(int area, int bound) {
        int low = 0;
        for (int i = 0; i < area; i++)
            if (random.nextInt(bound) < bound / 2)
                low++;
        System.out.println(low);
    }

    /**
     * 用自定义的方法进行测试n比较大的情况,返回小于范围一半的数的个数
     *
     * @param area  测试用的总数量
     * @param bound 产生0到bound之间的数
     */
    static void randomNIsBig(int area, int bound) {
        int low = 0;
        for (int i = 0; i < area; i++)
            if (random(bound) < bound / 2)
                low++;
        System.out.println(low);
    }

    /**
     * 利用匿名函数将官方的方法和自定义的方法合为一个
     *
     * @param area 测试用的总数量
     * @param c    传递匿名函数
     */
    static void randomAnnoymous(Compare c, int area, int bound) {
        int low = 0;
        for (int i = 0; i < area; i++)
            if (c.process(bound))
                low++;
        System.out.println(low);
    }
}
