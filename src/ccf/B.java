package ccf;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/17.
 */
public class B {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String ss = sc.next();
        String [] s = ss.split("-");
        char [] cc1 = s[0].toCharArray();
        char [] cc2 = s[1].toCharArray();
        char [] cc3 = s[2].toCharArray();
        char [] cc4 = s[3].toCharArray();
        //0-670-82162-4
        int sum = (cc1[0]-48)*1+(cc2[0]-48)*2+(cc2[1]-48)*3+(cc2[2]-48)*4+(cc3[0]-48)*5+(cc3[1]-48)*6+(cc3[2]-48)*7+(cc3[3]-48)*8+(cc3[4]-48)*9;
        int temp = sum%11;
        if(temp==10){
            if(cc4[0]=='X'){
                ss="Right";
            }else{
                ss=String.valueOf(cc1)+"-"+String.valueOf(cc2)+"-"+String.valueOf(cc3)+"-"+"X";
            }
        }else{
            if((cc4[0]-48)==temp){
                ss="Right";
            }else{
                ss=String.valueOf(cc1)+"-"+String.valueOf(cc2)+"-"+String.valueOf(cc3)+"-"+String.valueOf(temp);
            }
        }
        System.out.println(ss);
    }
}
