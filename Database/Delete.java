import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {
    public static void main(String[] args) {
        String DBDriver = "com.mysql.jdbc.Driver";
        String DBUrl = "jdbc:mysql://localhost:3306/LAB3?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String Passwd = "ztw520/*-";
        try {
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBUrl, userName, Passwd);
            Statement statement = connection.createStatement();
            String operation = "Delete from SC where " +
                    "SNO = 10003";
            statement.executeUpdate(operation);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
