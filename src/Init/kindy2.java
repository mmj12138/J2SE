package Init;

/**
 * Created by mengmengjiang on 2017/11/4.
 */
public class kindy2 {
    static void kindy(){
        int [] a = new int[17];
        for(int i = 0;i<17;i++){
            a[i]=1;
        }
        int p = 0;//��ȥ����
        int x = 0;//ÿ���˽е����
        int k = 0;//��ǰ�˵�λ��
        while(p<16){
            x=x+a[k];
            if(a[k]==1 && x%3==0){
                a[k]=0;
                p+=1;
            }
            k=(k+1)%17;

        }
        for(int i = 0;i<17;i++){
            if(a[i]==1){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        kindy();
    }
}
