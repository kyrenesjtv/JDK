package com.github.kyrenesjtv.day6;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @ProjectName: JDK8
 * @Author: wanglin
 * @CreateDate: 2018/11/25 22:09
 */
public class SimpleStream {


    private static List<String> getDishNamesByCollections(List<Dish> menu){
        List<Dish> lowColories = new ArrayList<>();
        for(Dish d :menu){
            if(d.getCalories()<400){
                lowColories.add(d);
            }
        }
        Collections.sort(lowColories,(o1,o2)->Integer.compare(o1.getCalories(),o2.getCalories()));

        List<String> dishNamesList = new ArrayList<>();
        for(Dish d :lowColories){
            dishNamesList.add(d.getName());
        }
        return dishNamesList;
    }

    private static List<String> getDishNamesByStram(List<Dish> menus){
       return menus.stream().filter((d) -> d.getCalories()<400)
                .sorted(Comparator.comparing(Dish ::getCalories)).map(Dish::getName).collect(toList());
    }

    public static void main(String[] args) {
        List<Dish>  menu = Arrays.asList(
                new Dish("pork",false,800,Dish.Type.MEAT),
                new Dish("beef",false,700,Dish.Type.MEAT),
                new Dish("chicken",false,400,Dish.Type.MEAT),
                new Dish("french",true,530,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("season fruit",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300,Dish.Type.FISH),
                new Dish("salmon",false,450,Dish.Type.FISH)
        );

        List<String> dishNamesByCollections = getDishNamesByCollections(menu);
        System.out.println(dishNamesByCollections);
        List<String> dishNamesByStram = getDishNamesByStram(menu);
        System.out.println(dishNamesByStram);
    }


}
