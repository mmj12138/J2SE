package SheJiMoShi.ShiJian;
import java.util.*;
/**
 * Created by Administrator on 2017/12/13.
 */
public class Client2 {
    public static void main(String args[]) {
        Folder folder1,folder2,folder3;
        folder1 = new Folder("相关资料集合");
        folder2 = new Folder("相关图像文件");
        folder3 = new Folder("相关文本文件");
        ImageFile image1,image2;
        image1 = new ImageFile("代码截图.jpg");
        image2 = new ImageFile("结果截图.gif");
        TextFile text1,text2;
        text1 = new TextFile("相关代码.txt");
        text2 = new TextFile("相关文档.doc");
        folder2.addImageFile(image1);
        folder2.addImageFile(image2);
        folder3.addTextFile(text1);
        folder3.addTextFile(text2);
        folder1.addFolder(folder2);
        folder1.addFolder(folder3);
        folder1.killVirus();
    }
}

//图像文件类
class ImageFile {
    private String name;
    public ImageFile(String name) {
        this.name = name;
    }
    public void killVirus() { //简化代码，模拟杀毒
        System.out.println("----对图像文件'" + name + "'进行杀毒");
    }
}
//文本文件类
class TextFile {
    private String name;
    public TextFile(String name) {
        this.name = name;
    }
    public void killVirus() { //模拟杀毒
        System.out.println("----对文本文件'" + name + "'进行杀毒");
    }
}
//文件夹类
class Folder {
    private String name; //定义集合folderList，用于存储Folder类型的成员
    private ArrayList<Folder> folderList = new ArrayList<Folder>();
    //定义集合imageList，用于存储ImageFile类型的成员
    private ArrayList<ImageFile> imageList = new ArrayList<ImageFile>();
    //定义集合textList，用于存储TextFile类型的成员
    private ArrayList<TextFile> textList = new ArrayList<TextFile>();
    public Folder(String name) {
        this.name = name;
    }
    //增加新的Folder类型的成员
    public void addFolder(Folder f) {
        folderList.add(f);
    }
    //增加新的ImageFile类型的成员
    public void addImageFile(ImageFile image) {
        imageList.add(image);
    }
    //增加新的TextFile类型的成员
    public void addTextFile(TextFile text) {
        textList.add(text);
    }
    public void killVirus() {
        System.out.println("****对文件夹'" + name + "'进行杀毒");
        //模拟杀毒
        // 如果是Folder类型的成员，递归调用Folder的killVirus()方法
        for(Object obj : folderList) {
            ((Folder)obj).killVirus();
        }
        //如果是ImageFile类型的成员，调用ImageFile的killVirus()方法
        for(Object obj : imageList) {
            ((ImageFile)obj).killVirus();
        }
        //如果是TextFile类型的成员，调用TextFile的killVirus()方法
        for(Object obj : textList) {
            ((TextFile)obj).killVirus();
        }
    }
}
