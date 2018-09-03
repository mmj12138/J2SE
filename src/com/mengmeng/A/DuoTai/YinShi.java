package com.mengmeng.A.DuoTai;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Administrator on 2017/11/28.
 */
abstract public class YinShi {
    abstract public void eat();
}
class Chinese extends YinShi{
    public void eat(){
        System.out.println("�й��˳Խ��ӣ�");
    }
}
class Japanese extends YinShi{
    public void eat(){
        System.out.println("�ձ��˳���˾");
    }
}
class Kreaner extends YinShi{
    public void eat(){
        System.out.println("�����˳��ݲ�");
    }
}
class Test{
    public static void main(String[] args) {
        String str = "�й���";
        new Test().xuanZe(str).eat();
    }
    YinShi xuanZe(String str){
        if(str.equals("�й���")){
            return new Chinese();
        }else if(str.equals("������")){
            return new Kreaner();
        }else{
            return new Japanese();
        }
    }
}
