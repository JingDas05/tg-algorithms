package top.treegrowth.parallelism.chapter4;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wusi
 * @version 2017/3/13 7:33.
 */
public class AtomicReferenceTest {
    static AtomicReference<Integer> money = new AtomicReference<>();

    public static void main(String[] args) {
        money.set(19);

        //小于20元的自动充值20元
        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.get();
                            if (m < 20) {
                                System.out.println("余额小于20元，充值成功，余额：" + money.get() + "元");
                                break;
                            } else {
                                System.out.println("余额大于20元，无需充值");
                                break;
                            }
                        }
                    }
                }
            }.start();
        }

        //用户消费线程，模拟消费行为
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {

                    }
                }
            }
        }.start();
    }
}
