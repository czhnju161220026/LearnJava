import java.sql.*;
import org.apache.commons.dbcp2.*;

import javax.sql.DataSource;

public class SpeedTest {
    private static void closeConnection(Connection connection, Statement statement,ResultSet resultSet) {
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
        String sql = "Select Student.SNAME,Student.SNO,Course.CNAME,SC.GRADE " +
                "from Student,Course,SC " +
                "where Student.SNO = SC.SNO and Course.CNO = SC.CNO";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        long start = System.currentTimeMillis();
        for(int i = 0;i < 2000;i++) {
            try {
                Class.forName(DBDriver);
                connection = DriverManager.getConnection(DBUrl,userName,Passwd);
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                closeConnection(connection,statement,resultSet);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("通过API进行2000次打开连接,查询,关闭,用时："+(end-start)+" ms.");

        start = System.currentTimeMillis();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DBDriver);
        dataSource.setMaxTotal(10);
        dataSource.setUrl(DBUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(Passwd);
        for(int i = 0;i<2000;i++) {
            try{
                connection = dataSource.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                closeConnection(connection,statement,resultSet);
            }
        }
        end = System.currentTimeMillis();
        System.out.println("通过数据库连接池执行2000次打开连接,查询,关闭,操作,用时: "+(end-start)+" ms.");

    }
}
