package com.github.kyrenesjtv.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

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


    private static String testFunction(Apple apple, Function<Apple, String> function) {
        return function.apply(apple);
    }

    private static Apple testBiFunction(String color, long weight, BiFunction<String, Long, Apple> biFunction) {
        return biFunction.apply(color, weight);
    }

    private static Apple testSupplier(Supplier<Apple> supplier) {
        return supplier.get();
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

        //        simpleBiConsumer("apple", apples, (a, s) -> System.out.println(a + s));

        //        String  resultString = testFunction(new Apple("Yelloe", 120), (a) -> a.toString());
        //        System.out.println(resultString);

        //        IntFunction<Double> resultInt = (i) -> i * 10.00d;
        //        Double apply = resultInt.apply(10);
        //        System.out.println(apply);

        //        Apple apple = testBiFunction("yellow", 150, (s, w) -> new Apple(s, w));
        //        System.out.println(apple);


        //        Supplier<String> s = String ::new;
        //        System.out.println(s.get().getClass());

        Apple apple = testSupplier(() -> new Apple("bule", 100));

        System.out.println(apple);

    }

    private static void process(Runnable r) {
        r.run();
        ;
    }


}
