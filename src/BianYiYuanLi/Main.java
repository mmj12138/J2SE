package BianYiYuanLi;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        // // LL��1���ķ���������
        ArrayList<String> gsArray = new ArrayList<String>();
        Gs gs = new Gs();
        initGs(gsArray);
        gs.setGsArray(gsArray);
        gs.initExpressionMaps();
        gs.getVnVt();
        gs.getFirst();
        // ���ÿ�ʼ��
        gs.setS('E');
        gs.getFollow();
        gs.getSelect();
        // Ԥ�������
        gs.genAnalyzeTable();
        gs.judgeLL();
    }

    /**
     * ��ʼ��LL(1)�ķ�
     */
    private static void initGs(ArrayList<String> gsArray) {
        gsArray.add("E->TA");
        gsArray.add("A->��");
        gsArray.add("A->+TA");
        gsArray.add("T->FB");
        gsArray.add("B->*FB");
        gsArray.add("B->��");
        gsArray.add("F->(E)");
        gsArray.add("F->i");


    }
}
