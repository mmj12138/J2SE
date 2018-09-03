package com.mengmeng.A;

/**
 * Created by Administrator on 2017/11/19.
 */
public class SanWei {
    static void sanWei(){
        int [][][] c = {{{1,2,3},{1,2,3,4},{1,2,3}},{{2,3,4,5},{1,2}},{{4,5,6,7},{1},{3,4,5,6}}};
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[i].length;j++){
                for(int k=0;k<c[i][j].length;k++){
                    System.out.print(c[i][j][k]+" ");
                }
            }
        }
        System.out.println();
        for(int [][] i: c){
            for(int [] j:i){
                for(int k:j){
                    System.out.print(k+" ");
                }
            }
        }
    }

    public static void main(String[] args) {
        sanWei();
    }
}
