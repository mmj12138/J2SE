package SheJiMoShi.ShiYan;

/**
 * Created by Administrator on 2017/12/2.
 */
public class Client {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        factory.createAoDi().show();
        factory.createBenChi().show();
    }
}
abstract class IProduct{
    public abstract void show();
}

class AoDi extends IProduct{
    @Override
    public void show() {
        System.out.println("这是一辆奥迪");
    }
}
class BenChi extends IProduct{
    @Override
    public void show() {
        System.out.println("这是一辆奔驰");
    }
}
interface IFactory{
    public IProduct createAoDi();
    public IProduct createBenChi();
}
class Factory implements IFactory{

    @Override
    public IProduct createAoDi() {
        return new AoDi();
    }

    @Override
    public IProduct createBenChi() {
        return new BenChi();
    }
}
