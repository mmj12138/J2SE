package BianYiYuanLi;

import java.io.Serializable;
import java.util.*;


/**
 * LL(1)文法的主体判断过程
 */
public class Gs implements Serializable {
    private static final long serialVersionUID = 1L;

    public Gs() {
        super();
        gsArray = new ArrayList<String>();
        nvSet = new TreeSet<Character>();
        ntSet = new TreeSet<Character>();
        firstMap = new HashMap<Character, TreeSet<Character>>();
        followMap = new HashMap<Character, TreeSet<Character>>();
        selectMap = new TreeMap<Character, HashMap<String, TreeSet<Character>>>();
    }

    private String[][] analyzeTable;

    /**
     * Select集合
     */
    private TreeMap<Character, HashMap<String, TreeSet<Character>>> selectMap;
    /**
     * LL（1）文法产生集合
     */
    private ArrayList<String> gsArray;
    /**
     * 表达式集合
     */
    private HashMap<Character, ArrayList<String>> expressionMap;
    /**
     * 开始符
     */
    private Character s;
    /**
     * Vn非终结符集合
     */
    private TreeSet<Character> nvSet;
    /**
     * Vt终结符集合
     */
    private TreeSet<Character> ntSet;
    /**
     * 能推出空串的集合
     */
    private TreeSet<Character> eSet;

    /**
     * First集合
     */
    private HashMap<Character, TreeSet<Character>> firstMap;
    /**
     * Follow集合
     */
    private HashMap<Character, TreeSet<Character>> followMap;

    public TreeMap<Character, HashMap<String, TreeSet<Character>>> getSelectMap() {
        return selectMap;
    }

    public HashMap<Character, TreeSet<Character>> getFirstMap() {
        return firstMap;
    }

    public HashMap<Character, TreeSet<Character>> getFollowMap() {
        return followMap;
    }

    public HashMap<Character, ArrayList<String>> getExpressionMap() {
        return expressionMap;
    }

    public void setGsArray(ArrayList<String> gsArray) {
        this.gsArray = gsArray;
    }

    public Character getS() {
        return s;
    }

    public void setS(Character s) {
        this.s = s;
    }

    /**
     * 获取非终结符集与终结符集
     */
    public void getVnVt() {
        for (String gsItem : gsArray) {//gsArray是产生式文法集合
            String[] VnVtItem = gsItem.split("->");//左右分割开
            String Vn = VnVtItem[0];//左部就是非终结符
            char charVn = Vn.charAt(0);//为了将String 类型转化成Char
            nvSet.add(charVn);//放到非终结符集合里面
        }
        System.out.print("文法中的非终结符有：");
        Iterator<Character> Nit = nvSet.iterator();
        while (Nit.hasNext()) {
            System.out.print(Nit.next() + " ");
        }
        System.out.println();
        for (String gsItem : gsArray) {
            String[] VnVtItem = gsItem.split("->");
            // nt在右边
            String Vt = VnVtItem[1];//产生式右部放到了字符串里面
            // 遍历每一个字
            for (int i = 0; i < Vt.length(); i++) {
                char charVt = Vt.charAt(i);
                if (!nvSet.contains(charVt)) {//如果不是非终结符那么就是终结符
                    ntSet.add(charVt);//加到非终结符集合里面
                }
            }
        }
        System.out.print("文法中的终结符有：");
        Iterator<Character> Tit = ntSet.iterator();
        while (Tit.hasNext()) {
            System.out.print(Tit.next() + " ");
        }
        System.out.println();
    }

