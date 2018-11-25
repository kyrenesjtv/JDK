package com.github.kyrenesjtv.day6;

import java.lang.reflect.Type;

/**
 * @ProjectName: JDK8
 * @Author: wanglin
 * @CreateDate: 2018/11/25 22:10
 */
public class Dish {

    private final String name;

    private final boolean vegetarian;

    private final int calories;

    private Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" + "name='" + name + '\'' + ", vegetarian=" + vegetarian + ", calories=" + calories + ", type=" + type + '}';
    }

    public enum Type{MEAT,FISH,OTHER}
}
