package SuanFa;

/**
 * Created by Administrator on 2017/11/13.
 */
public class n18 {
    public static void main(String[] args) {
        int[] num = new int[9];
        for (int i = 5000; i <= 9999; i++) {
            for (int j = 0; j < 4; j++) {
                num[j] = i % (int) Math.pow(10, j + 1) / (int) Math.pow(10, j);
            }
            for (int j = 4; j < 9; j++) {
                num[j] = 2 * i % (int) Math.pow(10, j - 3) / (int) Math.pow(10, j - 4);
            }
            int[] flag = new int[10];
            int count = 0;
            for (int j : num) {
                flag[j]++;
                if (flag[j] > 1) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == 9) {
                System.out.println(i + " " + i * 2);
            }
        }
    }
}
