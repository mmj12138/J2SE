package SheJiMoShi.ShiJian;

/**
 * Created by Administrator on 2017/12/15.
 */
public class Client5 {
    public static void main(String[] args) {
        Account account = new Account("mengmeng", 5.0);
        account.deposit(100);
        account.withdraw(200);
        account.deposit(1000);
        account.withdraw(2000);
        account.withdraw(100);
    }
}

abstract class AccountState {

    protected Account account;
    protected double balance;

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void stateCheck();
}

class GreenState extends AccountState {

    public GreenState(AccountState state) {
        this.balance = state.balance;
        this.account = state.account;
    }

    public GreenState(double balance, Account account) {
        this.balance = balance;
        this.account = account;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
        stateCheck();
    }

    @Override
    public void stateCheck() {
        if (balance >= -1000 && balance < 0) {
            account.setState(new YellowState(this));
        } else if (balance < -1000) {
            account.setState(new RedState(this));
        }
    }

}

class YellowState extends AccountState {

    public YellowState(AccountState state) {
        this.balance = state.balance;
        this.account = state.account;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
        stateCheck();
    }

    @Override
    public void stateCheck() {
        if (balance >= 0) {
            account.setState(new GreenState(this));
        } else if (balance < -1000) {
            account.setState(new RedState(this));
        }
    }

}

class RedState extends AccountState {

    public RedState(AccountState state) {
        this.balance = state.balance;
        this.account = state.account;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("账户被冻结，取款失败");
    }

    @Override
    public void stateCheck() {
        if (balance >= 0) {
            account.setState(new GreenState(this));
        } else if (balance >= -1000) {
            account.setState(new YellowState(this));
        }
    }

}

class Account {

    private AccountState state;
    private String owner;

    public Account(String owner, double init) {
        this.owner = owner;
        this.state = new GreenState(init, this);
        System.out.println(this.owner + "开户，初始金额为" + init);
        System.out.println("--------------------------------------------------");
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public void deposit(double amount) {
        System.out.println(this.owner + "存款" + amount);
        state.deposit(amount);
        System.out.println("现金余额为" + state.balance);
        System.out.println("现在账户状态为" + state.getClass().getName());
        System.out.println("--------------------------------------------------");
    }

    public void withdraw(double amount) {
        System.out.println(this.owner + "取款" + amount);
        state.withdraw(amount);
        System.out.println("现金余额为" + state.balance);
        System.out.println("现在账户状态为" + state.getClass().getName());
        System.out.println("--------------------------------------------------");
    }
}
