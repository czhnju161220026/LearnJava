import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertValues {
    public static void main(String[] args) {
        String DBDriver = "com.mysql.jdbc.Driver";
        String DBUrl = "jdbc:mysql://localhost:3306/LAB3?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String Passwd = "ztw520/*-";
        try{
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBUrl,userName,Passwd);
            Statement statement = connection.createStatement();
            //新增两门课程
            String operation = "Insert into Course values " +
                    "(103,'程序设计',5),(104,'数字电路',4)";
            statement.execute(operation);
            //新增两条选课记录
            operation = "Insert into SC values " +
                    "(10005,103,90),(10006,104,88)";
            statement.execute(operation);
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
