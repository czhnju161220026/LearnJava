import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateValues {
    public static void main(String[] args) {
        String DBDriver = "com.mysql.jdbc.Driver";
        String DBUrl = "jdbc:mysql://localhost:3306/LAB3?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String Passwd = "ztw520/*-";

        try{
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBUrl,userName,Passwd);
            Statement statement = connection.createStatement();
            //女同学每门课的成绩加1
            String operation = "Update SC Set GRADE = GRADE + 1 where " +
                    "SNO = any(Select SNO from Student where SEX = 'f')";
            statement.executeUpdate(operation);
            //课程的学分加1
            operation = "Update Course Set CREDIT = CREDIT +1";
            statement.executeUpdate(operation);
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
