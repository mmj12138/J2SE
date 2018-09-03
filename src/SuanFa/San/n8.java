package SuanFa;

/**
 * Created by Administrator on 2017/11/27.
 */
public class n8 {
    boolean isHuiWen(String text,int i) {
        int length = text.length();
        if (i < length / 2) {
            if (text.toCharArray()[i] != text.toCharArray()[length - i - 1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        n8 x = new n8();
        String text = "abcba";
        System.out.println(x.isHuiWen(text,0));
    }
}

