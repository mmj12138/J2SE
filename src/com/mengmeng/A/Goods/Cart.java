package com.mengmeng.A.Goods;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/12/11.
 */
public class Cart {//¹ºÎï³µ
    private static List<Goods> list=new ArrayList();
    private Cart(){

    }

    public static List<Goods> getList() {
        return list;
    }
}