    /**
     * 初始化表达式集合
     */
    public void initExpressionMaps() {//具有相同左部产生式的式子，将右部合在一起
        expressionMap = new HashMap<Character, ArrayList<String>>();
        for (String gsItem : gsArray) {
            String[] nvNtItem = gsItem.split("->");
            String charItemStr = nvNtItem[0];//左部
            String charItemRightStr = nvNtItem[1];//右部
            char charItem = charItemStr.charAt(0);//非终结符
            if (!expressionMap.containsKey(charItem)) {//如没有，将新的添加
                ArrayList<String> expArr = new ArrayList<String>();
                expArr.add(charItemRightStr);
                expressionMap.put(charItem, expArr);
            } else {//如果有就新添加
                ArrayList<String> expArr = expressionMap.get(charItem);
                expArr.add(charItemRightStr);
                expressionMap.put(charItem, expArr);
            }
        }
        Set<Map.Entry<Character, ArrayList<String>>> ss = expressionMap.entrySet();
        System.out.println("此文法为：");
        for (Map.Entry<Character, ArrayList<String>> e : ss) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }

    }

    /**
     * 获取First集
     */
    public void getFirst() {
        System.out.print("能推出ε的非终结符为：");
        // 遍历所有Nv,求出它们的First集合
        Iterator<Character> iterator = nvSet.iterator();
        while (iterator.hasNext()) {
            Character charItem = iterator.next();
            ArrayList<String> arrayList = expressionMap.get(charItem);//右部式子放到arraylist里面
            for (String itemStr : arrayList) {
                boolean shouldBreak = false;
                // Y1Y2Y3...Yk
                for (int i = 0; i < itemStr.length(); i++) {
                    char itemitemChar = itemStr.charAt(i);//产生式右部的每一个字符
                    TreeSet<Character> itemSet = firstMap.get(charItem);
                    if (null == itemSet) {
                        itemSet = new TreeSet<Character>();
                    }

                    shouldBreak = calcFirst(itemSet, charItem, itemitemChar);
                    if (shouldBreak) {//true代表一个非终结符的first集合完成进行下一个
                        break;
                    }
                }
            }

        }
        System.out.println();
        System.out.println("此文法的first集为：");
        Set<Map.Entry<Character, TreeSet<Character>>> ss = firstMap.entrySet();

        for (Map.Entry<Character, TreeSet<Character>> e : ss) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
    }

    /**
     * 计算First函数
     *
     * @param itemSet
     * @param charItem
     * @param itemitemChar
     * @return
     */
    private boolean calcFirst(TreeSet<Character> itemSet, Character charItem, char itemitemChar) {
        // get ago
        // TreeSet<Character> itemSet = new TreeSet<Character>();
        // 将它的每一位和Nt判断下
        // 是终结符或空串,就停止，并将它加到FirstMap中
        if (itemitemChar == 'ε' || ntSet.contains(itemitemChar)) {//右部如果为空，或者是终结符
            if (itemitemChar == 'ε')
                System.out.print(" " + charItem + "");
            itemSet.add(itemitemChar);
            firstMap.put(charItem, itemSet);
            return true;

        } else if (nvSet.contains(itemitemChar)) {
            // 如果是一个非终结符，向下递归，直到产生式的右部首字母是终结符或空
            ArrayList<String> arrayList = expressionMap.get(itemitemChar);
            for (int i = 0; i < arrayList.size(); i++) {
                String string = arrayList.get(i);
                char tempChar = string.charAt(0);
                calcFirst(itemSet, charItem, tempChar);
            }
        }
        return true;
    }

    /**
     * 获取Follow集合
     */
    public void getFollow() {
        for (Character tempKey : nvSet) {//将非终结符找出来，将其放到followMap里面
            TreeSet<Character> tempSet = new TreeSet<Character>();
            followMap.put(tempKey, tempSet);
        }
        // 遍历所有Vn,求出它们的Follow集合
        Iterator<Character> iterator = nvSet.descendingIterator();//迭代器

        while (iterator.hasNext()) {
            Character charItem = iterator.next();//每一个非终结符
            Set<Character> keySet = expressionMap.keySet();
            for (Character keyCharItem : keySet) {
                ArrayList<String> charItemArray = expressionMap.get(keyCharItem);
                for (String itemCharStr : charItemArray) {
                    TreeSet<Character> itemSet = followMap.get(charItem);
                    calcFollow(charItem, charItem, keyCharItem, itemCharStr, itemSet);

                }
            }
        }
        System.out.println("此文法的follow集为：");
        Set<Map.Entry<Character, TreeSet<Character>>> ss = followMap.entrySet();

        for (Map.Entry<Character, TreeSet<Character>> e : ss) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
    }

    /**
     * 计算Follow集
     *
     * @param putCharItem 正在查询item
     * @param charItem    待找item
     * @param keyCharItem 节点名
     * @param itemCharStr 符号集
     * @param itemSet     结果集合
     */
    private void calcFollow(Character putCharItem, Character charItem, Character keyCharItem, String itemCharStr,
                            TreeSet<Character> itemSet) {

        // （1）A是S（开始符)，加入#
        if (charItem.equals(s)) {
            itemSet.add('#');
            followMap.put(putCharItem, itemSet);
        }
        // (2)Ab,=First(b)-ε,直接添加终结符
        if (TextUtil.containsAb(ntSet, itemCharStr, charItem)) {
            Character alastChar = TextUtil.getAlastChar(itemCharStr, charItem);
            itemSet.add(alastChar);
            followMap.put(putCharItem, itemSet);
        }
        // (2).2AB,=First(B)-ε,=First(B)-ε，添加first集合
        if (TextUtil.containsAB(nvSet, itemCharStr, charItem)) {
            Character alastChar = TextUtil.getAlastChar(itemCharStr, charItem);
            TreeSet<Character> treeSet = firstMap.get(alastChar);
            itemSet.addAll(treeSet);
            if (treeSet.contains('ε')) {
                itemSet.add('#');
            }
            itemSet.remove('ε');
            followMap.put(putCharItem, itemSet);
            if (TextUtil.containsbAbIsNull(nvSet, itemCharStr, charItem, expressionMap)) {
                char tempChar = TextUtil.getAlastChar(itemCharStr, charItem);
                if (!keyCharItem.equals(charItem)) {
                    Set<Character> keySet = expressionMap.keySet();
                    for (Character keyCharItems : keySet) {
                        ArrayList<String> charItemArray = expressionMap.get(keyCharItems);
                        for (String itemCharStrs : charItemArray) {
                            calcFollow(putCharItem, keyCharItem, keyCharItems, itemCharStrs, itemSet);
                        }
                    }
                }
            }
        }
        // (3)B->aA,=Follow(B),添加followB
        if (TextUtil.containsbA(nvSet, itemCharStr, charItem, expressionMap)) {
            if (!keyCharItem.equals(charItem)) {
                Set<Character> keySet = expressionMap.keySet();
                for (Character keyCharItems : keySet) {
                    ArrayList<String> charItemArray = expressionMap.get(keyCharItems);
                    for (String itemCharStrs : charItemArray) {
                        calcFollow(putCharItem, keyCharItem, keyCharItems, itemCharStrs, itemSet);
                    }
                }
            }
        }
    }

    /**
     * 获取Select集合
     */
    public void getSelect() {
        // 遍历每一个表达式
        // HashMap<Character, HashMap<String, TreeSet<Character>>>
        Set<Character> keySet = expressionMap.keySet();
        for (Character selectKey : keySet) {
            ArrayList<String> arrayList = expressionMap.get(selectKey);
            // 每一个表达式
            HashMap<String, TreeSet<Character>> selectItemMap = new HashMap<String, TreeSet<Character>>();
            for (String selectExp : arrayList) {
                /**
                 * 存放select结果的集合
                 */
                TreeSet<Character> selectSet = new TreeSet<Character>();
                // set里存放的数据分3种情况,由selectExp决定
                // 1.A->ε,=follow(A)
                if (TextUtil.isEmptyStart(selectExp)) {
                    selectSet = followMap.get(selectKey);
                    selectSet.remove('ε');
                    selectItemMap.put(selectExp, selectSet);
                }
                // 2.Nt开始,=Nt
                // <br>终结符开始
                if (TextUtil.isNtStart(ntSet, selectExp)) {
                    selectSet.add(selectExp.charAt(0));
                    selectSet.remove('ε');
                    selectItemMap.put(selectExp, selectSet);
                }
                // 3.Nv开始，=first(Nv)
                if (TextUtil.isNvStart(nvSet, selectExp)) {
                    selectSet = firstMap.get(selectKey);
                    selectSet.remove('ε');
                    selectItemMap.put(selectExp, selectSet);
                }
                selectMap.put(selectKey, selectItemMap);
            }
        }
        System.out.println("此文法的select集为：");
        Set<Map.Entry<Character, HashMap<String, TreeSet<Character>>>> ss = selectMap.entrySet();
        for (Map.Entry<Character, HashMap<String, TreeSet<Character>>> e : ss) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
    }

    /**
     * 生成预测分析表
     */
    public void genAnalyzeTable() throws Exception {
        Object[] ntArray = ntSet.toArray();
        Object[] nvArray = nvSet.toArray();
        // 预测分析表初始化
        analyzeTable = new String[nvArray.length + 1][ntArray.length + 1];
        System.out.println("表达式文法的预测分析表：");
        // 输出一个占位符
        analyzeTable[0][0] = "Nv/Nt";
        System.out.printf("%6s", analyzeTable[0][0]);
        // 初始化首行
        for (int i = 0; i < ntArray.length; i++) {
            if (ntArray[i].equals('ε')) {
                ntArray[i] = '#';
            }
            System.out.printf("         %2c ", ntArray[i]);
            analyzeTable[0][i + 1] = ntArray[i] + "";
        }

        System.out.println("");
        for (int i = 0; i < nvArray.length; i++) {
            // 首列初始化
            System.out.printf("%6c", nvArray[i]);
            analyzeTable[i + 1][0] = nvArray[i] + "";
            for (int j = 0; j < ntArray.length; j++) {
                String findUseExp = TextUtil.findUseExp(selectMap, Character.valueOf((Character) nvArray[i]),
                        Character.valueOf((Character) ntArray[j]));
                if (null == findUseExp) {
                    String sa = " ";
                    System.out.printf("%12s", sa);
                    analyzeTable[i + 1][j + 1] = "";
                } else {
                    String ss = nvArray[i] + "->" + findUseExp;
                    System.out.printf("%12s", ss);
                    analyzeTable[i + 1][j + 1] = nvArray[i] + "->" + findUseExp;
                }
            }
            System.out.println();
        }
    }

    /**
     * 判断该文法是否为LL（1）文法
     *
     */
    public void judgeLL() {

        boolean flag = true;
        Set<Map.Entry<Character, HashMap<String, TreeSet<Character>>>> ss = selectMap.entrySet();
        for (Map.Entry<Character, HashMap<String, TreeSet<Character>>> e : ss) {
            char judge[] = new char[20];
            Arrays.fill(judge, '0');
            int i = 0;
            HashMap<String, TreeSet<Character>> e2 = e.getValue();
            Set<String> e3 = e2.keySet();
            for (String m : e3) {
                TreeSet<Character> t1 = e2.get(m);
                for (char x : t1) {
                    if (x != '[' && x != ']' && x != ' ')
                        judge[i] = x;
                    i++;
                }
            }
            for (int j = 0; j < judge.length - 1; j++) {
                if (judge[j] != '0') {
                    for (int k = j + 1; k < judge.length; k++) {
                        if (judge[k] != '0') {
                            if (judge[j] == judge[k]) {
                                flag = !flag;
                                System.out.println("经判断，此文法不是LL(1)文法！");
                            }
                        }
                    }
                }
            }
        }
        if (flag) {
            System.out.println("经判断，此文法是LL(1)文法！");
        }
    }
}