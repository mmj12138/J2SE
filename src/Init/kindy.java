package Init;

/**
 * Created by mengmengjiang on 2017/11/4.
 */
public class kindy {
    static void kindy(){
        int [] a = new int[17];
        for(int i = 0;i<a.length;i++){
            a[i]=1;//��¼״̬��û��ȥ��Ϊ1����ȥ��Ϊ0
        }
        int k = 0;//��¼��ǰ�˵����
        int p = 0;//��¼��ȥ�˶�����
        int x=0;//�е����
        while (p <16) {//ʣ���һ���˵�ʱ���˳�ѭ��
            x+=a[k];//û�˳���1���˳���0
            if (a[k]==1 &&x % 3 == 0) {//���û�˳��������ı���
                a[k] = 0;
                p += 1;
            }
            k += 1;
            k%=17;
        }
        for(int i = 0;i<a.length;i++){
            if(a[i]==1){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        kindy();
    }
}
