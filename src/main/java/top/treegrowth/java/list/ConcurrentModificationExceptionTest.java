package top.treegrowth.java.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author wusi
 * @version 2018/11/17.
 */
public class ConcurrentModificationExceptionTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Date currentTime = new Date();
        Integer[] riderIds = new Integer[]{1,
                4,
                13,
                16,
                22,
                25,
                28,
                31,
                34,
                37,
                40,
                43,
                46,
                49,
                52,
                55,
                58,
                61,
                64,
                67,
                70,
                73,
                76,
                79,
                85,
                88,
                91,
                94,
                100,
                103,
                106,
                112,
                115,
                118,
                121,
                124,
                130,
                133,
                136,
                139,
                142,
                145,
                148,
                154,
                157,
                160,
                166,
                172,
                175,
                178};
        for (Integer riderId : riderIds) {
            executorService.submit(new LoadAndStoreData(riderId));
        }
    }


    private static class LoadAndStoreData implements Runnable {

        private Integer riderId;

        public LoadAndStoreData(Integer riderId) {
            this.riderId = riderId;
        }

        @Override
        public void run() {

            try {
                System.out.println(atomicInteger.getAndIncrement());
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
