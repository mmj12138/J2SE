package SheJiMoShi.ShiJian;
import java.util.*;
/**
 * Created by Administrator on 2017/12/13.
 */
public class Client2 {
    public static void main(String args[]) {
        Folder folder1,folder2,folder3;
        folder1 = new Folder("������ϼ���");
        folder2 = new Folder("���ͼ���ļ�");
        folder3 = new Folder("����ı��ļ�");
        ImageFile image1,image2;
        image1 = new ImageFile("�����ͼ.jpg");
        image2 = new ImageFile("�����ͼ.gif");
        TextFile text1,text2;
        text1 = new TextFile("��ش���.txt");
        text2 = new TextFile("����ĵ�.doc");
        folder2.addImageFile(image1);
        folder2.addImageFile(image2);
        folder3.addTextFile(text1);
        folder3.addTextFile(text2);
        folder1.addFolder(folder2);
        folder1.addFolder(folder3);
        folder1.killVirus();
    }
}

//ͼ���ļ���
class ImageFile {
    private String name;
    public ImageFile(String name) {
        this.name = name;
    }
    public void killVirus() { //�򻯴��룬ģ��ɱ��
        System.out.println("----��ͼ���ļ�'" + name + "'����ɱ��");
    }
}
//�ı��ļ���
class TextFile {
    private String name;
    public TextFile(String name) {
        this.name = name;
    }
    public void killVirus() { //ģ��ɱ��
        System.out.println("----���ı��ļ�'" + name + "'����ɱ��");
    }
}
//�ļ�����
class Folder {
    private String name; //���弯��folderList�����ڴ洢Folder���͵ĳ�Ա
    private ArrayList<Folder> folderList = new ArrayList<Folder>();
    //���弯��imageList�����ڴ洢ImageFile���͵ĳ�Ա
    private ArrayList<ImageFile> imageList = new ArrayList<ImageFile>();
    //���弯��textList�����ڴ洢TextFile���͵ĳ�Ա
    private ArrayList<TextFile> textList = new ArrayList<TextFile>();
    public Folder(String name) {
        this.name = name;
    }
    //�����µ�Folder���͵ĳ�Ա
    public void addFolder(Folder f) {
        folderList.add(f);
    }
    //�����µ�ImageFile���͵ĳ�Ա
    public void addImageFile(ImageFile image) {
        imageList.add(image);
    }
    //�����µ�TextFile���͵ĳ�Ա
    public void addTextFile(TextFile text) {
        textList.add(text);
    }
    public void killVirus() {
        System.out.println("****���ļ���'" + name + "'����ɱ��");
        //ģ��ɱ��
        // �����Folder���͵ĳ�Ա���ݹ����Folder��killVirus()����
        for(Object obj : folderList) {
            ((Folder)obj).killVirus();
        }
        //�����ImageFile���͵ĳ�Ա������ImageFile��killVirus()����
        for(Object obj : imageList) {
            ((ImageFile)obj).killVirus();
        }
        //�����TextFile���͵ĳ�Ա������TextFile��killVirus()����
        for(Object obj : textList) {
            ((TextFile)obj).killVirus();
        }
    }
}
