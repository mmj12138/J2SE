package Init;

/**
 * Created by Administrator on 2017/12/1.
 */
public class Random2 {
    public static void main(String[] args) {
        String ss="";
        for(int i =0;i<5;i++) {
            char c = (char) (Math.random() * 26 + 97);
            if (!ss.contains(c + "")) {
                ss += c;
            } else {
                i--;
            }
        }
        System.out.println(ss);


    }
}
