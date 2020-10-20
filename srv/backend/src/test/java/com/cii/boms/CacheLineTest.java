package com.cii.boms;

import sun.misc.Contended;

/**
 * @description
 * @auth david·cun
 * @date 2020-05-20 21:39
 * @since 1.0
 */
public class CacheLineTest {

    //此注解需要增加jvm参数才生效，-XX:-RestrictContended，变成静态属性之后测试不出效果，此处待解释
    @Contended
    public volatile long x;
    @Contended
    public volatile long y;

    //volatile表示保证线程之间可见线，线程之间是安全的
    //一个缓存行64字节，一个long类型8字节，2个long在一个缓存行
    public static volatile long[] l1 = new long[2];
    //一个缓存行64字节，一个long类型8字节，16个就恰好分在两个缓存行
    public static volatile long[] l2 = new long[16];


    public static void main(String[] args) throws InterruptedException {

//        cacheLineAlignL1Test();
//        cacheLineAlignL2Test();

        //执行如下方法的时候分开去掉Contended注解在执行进行对比测试
//        contendedTest();

    }


    public static void contendedTest() throws InterruptedException {

        CacheLineTest cl = new CacheLineTest();

        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 10000_0000L; i++) {
                cl.x = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 10000_0000L; i++) {
                cl.y = i;
            }
        });

        long start = System.nanoTime();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(((System.nanoTime() - start) / 1000 / 1000));


    }

    public static void cacheLineAlignL1Test() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000_0000L; i++) {
                l1[0] = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000_0000L; i++) {
                l1[1] = i;
            }
        });

        long start = System.nanoTime();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(((System.nanoTime() - start) / 1000 / 1000));

    }
    public static void cacheLineAlignL2Test() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000_0000L; i++) {
                l2[0] = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 10000_0000L; j++) {
                l2[8] = j;
            }
        });

        long start = System.nanoTime();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(((System.nanoTime() - start) / 1000 / 1000));
        ;
    }
}
