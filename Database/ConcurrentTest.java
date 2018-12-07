import java.sql.*;
import java.util.concurrent.*;
import org.apache.commons.dbcp2.*;

class SubTask implements Runnable {
    BasicDataSource basicDataSource;
    public SubTask(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }
    public void run() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        for(int i = 0;i < 1000;i++) {
            try{
                connection = basicDataSource.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("Select Student.SNAME,Student.SNO,Course.CNAME,SC.GRADE " +
                        "from Student,Course,SC " +
                        "where Student.SNO = SC.SNO and Course.CNO = SC.CNO");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                ConcurrentTest.closeConnection(connection,statement,resultSet);
            }
        }
    }
}
public class ConcurrentTest {
    public static void closeConnection(Connection connection, Statement statement,ResultSet resultSet) {
        try{
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(resultSet != null) {
                resultSet.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String DBDriver = "com.mysql.jdbc.Driver";
        String DBUrl = "jdbc:mysql://localhost:3306/LAB3?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String Passwd = "ztw520/*-";
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setMaxTotal(10);
        dataSource.setUrl(DBUrl);
        dataSource.setDriverClassName(DBDriver);
        dataSource.setUsername(userName);
        dataSource.setPassword(Passwd);
        long start = System.currentTimeMillis();
        Connection connection = null;
        Statement statement =null;
        ResultSet resultSet = null;

        for(int i = 0;i < 4000;i++) {
            try {
                connection = dataSource.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("Select Student.SNAME,Student.SNO,Course.CNAME,SC.GRADE " +
                        "from Student,Course,SC " +
                        "where Student.SNO = SC.SNO and Course.CNO = SC.CNO");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                closeConnection(connection,statement,resultSet);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("串行进行4000次打开连接,查询,关闭,操作,用时: "+(end-start)+" ms.");

        start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i < 4;i++) {
            //开启4个线程，每个线程操作1000次
            executorService.execute(new SubTask(dataSource));
        }
        executorService.shutdown();
        while(!executorService.isTerminated()) {}
        end = System.currentTimeMillis();
        System.out.println("串行进行4000次打开连接,查询,关闭,操作,用时: "+(end-start)+" ms.");

    }
}
