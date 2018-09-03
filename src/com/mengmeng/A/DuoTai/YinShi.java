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
        System.out.println("中国人吃饺子！");
    }
}
class Japanese extends YinShi{
    public void eat(){
        System.out.println("日本人吃寿司");
    }
}
class Kreaner extends YinShi{
    public void eat(){
        System.out.println("韩国人吃泡菜");
    }
}
class Test{
    public static void main(String[] args) {
        String str = "中国人";
        new Test().xuanZe(str).eat();
    }
    YinShi xuanZe(String str){
        if(str.equals("中国人")){
            return new Chinese();
        }else if(str.equals("韩国人")){
            return new Kreaner();
        }else{
            return new Japanese();
        }
    }
}
