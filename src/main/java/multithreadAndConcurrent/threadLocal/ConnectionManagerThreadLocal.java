package multithreadAndConcurrent.threadLocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库链接管理
 * 首先数据库链接这个对象不需要线程共享，所以可以使用ThreadLocal进行线程封闭
 * */
public class ConnectionManagerThreadLocal {

    /**
     *
     * Thread对象中的一个ThreadLocalMap类型的变量threadLocals, 负责存储当前线程的关于Connection的对象,
     * dbConnectionLocal(以例子中为例) 这个变量为Key, 以新建的Connection对象为Value;
     * 这样的话, 线程第一次读取的时候如果不存在就会调用ThreadLocal的initialValue方法创建一个Connection对象并且返回;
     */
    private static final ThreadLocal<Connection> dbConnectionLocal = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {
            try {
                return DriverManager.getConnection("", "", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public Connection getConnection() {
        return dbConnectionLocal.get();
    }

    /**
     * 可以不实现initialValue, 将初始化工作放到DBConnectionFactory的getConnection方法中通过set方法实现
     */
//    public Connection getConnection() {
//        Connection connection = dbConnectionLocal.get();
//        if (connection == null) {
//            try {
//                connection = DriverManager.getConnection("", "", "");
//                dbConnectionLocal.set(connection);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return connection;
//    }


    public void closeConnection() throws SQLException {
        if (dbConnectionLocal.get() != null){
            dbConnectionLocal.get().close();
        }
    }
}

class ThreadLocalDao {
    ConnectionManagerThreadLocal connectionManager = new ConnectionManagerThreadLocal();
    public void insert() throws SQLException {
        Connection connection = connectionManager.getConnection();
        // 使用connection进行操作
        connectionManager.closeConnection();
    }
}