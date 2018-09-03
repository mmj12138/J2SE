package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/20.
 */
public class Computer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class User{
    private Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        user.setComputer(computer);
        computer.setName("µçÄÔ");
        System.out.println(user.getComputer().getName());
    }
}
