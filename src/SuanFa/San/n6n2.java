package SuanFa.San;


import java.util.Scanner;
/*
分析：
这道题找规律：要解决两个问题，一个是括号嵌套，一个是是否去括号。

是否去括号：以运算等级1为加减，2位乘除加减。括号内为1外1去括号，括号内为1外2不去括号，
括号内为2外1去括号，括号内为2外2去括号。（注意，这里的内的符号不包括嵌套括号里面的符号）

括号嵌套：控制循环判断的下标。
 */
public class n6n2 {

    private static final char REC = 10; ////如果该括号需要删除就标记为REC
    private static char[] a;
    private static int len;

    public static void main(String[] args) {
        int i;
        Scanner scanner = new Scanner(System.in);
        a = scanner.next().toCharArray();
        len = a.length;
        fun(0);
        for(i = 0; i < len; i ++){
            if(a[i] != REC){
                System.out.printf("%c", a[i]);
            }
        }
    }

    public static int judge (int k) {
        int outGrade = 0;   //括号两边外的符号： 0 说明左右没符号； 运算等级1左右只是加减；运算等级2左右至少有一个乘除
        int inGrade = 0;    //两边括号内部的符号 （部包括内嵌括号里的符号） ： 运算等级1只有加减，运算等级2至少有一个乘除
        int num = 1;    //标记i循环到第几层嵌套的括号  一开始只有一层
        int i;
        int re = 0; //函数返回 （如果没内嵌括号返回右括号下标，如果有内嵌括号返回内嵌括号的左括号-1，因为函数返回到fun（）的for语句会自增到左括号下标）
        int judge = 0;  //标记记录最左边的内嵌括号做为返回

        for(i = k+1; i < len && num > 0; i ++){   //退出的条件是完全退出括号
            if(a[i] == '('){    //嵌多一层括号
                num ++;
                if(judge == 0){
                    re = i-1;
                    judge = 1;
                }
            }

            if(num == 1){   //需要计算第一层括号内的符号运算等级
                if(inGrade == 0){
                    if(a[i] == '+' || a[i] == '-'){
                        inGrade = 1;
                    } else if(a[i] == '*' || a[i] == '/') {
                        inGrade = 2;
                    }
                }
                if(inGrade == 1){
                    if(a[i] == '*' || a[i] == '/'){
                        inGrade = 2;
                    }
                }
            }
            if(a[i] == ')'){//退出一层括号
                num --;
            }
        }
        i --;   //for退回指向有括号的下标
    /*

    k 为左括号下标
    i 为有括号下标

    */

        outGrade = 0;
        if(k-1 > -1){    //左边有符号
            if(a[k-1] == '+' || a[k-1] == '-'){
                outGrade = 1;
            } else{
                outGrade = 2;
            }
        }
        if(outGrade == 0 || outGrade == 1){ //运算阶级是否需要提高
            if(i+1 < len){   //右边有符号
                if(a[i+1] == '+' || a[i+1] == '-'){
                    outGrade = 1;
                } else {
                    outGrade = 2;
                }
            }
        }

        //  printf("%d\n%d %d\n", i, inGrade, outGrade);
        if(inGrade == 0){   //内部没符号比如 2+5+（）-2的情况
            a[k] = REC;
            a[i] = REC;
        } else if(inGrade == 1){
            if(outGrade == 1){  //内为1（加减），外为1 （加减）去括号
                a[k] = REC;
                a[i] = REC;
                return i+1;
            } else {    //内为1（加减），外为2 （加减）不去括号
            }
        } else if(inGrade == 2){    //内为2（加减），外为2或1 （加减）去括号
            a[k] = REC;
            a[i] = REC;
        }
        if(re == 0) {
            re = i;
        }
        return re;
    }

    public static void fun (int k) {
        for(int i = 0; i < len; i ++){
            if(a[i] != '('){

            } else {    //返回右括号的有下标
                i = judge(i);   //控制下标处理嵌套括号
            }
        }
    }
}
