package SuanFa;

/**
 * Created by Administrator on 2017/11/29.
 */
public class n13 {
    public static void main(String[] args) {
        int a,b,c,d,e=4;
        for(a=1;a<=5;a++)
            for(b=1;b<=5;b++)
                if(a!=b)
                    for(c=1;c<=5;c++)
                        if(c!=a&&c!=b)
                            for(d=1;d<=5;d++){
                                if(d!=a&&d!=b&&d!=c)
                                    e=15-a-b-c-d;
                                if(e!=a&&e!=b&&e!=c&&e!=d)
                                    if(((b==3)^(c==5))&&((d==2)^(e==4))&&((b==1)^(e==4))&&((c==1)^(b==2))&&((d==2)^(a==3)))
                                    {
                                        System.out.printf("五人的名次分别为：\n");
                                        System.out.printf("A\tB\tC\tD\tE\n");
                                        System.out.printf("%d\t%d\t%d\t%d\t%d\n",a,b,c,d,e);
                                        return;
                                    }
                            }
    }
}
