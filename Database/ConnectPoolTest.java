import java.sql.*;
import org.apache.commons.dbcp2.*;
public class ConnectPoolTest {
    private  static void CloseAll(Connection connection , Statement statement ,ResultSet resultSet){
        try{
            if(connection!=null) connection.close();
            if(statement!=null) statement.close();
            if(resultSet!=null) resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/LAB3?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("ztw520/*-");
        dataSource.setMaxTotal(10);
        Connection connection= null;
        Statement statement=null;
        ResultSet rs = null;
        try{
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("select  * from Student");
            while(rs.next()) {
                String name = rs.getString("SNAME");
                System.out.println(name);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            CloseAll(connection,statement,rs);
        }
    }
}
