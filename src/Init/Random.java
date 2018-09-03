package Init;

/**
 * Created by Administrator on 2017/11/30.
 */
public class Random {
    /*随机生成5个 【a--z】，但是不能重复。97--122*/
    public static void main(String[] args) {
        Random b = new Random();
        char [] a =new char[5];
        b.random(a);
        for(char c1:a){
            System.out.println(c1);
        }

    }
    void random(char [] a){
        for(int i =0 ;i<5;i++){
            char c=(char)(Math.random()*26+97);
            for(int j =i;j>=0;j--){
                if(c==a[j]){
                    random(a);
                }
            }
            a[i]=c;
        }
    }
}
