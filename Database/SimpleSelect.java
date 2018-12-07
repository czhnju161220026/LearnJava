import java.sql.*;

public class SimpleSelect {
    public static void main(String[] args) {
        String DBDriver = "com.mysql.jdbc.Driver";
        String DBUrl = "jdbc:mysql://localhost:3306/LAB3?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String Passwd = "ztw520/*-";
        try{
            Class.forName(DBDriver);
            Connection connection = DriverManager.getConnection(DBUrl,userName,Passwd);
            System.out.println("连接成功");
            Statement stmt = connection.createStatement();
            //查询学生表所有信息
            System.out.println("------Student table------");
            ResultSet resultSet = stmt.executeQuery("SELECT * from Student");
            while(resultSet.next()) {
                int sno = resultSet.getInt("SNO");
                String name = resultSet.getString("SNAME");
                String sex = resultSet.getString("SEX");
                System.out.println(""+sno+" "+name+" "+sex);

            }

            System.out.println("------Course Table------");
            resultSet = stmt.executeQuery("SELECT  * from  Course");
            while(resultSet.next()) {
                int cno = resultSet.getInt("CNO");
                String cname = resultSet.getString("CNAME");
                int credit = resultSet.getInt("CREDIT");
                System.out.println("" + cno + " " + cname + " " + credit);
            }

            System.out.println("------SC Table------");
            resultSet = stmt.executeQuery("SELECT  * from SC");
            while(resultSet.next()) {
                int sno = resultSet.getInt("SNO");
                int cno = resultSet.getInt("CNO");
                int grade = resultSet.getInt("GRADE");
                System.out.println(" "+sno+" "+cno+" "+grade);
            }

            System.out.println("---学生每门课的成绩---");
            //联合查询,查询已有学生每门课的成绩信息
            resultSet  = stmt.executeQuery("Select Student.SNO,Student.SNAME,Course.CNAME,SC.GRADE " +
                    "from Student,Course,SC " +
                    "where Student.SNO = SC.SNO and Course.CNO = SC.CNO");
            while(resultSet.next()) {
                int sno = resultSet.getInt("SNO");
                String name = resultSet.getString("SNAME");
                String cname = resultSet.getString("CNAME");
                int grade = resultSet.getInt("GRADE");
                System.out.println("" + sno + " " + name + " " + cname + " " + grade);
            }
            resultSet.close();


            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            //System.out.println("连接失败");
        }

    }
}
