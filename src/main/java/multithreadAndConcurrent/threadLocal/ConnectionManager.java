package multithreadAndConcurrent.threadLocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库链接管理
 * 首先数据库链接这个对象不需要线程共享，所以可以使用ThreadLocal进行线程封闭
 * 1. 通过方法栈封闭
 */
class ConnectionManager {
    private Connection connect = null;

    public Connection openConnection() throws SQLException {
        if (connect == null) {
            connect = DriverManager.getConnection("mysql");
        }
        return connect;
    }

    public void closeConnection() throws SQLException {
        if (connect != null){
            connect.close();
        }
    }
}

class Dao {
    /**
     * 每次都是在方法内部创建的连接，那么线程之间自然不存在线程安全问题。但是这样会有一个致命的影响：导致服务器压力非常大，
     * 并且严重影响程序执行性能。由于在方法中需要频繁地开启和关闭数据库连接，这样不仅严重影响程序执行效率，还可能导致服务器压力巨大。
     * @throws SQLException
     */
    public void insert() throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.openConnection();
        // 使用connection进行操作
        connectionManager.closeConnection();
    }
}