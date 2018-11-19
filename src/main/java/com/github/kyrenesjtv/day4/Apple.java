package com.github.kyrenesjtv.day4;

/**
 * @ProjectName: JDK8
 * @Author: wanglin
 * @CreateDate: 2018/11/15 23:56
 */
public class Apple {

    private String color;

    private long weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public Apple(String color, long weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
    }
}
