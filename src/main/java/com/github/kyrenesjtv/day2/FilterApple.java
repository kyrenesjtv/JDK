package com.github.kyrenesjtv.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: JDK8
 * @Author: wanglin
 * @CreateDate: 2018/11/15 23:57
 */
public class FilterApple {

    public static List<Apple> finfGreenApple(List<Apple> apples){
        List<Apple> resultList = new ArrayList<>();
        for(Apple apple :apples){
            if("green".equals(apple.getColor())){
                resultList.add(apple);
            }
        }
        return resultList;
    }

    public static List<Apple> finfGreenApple(List<Apple> apples, String color){
        List<Apple> resultList = new ArrayList<>();
        for(Apple apple :apples){
            if(color.equals(apple.getColor())){
                resultList.add(apple);
            }
        }
        return resultList;
    }


    public interface AppleFilter{
        boolean filter(Apple apple);
    }

    public static class GreenAppleAnd1600WeightFilter implements AppleFilter{

        @Override
        public boolean filter(Apple apple) {
            return ("green".equals(apple.getColor()))&&(apple.getWeight() ==1600);
        }
    }

    public static List<Apple> finfGreenApple(List<Apple> apples, AppleFilter appleFilter){
        List<Apple> resultList = new ArrayList<>();
        for(Apple apple :apples){
            if(appleFilter.filter(apple)){
                resultList.add(apple);
            }
        }
        return resultList;
    }



    public static void main(String[] args) throws InterruptedException {
        // step 1
        List<Apple> apples = Arrays.asList(new Apple("green",1600),new Apple("red",1700),new Apple("pink",1800),new Apple("black",1900));
        List<Apple> apples1 = finfGreenApple(apples);
        System.out.println(apples1);

        //step 2
        List<Apple> apples2 = finfGreenApple(apples,"red");
        System.out.println(apples2);

        //step 3 策略模式
        List<Apple> apples3 = finfGreenApple(apples,new GreenAppleAnd1600WeightFilter());
        System.out.println(apples3);

        //匿名内部类
        List<Apple> apples4 = finfGreenApple(apples, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return ("red".equals(apple.getColor()))&&(apple.getWeight() ==1700);
            }
        });
        System.out.println(apples4);


        //lambda 表达式
        List<Apple> lambdaResult = finfGreenApple(apples, (Apple apple) -> {
            return apple.getColor().equals("green");
        });
        System.out.println(lambdaResult);

        //能够接收Lambda表达式的参数类型，是一个只包含一个方法的接口。只包含一个方法的接口称之为“函数接口”。
        //  一般来说可以lambda的 接口名上面都会加@FunctionalInterface

        //普通的
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        //lambda
        new Thread(()->System.out.println(Thread.currentThread().getName())).start();

        Thread.currentThread().join();
    }



}
