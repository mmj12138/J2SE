package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/20.
 */
public class Hand {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    Hand(String name){
        this.name=name;
    }
}
class People{
    private Hand lhand;
    private Hand rhand;
    People(){
        lhand = new Hand("◊Û ÷");
        rhand = new Hand("”“ ÷");
    }
    public static void main(String[] args) {
        People p = new People();
        System.out.println(p.lhand.getName());
    }
}
