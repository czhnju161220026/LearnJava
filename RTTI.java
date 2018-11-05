class Student {
    private String name;
    static {
        System.out.println("Static Block");
    }
    public Student(String name) {
        this.name = name;
    }
    public Student() {
        name = "张三";
    }

    public String toString() {
        return "Name:"+name;
    }
}

public class RTTI {
    public static  void main(String []args) {
        Class studentClass = Student.class;  //通过类字面常量获得Class对象，不会触发Static block和异常
        System.out.println(studentClass.getName());
        System.out.println(studentClass.getSimpleName());
        System.out.println(studentClass.getCanonicalName());

        try {
            Class studentClass2 = Class.forName("Student"); //通过foraName，会触发Static block 和ClassNotFound异常
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Object obj = studentClass.newInstance(); //newInstance返回object对象
            if(obj instanceof Student) {
                Student student = (Student)obj;
                System.out.println(student);
            }
        }
        catch (InstantiationException e ) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
