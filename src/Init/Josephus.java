package Init;

/**
 * Created by Administrator on 2017/11/8.
 */
public class Josephus {
    //�����㣬
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public void yuekill(){
        int n = 17;//����������n
        int m = 3;//�ͳ�Ȧ����m
        //��ʼ��ѭ���б�,ͷ���first��β���last
        Node first = new Node(0);
        first.next = first;  //һ���ڵ��ʱ��ͷ����β��β����ͷ
        Node last = first;


        for(int i=1; i<n; i++){//�γɵ�����   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
            Node temp = new Node(i);
            last.next = temp;
            last = last.next;
        }

        last.next = first;//0��16���ӣ�����������β�������γ�ѭ������ ��β��ͷ�γ�ѭ������lastΪβ��㣩
        //���Ͼ���Լɪ��

        //ִ�г�Ȧ����
        System.out.println("��Ȧ˳��Ϊ:");
        while(last != last.next){
            //����forѭ����last�ǵ�m������ǰһ�����
            for(int i=1; i<m; i++){  //����Ҫɾ���ڵ� ǰһ����Ȧ����
                last = last.next;
            }
            //��ѭ��֮�󣬾���Ҫɾ���Ľڵ㣬ɾ����m�����
            System.out.print(last.next.data+" "); //��Ȧ������
            last.next = last.next.next;  //ָ��Ҫɾ���Ľڵ����һ�ڵ�
        }
        System.out.print("\n��������:"+last.data);//ԭ����10��
    }
    public static void main(String[] args){
        new Josephus().yuekill();
    }

}

