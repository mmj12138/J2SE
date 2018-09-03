package SheJiMoShi.ShiJian;

/**
 * Created by Administrator on 2017/12/13.
 */
public class Client1 {
    public static void main(String args[]) {
        LoggerFactory factory;
        Logger logger;
        factory = new FileLoggerFactory();
        logger = factory.createLogger();
        logger.writeLog();

        LoggerFactory factory1;
        Logger logger1;
        factory = new DatabaseLoggerFactory();
        logger = factory.createLogger();
        logger.writeLog();
    }
}
interface Logger {
    void writeLog();
}

//���ݿ���־��¼���������Ʒ
class DatabaseLogger implements Logger {
    public void writeLog() {
        System.out.println("��¼���ݿ���־��");
    }
}

//�ļ���־��¼���������Ʒ
class FileLogger implements Logger {
    public void writeLog() {
        System.out.println("��¼�ļ���־��");
    }
}

//��־��¼�������ӿڣ����󹤳�
interface LoggerFactory {
    public Logger createLogger();
}

//���ݿ���־��¼�������ࣺ���幤��
class DatabaseLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        Logger logger = new DatabaseLogger();
        return logger;
    }
}

//�ļ���־��¼�������ࣺ���幤��
class FileLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        Logger logger = new FileLogger();
        return logger;
    }
}
