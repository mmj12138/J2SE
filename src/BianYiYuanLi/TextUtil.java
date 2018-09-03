package BianYiYuanLi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *  �ַ�������
 */
public class TextUtil {
    /**
     * (3)B->aA,=Follow(B)
     */
    public static boolean containsbA(TreeSet<Character> nvSet, String itemCharStr, Character a,
                                     HashMap<Character, ArrayList<String>> expressionMap) {
        String aStr = a.toString();//��a����ַ���
        String lastStr = itemCharStr.substring(itemCharStr.length() - 1);
        if (lastStr.equals(aStr)) {
            return true;
        }
        return false;

    }

    /**
     * ����aBb,b=��
     */
    public static boolean containsbAbIsNull(TreeSet<Character> nvSet, String itemCharStr, Character a,
                                            HashMap<Character, ArrayList<String>> expressionMap) {
        String aStr = a.toString();
        if (containsAB(nvSet, itemCharStr, a)) {
            Character alastChar = getAlastChar(itemCharStr, a);
//            System.out.println("���Ϻ�ľ��ӣ�" + expressionMap.toString());
            ArrayList<String> arrayList = expressionMap.get(alastChar);
            if (arrayList.contains("��")) {
//                System.out.println(alastChar + " �����Ƴ��մ�����" + aStr+"��");
                return true;
            }
        }
        return false;

    }

    /**
     * �Ƿ�������ֵ��ַ���<Br>
     * (2)Ab,=First(b)-��,ֱ������ս��
     *
     * @param str
     * @param a
     * @return
     */
    public static boolean containsAb(TreeSet<Character> ntSet, String itemCharStr, Character a) {
        String aStr = a.toString();
        if (itemCharStr.contains(aStr)) {//�������ı��ʽ�����÷��ս���Ļ�
            int aIndex = itemCharStr.indexOf(aStr);//�ҳ����±�
            String findStr;
            try {
                findStr = itemCharStr.substring(aIndex + 1, aIndex + 2);//��ȡ�÷��ս���ĺ�һ��
            } catch (Exception e) {
                return false;
            }
            if (ntSet.contains(findStr.charAt(0))) {//������ս���Ļ�
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * �Ƿ�������ֵ��ַ���<Br>
     * (2).2Ab,=First(b)-��
     */
    public static boolean containsAB(TreeSet<Character> nvSet, String itemCharStr, Character a) {
        String aStr = a.toString();
        if (itemCharStr.contains(aStr)) {
            int aIndex = itemCharStr.indexOf(aStr);
            String findStr;
            try {
                findStr = itemCharStr.substring(aIndex + 1, aIndex + 2);
            } catch (Exception e) {
                return false;
            }
            if (nvSet.contains(findStr.charAt(0))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * ��ȡA����ַ�
     *
     * @param itemCharStr
     * @param a
     * @return
     */
    public static Character getAlastChar(String itemCharStr, Character a) {
        String aStr = a.toString();
        if (itemCharStr.contains(aStr)) {
            int aIndex = itemCharStr.indexOf(aStr);
            String findStr = "";
            try {
                findStr = itemCharStr.substring(aIndex + 1, aIndex + 2);
            } catch (Exception e) {
                return null;
            }
            return findStr.charAt(0);
        }
        return null;
    }

    /**
     * �Ƿ�Ϊ�ſ�ʼ��
     *
     * @param selectExp
     * @return
     */
    public static boolean isEmptyStart(String selectExp) {
        char charAt = selectExp.charAt(0);
        if (charAt == '��') {
            return true;
        }
        return false;
    }

    /**
     * �Ƿ����ս����ʼ��
     *
     * @param ntSet
     * @param selectExp
     * @return
     */
    public static boolean isNtStart(TreeSet<Character> ntSet, String selectExp) {
        char charAt = selectExp.charAt(0);
        if (ntSet.contains(charAt)) {
            return true;
        }
        return false;
    }

    /**
     * �Ƿ��Ƿ��ս����ʼ��
     *
     * @param nvSet
     * @param selectExp
     * @return
     */
    public static boolean isNvStart(TreeSet<Character> nvSet, String selectExp) {
        char charAt = selectExp.charAt(0);
        if (nvSet.contains(charAt)) {
            return true;
        }
        return false;
    }

    /**
     * ���Ҳ���ʽ
     *
     * @param selectMap
     * @param peek
     *            ��ǰNv
     * @param charAt
     *            ��ǰ�ַ�
     * @return
     */
    public static String findUseExp(TreeMap<Character, HashMap<String, TreeSet<Character>>> selectMap, Character peek,
                                    char charAt) {
        try {
            HashMap<String, TreeSet<Character>> hashMap = selectMap.get(peek);
            Set<String> keySet = hashMap.keySet();
            for (String useExp : keySet) {
                TreeSet<Character> treeSet = hashMap.get(useExp);
                if (treeSet.contains(charAt)) {
                    return useExp;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}
