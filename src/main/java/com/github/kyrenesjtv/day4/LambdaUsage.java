package com.github.kyrenesjtv.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @ProjectName: JDK8
 * @Author: wanglin
 * @CreateDate: 2018/11/19 23:05
 */
public class LambdaUsage {

    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    //    @FunctionalInterface   不是一个能够lambda的，重载了
    //    public interface SmartAdder extends Adder{
    //        int add(long a,long b);
    //    }

    //    @FunctionalInterface
    //    是可以的，
    //    public interface Nothing extends Adder{
    //    }

    //    @FunctionalInterface
    //    不可以的， 没有任何方法
    //    public interface Empty {
    //    }

    public static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> source, Predicate<Long> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple.getColor(), apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }


    private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple);
        }
    }

    private static void simpleBiConsumer(String c, List<Apple> source, BiConsumer<Apple, String> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple, c);
        }
    }


    public static void main(String[] args) {

        //        Runnable r1 = () -> System.out.println("hello world");
        //
        //        Runnable r2 = new Runnable() {
        //            @Override
        //            public void run() {
        //                System.out.println("hello world");
        //            }
        //        };
        //
        //        process(r1);
        //        process(r2);
        //        process(() -> System.out.println("hello world"));

        //        List<Apple> apples = Arrays.asList(new Apple("green", 120), new Apple("red", 130), new Apple("pink", 140), new Apple("black", 150));
        //        List<Apple> results = filter(apples, (e) -> e.getColor().equals("green"));
        //        System.out.println(results);


        //        List<Apple> apples = Arrays.asList(new Apple("green", 11), new Apple("red", 22), new Apple("pink", 33), new Apple("black", 44));
        //        List<Apple> results = filterByWeight(apples,(e) -> e >33 );
        //        System.out.println(results);

        List<Apple> apples = Arrays.asList(new Apple("green", 11), new Apple("red", 22), new Apple("pink", 33), new Apple("black", 44));
        //        List<Apple> results = filterByBiPredicate(apples, (string, weight) -> string.equals("green") && weight > 10);
        //        System.out.println(results);

        //        simpleTestConsumer(apples,(a)-> System.out.println(a));

        simpleBiConsumer("apple", apples, (a, s) -> System.out.println(a + s));

    }

    private static void process(Runnable r) {
        r.run();
        ;
    }


}
