package SuanFa;

/**
 * Created by Administrator on 2017/11/29.
 */
public class n15 {
    public static void main(String[] args) {
        int i,j,k;
        for(i='X';i<='Z';i++)
        {
            for(j='X';j<='Z';j++)
            {
                for(k='X';k<='Z';k++)
                {
                    if(i=='X'||j==i||k=='X'||k=='Z'||k==i||k==j) continue;
                    System.out.print("A B C的对手分别是："+(char)i+" "+(char)j+" "+(char)k);
                }
            }
        }
    }
}
