/**
 * Created by mengmengjiang on 2017/10/28.
 * ��ҵ[0-100] ��switchд�� 1-5�ĵȼ�
 */
public class J {
    static void getLevel(int level){//�в����޷���ֵ���գ�����
        switch(level){//����switch���������Ӧ����
            case 0:
                System.out.println("1��");
                break;
            case 1:
                System.out.println("2��");
                break;
            case 2:
                System.out.println("3��");
                break;
            case 3:
                System.out.println("4��");
                break;
            default:
                System.out.println("5��");
        }
    }

    public static void main(String[] args) {
        int score = 12;//�������
        int level = score/20;//���ó����ضϷֳ��ȼ�
        getLevel(level);//���÷������
    }
}
