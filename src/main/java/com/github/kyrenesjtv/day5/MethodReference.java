package com.github.kyrenesjtv.day5;

import com.github.kyrenesjtv.day4.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ProjectName: JDK8
 * @Author: wanglin
 * @CreateDate: 2018/11/21 22:12
 */
public class MethodReference {

    private static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
    }


    public static void main(String[] args) {
//        Consumer<String> consumer = (s) -> System.out.println(s);
//        useConsumer(consumer, "hello");
//
//        useConsumer((s) -> System.out.println(s), "hello");
//
//        useConsumer(System.out::println, "hello");

        /*******************************************************************************************/
        List<Apple> apples = Arrays.asList(new Apple("green", 11), new Apple("red", 22), new Apple("pink", 33), new Apple("black", 44));

        apples.sort((a1,a2)->{
            return a1.getColor().compareTo(a2.getColor());
        });
        System.out.println(apples);

        apples.stream().forEach((a)-> System.out.println(a));

        apples.stream().forEach(System.out::println);

        /*******************************************************************************************/
        int value = Integer.parseInt("123");

        //jdk8 中 可以用 ::  来访问类的 构造方法,静态方法，对象方法   ::new 是构造方法
        Function<String,Integer> f = Integer::parseInt;
        Integer apply = f.apply("123");

        BiFunction<String, Integer, Character> f2 = String::charAt;
        Character hello = f2.apply("hello", 2);

        String hello1 = new String("hello");
        Function<Integer, Character> f3 = hello1::charAt;
        f3.apply(4);

        Supplier<String> supplier = String::new;
        String s = supplier.get();

        BiFunction<String,Long,Apple> bi= Apple::new;
        Apple blue = bi.apply("blue", 100L);
        System.out.println(blue);

        /*******************************************************************************************/
        apples.sort(Comparator.comparing(Apple::getColor));
        System.out.println(apples);

    }


}
