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

//数据库日志记录器：具体产品
class DatabaseLogger implements Logger {
    public void writeLog() {
        System.out.println("记录数据库日志。");
    }
}

//文件日志记录器：具体产品
class FileLogger implements Logger {
    public void writeLog() {
        System.out.println("记录文件日志。");
    }
}

//日志记录器工厂接口：抽象工厂
interface LoggerFactory {
    public Logger createLogger();
}

//数据库日志记录器工厂类：具体工厂
class DatabaseLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        Logger logger = new DatabaseLogger();
        return logger;
    }
}

//文件日志记录器工厂类：具体工厂
class FileLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        Logger logger = new FileLogger();
        return logger;
    }
}
