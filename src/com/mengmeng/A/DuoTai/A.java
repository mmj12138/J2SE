package com.mengmeng.A.DuoTai;

/**
 * Created by Administrator on 2017/11/28.
 */
public class A extends A1{
    public static void main(String[] args) {
        A a = new A();
        A1 a1 = new A();
        ((A)a1).to();
        ((A) a1).mark(new A0());
        a.mark1(1).go();
    }
    A1 mark1(int i){
        if(i==1) {
            return new A1();
        }else{
            return new A0();
        }
    }
    void mark(A1 a1){
        a1.go();
    }
    void go(){
        System.out.println("A");
    }
    void to(){
        System.out.println("to");
    }
}
class A0 extends A1{
    void go(){
        System.out.println("A0");
    }
}
class A1{
    void go(){
        System.out.println("A1");
    }
}
