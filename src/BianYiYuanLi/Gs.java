package BianYiYuanLi;

import java.io.Serializable;
import java.util.*;


/**
 * LL(1)�ķ��������жϹ���
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
     * Select����
     */
    private TreeMap<Character, HashMap<String, TreeSet<Character>>> selectMap;
    /**
     * LL��1���ķ���������
     */
    private ArrayList<String> gsArray;
    /**
     * ���ʽ����
     */
    private HashMap<Character, ArrayList<String>> expressionMap;
    /**
     * ��ʼ��
     */
    private Character s;
    /**
     * Vn���ս������
     */
    private TreeSet<Character> nvSet;
    /**
     * Vt�ս������
     */
    private TreeSet<Character> ntSet;
    /**
     * ���Ƴ��մ��ļ���
     */
    private TreeSet<Character> eSet;

    /**
     * First����
     */
    private HashMap<Character, TreeSet<Character>> firstMap;
    /**
     * Follow����
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
     * ��ȡ���ս�������ս����
     */
    public void getVnVt() {
        for (String gsItem : gsArray) {//gsArray�ǲ���ʽ�ķ�����
            String[] VnVtItem = gsItem.split("->");//���ҷָ
            String Vn = VnVtItem[0];//�󲿾��Ƿ��ս��
            char charVn = Vn.charAt(0);//Ϊ�˽�String ����ת����Char
            nvSet.add(charVn);//�ŵ����ս����������
        }
        System.out.print("�ķ��еķ��ս���У�");
        Iterator<Character> Nit = nvSet.iterator();
        while (Nit.hasNext()) {
            System.out.print(Nit.next() + " ");
        }
        System.out.println();
        for (String gsItem : gsArray) {
            String[] VnVtItem = gsItem.split("->");
            // nt���ұ�
            String Vt = VnVtItem[1];//����ʽ�Ҳ��ŵ����ַ�������
            // ����ÿһ����
            for (int i = 0; i < Vt.length(); i++) {
                char charVt = Vt.charAt(i);
                if (!nvSet.contains(charVt)) {//������Ƿ��ս����ô�����ս��
                    ntSet.add(charVt);//�ӵ����ս����������
                }
            }
        }
        System.out.print("�ķ��е��ս���У�");
        Iterator<Character> Tit = ntSet.iterator();
        while (Tit.hasNext()) {
            System.out.print(Tit.next() + " ");
        }
        System.out.println();
    }

    /**
     * ��ʼ�����ʽ����
     */
    public void initExpressionMaps() {//������ͬ�󲿲���ʽ��ʽ�ӣ����Ҳ�����һ��
        expressionMap = new HashMap<Character, ArrayList<String>>();
        for (String gsItem : gsArray) {
            String[] nvNtItem = gsItem.split("->");
            String charItemStr = nvNtItem[0];//��
            String charItemRightStr = nvNtItem[1];//�Ҳ�
            char charItem = charItemStr.charAt(0);//���ս��
            if (!expressionMap.containsKey(charItem)) {//��û�У����µ����
                ArrayList<String> expArr = new ArrayList<String>();
                expArr.add(charItemRightStr);
                expressionMap.put(charItem, expArr);
            } else {//����о������
                ArrayList<String> expArr = expressionMap.get(charItem);
                expArr.add(charItemRightStr);
                expressionMap.put(charItem, expArr);
            }
        }
        Set<Map.Entry<Character, ArrayList<String>>> ss = expressionMap.entrySet();
        System.out.println("���ķ�Ϊ��");
        for (Map.Entry<Character, ArrayList<String>> e : ss) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }

    }

    /**
     * ��ȡFirst��
     */
    public void getFirst() {
        System.out.print("���Ƴ��ŵķ��ս��Ϊ��");
        // ��������Nv,������ǵ�First����
        Iterator<Character> iterator = nvSet.iterator();
        while (iterator.hasNext()) {
            Character charItem = iterator.next();
            ArrayList<String> arrayList = expressionMap.get(charItem);//�Ҳ�ʽ�ӷŵ�arraylist����
            for (String itemStr : arrayList) {
                boolean shouldBreak = false;
                // Y1Y2Y3...Yk
                for (int i = 0; i < itemStr.length(); i++) {
                    char itemitemChar = itemStr.charAt(i);//����ʽ�Ҳ���ÿһ���ַ�
                    TreeSet<Character> itemSet = firstMap.get(charItem);
                    if (null == itemSet) {
                        itemSet = new TreeSet<Character>();
                    }

                    shouldBreak = calcFirst(itemSet, charItem, itemitemChar);
                    if (shouldBreak) {//true����һ�����ս����first������ɽ�����һ��
                        break;
                    }
                }
            }

        }
        System.out.println();
        System.out.println("���ķ���first��Ϊ��");
        Set<Map.Entry<Character, TreeSet<Character>>> ss = firstMap.entrySet();

        for (Map.Entry<Character, TreeSet<Character>> e : ss) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
    }

    /**
     * ����First����
     *
     * @param itemSet
     * @param charItem
     * @param itemitemChar
     * @return
     */
    private boolean calcFirst(TreeSet<Character> itemSet, Character charItem, char itemitemChar) {
        // get ago
        // TreeSet<Character> itemSet = new TreeSet<Character>();
        // ������ÿһλ��Nt�ж���
        // ���ս����մ�,��ֹͣ���������ӵ�FirstMap��
        if (itemitemChar == '��' || ntSet.contains(itemitemChar)) {//�Ҳ����Ϊ�գ��������ս��
            if (itemitemChar == '��')
                System.out.print(" " + charItem + "");
            itemSet.add(itemitemChar);
            firstMap.put(charItem, itemSet);
            return true;

        } else if (nvSet.contains(itemitemChar)) {
            // �����һ�����ս�������µݹ飬ֱ������ʽ���Ҳ�����ĸ���ս�����
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
     * ��ȡFollow����
     */
    public void getFollow() {
        for (Character tempKey : nvSet) {//�����ս���ҳ���������ŵ�followMap����
            TreeSet<Character> tempSet = new TreeSet<Character>();
            followMap.put(tempKey, tempSet);
        }
        // ��������Vn,������ǵ�Follow����
        Iterator<Character> iterator = nvSet.descendingIterator();//������

        while (iterator.hasNext()) {
            Character charItem = iterator.next();//ÿһ�����ս��
            Set<Character> keySet = expressionMap.keySet();
            for (Character keyCharItem : keySet) {
                ArrayList<String> charItemArray = expressionMap.get(keyCharItem);
                for (String itemCharStr : charItemArray) {
                    TreeSet<Character> itemSet = followMap.get(charItem);
                    calcFollow(charItem, charItem, keyCharItem, itemCharStr, itemSet);

                }
            }
        }
        System.out.println("���ķ���follow��Ϊ��");
        Set<Map.Entry<Character, TreeSet<Character>>> ss = followMap.entrySet();

        for (Map.Entry<Character, TreeSet<Character>> e : ss) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
    }

    /**
     * ����Follow��
     *
     * @param putCharItem ���ڲ�ѯitem
     * @param charItem    ����item
     * @param keyCharItem �ڵ���
     * @param itemCharStr ���ż�
     * @param itemSet     �������
     */
    private void calcFollow(Character putCharItem, Character charItem, Character keyCharItem, String itemCharStr,
                            TreeSet<Character> itemSet) {

        // ��1��A��S����ʼ��)������#
        if (charItem.equals(s)) {
            itemSet.add('#');
            followMap.put(putCharItem, itemSet);
        }
        // (2)Ab,=First(b)-��,ֱ������ս��
        if (TextUtil.containsAb(ntSet, itemCharStr, charItem)) {
            Character alastChar = TextUtil.getAlastChar(itemCharStr, charItem);
            itemSet.add(alastChar);
            followMap.put(putCharItem, itemSet);
        }
        // (2).2AB,=First(B)-��,=First(B)-�ţ����first����
        if (TextUtil.containsAB(nvSet, itemCharStr, charItem)) {
            Character alastChar = TextUtil.getAlastChar(itemCharStr, charItem);
            TreeSet<Character> treeSet = firstMap.get(alastChar);
            itemSet.addAll(treeSet);
            if (treeSet.contains('��')) {
                itemSet.add('#');
            }
            itemSet.remove('��');
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
        // (3)B->aA,=Follow(B),���followB
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
     * ��ȡSelect����
     */
    public void getSelect() {
        // ����ÿһ�����ʽ
        // HashMap<Character, HashMap<String, TreeSet<Character>>>
        Set<Character> keySet = expressionMap.keySet();
        for (Character selectKey : keySet) {
            ArrayList<String> arrayList = expressionMap.get(selectKey);
            // ÿһ�����ʽ
            HashMap<String, TreeSet<Character>> selectItemMap = new HashMap<String, TreeSet<Character>>();
            for (String selectExp : arrayList) {
                /**
                 * ���select����ļ���
                 */
                TreeSet<Character> selectSet = new TreeSet<Character>();
                // set���ŵ����ݷ�3�����,��selectExp����
                // 1.A->��,=follow(A)
                if (TextUtil.isEmptyStart(selectExp)) {
                    selectSet = followMap.get(selectKey);
                    selectSet.remove('��');
                    selectItemMap.put(selectExp, selectSet);
                }
                // 2.Nt��ʼ,=Nt
                // <br>�ս����ʼ
                if (TextUtil.isNtStart(ntSet, selectExp)) {
                    selectSet.add(selectExp.charAt(0));
                    selectSet.remove('��');
                    selectItemMap.put(selectExp, selectSet);
                }
                // 3.Nv��ʼ��=first(Nv)
                if (TextUtil.isNvStart(nvSet, selectExp)) {
                    selectSet = firstMap.get(selectKey);
                    selectSet.remove('��');
                    selectItemMap.put(selectExp, selectSet);
                }
                selectMap.put(selectKey, selectItemMap);
            }
        }
        System.out.println("���ķ���select��Ϊ��");
        Set<Map.Entry<Character, HashMap<String, TreeSet<Character>>>> ss = selectMap.entrySet();
        for (Map.Entry<Character, HashMap<String, TreeSet<Character>>> e : ss) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
    }

    /**
     * ����Ԥ�������
     */
    public void genAnalyzeTable() throws Exception {
        Object[] ntArray = ntSet.toArray();
        Object[] nvArray = nvSet.toArray();
        // Ԥ��������ʼ��
        analyzeTable = new String[nvArray.length + 1][ntArray.length + 1];
        System.out.println("���ʽ�ķ���Ԥ�������");
        // ���һ��ռλ��
        analyzeTable[0][0] = "Nv/Nt";
        System.out.printf("%6s", analyzeTable[0][0]);
        // ��ʼ������
        for (int i = 0; i < ntArray.length; i++) {
            if (ntArray[i].equals('��')) {
                ntArray[i] = '#';
            }
            System.out.printf("         %2c ", ntArray[i]);
            analyzeTable[0][i + 1] = ntArray[i] + "";
        }

        System.out.println("");
        for (int i = 0; i < nvArray.length; i++) {
            // ���г�ʼ��
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
     * �жϸ��ķ��Ƿ�ΪLL��1���ķ�
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
                                System.out.println("���жϣ����ķ�����LL(1)�ķ���");
                            }
                        }
                    }
                }
            }
        }
        if (flag) {
            System.out.println("���жϣ����ķ���LL(1)�ķ���");
        }
    }
}