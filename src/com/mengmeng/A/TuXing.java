package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class TuXing {
    static void round(){
        for(int i = 1;i<=100;i++){
            System.out.print(i+" ");
        }
    }
    static void round2(){
        int count = 0;
        for(int i = 1;i<=100;i++){
            count = count+i;
            System.out.print(count+" ");
        }
    }
    static void star(){
        for(int i = 0;i<3;i++){
            for(int j=0;j<7;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void star2(int l){
        for(int i = 1;i<=l;i++){
            for(int j = 1;j<=2*i;j++){
                System.out.print("*");
            }
            for(int k = 1;k <=4*l-4*i+2;k++){
                System.out.print(" ");
            }
            for(int m = 1;m<=2*i;m++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0;i<l;i++){
            for(int j = 1;j<=2*l-2*i;j++){
                System.out.print("*");
            }
            for(int k = 1;k <=4*i+2;k++){
                System.out.print(" ");
            }
            for(int m = 1;m<=2*l-2*i;m++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void shuZi(){
        for(int i = 1;i<=4;i++){
            for(int j = 1;j<=2*i;j++){
                int m=2*i;
                System.out.print(m);
            }
            System.out.println();
        }
    }
    static void shuZi2(){
        for(int i = 1;i<=4;i++){
            for(int j = 1;j<=8-2*(i-1);j++){
                int m=8-2*(i-1);
                System.out.print(m);
            }
            for(int k = 1;k<=4*(i-1);k++){
                System.out.print(" ");
            }
            for(int j = 1;j<=8-2*(i-1);j++){
                int m=8-2*(i-1);
                System.out.print(m);
            }
            System.out.println();
        }
        for(int i = 1;i<=4;i++){
            for(int j = 1;j<=2*i;j++){
                int m=2*i;
                System.out.print(m);
            }
            for(int k = 1;k<=16-4*i;k++){
                System.out.print(" ");
            }
            for(int j = 1;j<=2*i;j++){
                int m=2*i;
                System.out.print(m);
            }
            System.out.println();
        }
    }
    static void jian1(){
        for(int i=1;i<=11;i++){
            for(int j=1;j<=34-2*i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void jian2(){
        for(int i=1;i<=11;i++){
            for(int j=1;j<=i;j++){
                System.out.print(" ");
            }
            for(int k = 1;k<=12-i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void jiang(){
        int [] arr =new int[4];
        for(int i=0;i<4;i++){
            int randNumber = (int) (Math.random()*2);
            System.out.print(randNumber);
            arr[i]=randNumber;
        }
        System.out.println();
        if(arr[0]==1&&arr[1]==1&&arr[2]==1&&arr[3]==1){
            System.out.println("一等奖");
        }else if(arr[0]==1&&arr[1]==1&&arr[2]==1&&arr[3]==0){
            System.out.println("二等奖");
        }else if(arr[0]==1&&arr[1]==1&&arr[2]==0&&arr[3]==0){
            System.out.println("三等奖");
        }else{
            System.out.println("没有中奖");
        }
    }
    /*
        a
        aba
        abcba
        abcdcba
        abcdedcba
     */

    static void aba(){
        for(int i=1;i<=5;i++){
            int t = 97;
            int t2=100;
            for(int j=1;j<=i;j++){
                char s = (char)t;
                System.out.print(s);
                t++;
            }
            t--;
            for(int k = 1;k<=i-1;k++ ){
                t--;
                char s = (char)t;
                System.out.print(s);

            }
            System.out.println();
        }
    }

    static void money(){
        float money=0;
        int day = 0;
        while(money<=100){
            day++;
            money+=2.5f;
            if(day%5==0){
                money-=6;
            }
        }
        System.out.println(day);
    }

    static void array(){
        int [] arr = {9,1,34,15,14,4};
        int i = 0;
        int temp = 0;
        do{
            if(arr[i]>=arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            i++;
        }while(i<arr.length-1);
        temp = arr[arr.length-1];
        System.out.println(temp);
    }

    public static void main(String[] args) {
        //round();
//        System.out.println();
//    round2();
//        int l = 5;
//        star2(l);
//        shuZi2();
    }
}
