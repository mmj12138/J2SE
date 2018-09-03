package BianYiYuanLi;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        // // LL（1）文法产生集合
        ArrayList<String> gsArray = new ArrayList<String>();
        Gs gs = new Gs();
        initGs(gsArray);
        gs.setGsArray(gsArray);
        gs.initExpressionMaps();
        gs.getVnVt();
        gs.getFirst();
        // 设置开始符
        gs.setS('E');
        gs.getFollow();
        gs.getSelect();
        // 预测分析表
        gs.genAnalyzeTable();
        gs.judgeLL();
    }

    /**
     * 初始化LL(1)文法
     */
    private static void initGs(ArrayList<String> gsArray) {
        gsArray.add("E->TA");
        gsArray.add("A->ε");
        gsArray.add("A->+TA");
        gsArray.add("T->FB");
        gsArray.add("B->*FB");
        gsArray.add("B->ε");
        gsArray.add("F->(E)");
        gsArray.add("F->i");


    }
}
