package com.ybd.service;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 *
 * 缓存击穿测试
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
public class CachePierceTest {


    private final static String userCode = "UC00000003";

    private final static int threadNum = 2000;

    private CountDownLatch countDownLatch = new CountDownLatch(threadNum);

    private final static int count = 1000000;



    @Test
    public void testBloomFilter() {
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),count,0.01);
        Set<String> sets = new HashSet<>();
        List<String> lists = new ArrayList<>();
        for (int i=0 ; i < count ; i++) {
            String uuid = UUID.randomUUID().toString();
            bloomFilter.put(uuid);
            lists.add(uuid);
            sets.add(uuid);
        }

        int right = 0;
        int wrong = 0;
        for (int i=0 ; i < 10000 ; i++) {
            String str = i % 100 == 0 ? lists.get(i) : UUID.randomUUID().toString();
            if (bloomFilter.mightContain(str)) {
                if (sets.contains(str)) {
                    right ++;
                } else {
                    wrong ++;
                }
            }
        }
        System.out.println("right = " + right);
        System.out.println("wrong = " + wrong);
    }





    @Test
    public void testMultiThreadRequest() {
        for (int i=0; i < threadNum ; i++) {
            new Thread(new UserRequest()).start();
            countDownLatch.countDown();
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testTime() {
        System.out.println(new Date().getTime());
    }


    private class UserRequest implements Runnable {
        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String uuid = UUID.randomUUID().toString();
            //testCache(uuid);
        }
    }

}
