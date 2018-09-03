package SuanFa;

/**
 * Created by Administrator on 2017/11/15.
 */
public class n12 {
    public static void main(String[] args) {
        int [] poke = new int[53];
        for(int x : poke){
            x=0;
        }
        int count = 0;
        int num = 0;
        int i=1;
        int j;
        while(count<104){
            for(j=i+1;j<=52;j+=(i+1)){
                poke[j]=1-poke[j];
                count++;
                if(count>=104)
                    break;
            }
            i++;
        }
        System.out.println("正面朝上的牌:");
        for(int k=1;k<=52;k++){
            if(poke[k]==0)
            {
                System.out.printf("%d\n",k);
                num++;
            }
        }
        System.out.printf("\n一共有%d张牌朝上",num);

    }
}

