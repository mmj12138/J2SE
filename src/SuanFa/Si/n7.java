package SuanFa.Si;

/**
 * Created by Administrator on 2017/12/9.
 * һ������ 2��2������ʣһ����%2==1��
 *          3��3������ʣ2����%3==2��
 *          5��5������ʣ4����%5==4��
 *          6��6������ʣ5����%6==5��
 *7��7�������������� ��ô�Ͱ���7�ı����ߣ�ÿһ�ζ�����һ���ж�
 * ����������������˳�ѭ�� ����ͼ���������
 */
public class n7 {
    public static void main(String[] args) {
        for(int i = 1;;i++){
            int m = i*7;
            if(m%2==1&&m%3==2&&m%5==4&&m%6==5){
                System.out.println(m);
                return;
            }
        }
    }
}
