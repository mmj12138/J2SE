package com.mengmeng.A.Goods;

import java.util.List;
/**
 * Created by Administrator on 2017/12/11.
 */
public class Test {
    public List<Goods> buy(Goods ngoods){
        List<Goods> list=Cart.getList();
        boolean flag=false;
        for(int i=0;i<list.size();i++){
            Goods ogoods =list.get(i);//����Ʒ
            if(ngoods.getNo().equals(ogoods.getNo())){//����Ʒ����
                ogoods.setQuantity(ogoods.getQuantity()+ngoods.getQuantity());//������Ʒ����
                flag=true;//����Ʒ�����
            }
        }
        if(!flag){//������Ʒ
            list.add(ngoods);
        }
        return list;

    }
    public static void main(String[] args) {
        Test c= new Test();

        c.buy(new Goods("001","ţ��",1.2f,10));
        c.buy(new Goods("001","ţ��",1.2f,2));
        c.buy(new Goods("002","��ţ",1.4f,10));
        List<Goods> list=c.buy(new Goods("003","ţ��",2.4f,5));
        for(Goods goods :list){
            System.out.println(goods.getNo()+"-"+goods.getName()+"-"+goods.getPrice()+"-"+goods.getQuantity());
        }

    }
}
