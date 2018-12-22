package genetic;

/*使用自限定，泛型基类变成功能模板，参数可随子类变化而变化
* 或者说叫协变参数类型*/

//一个功能模板
class FunctionTemplate<T extends FunctionTemplate> {
    private T element;
    public void set(T element) {
        this.element = element;
    }
    public T get() {
        return element;
    }
    public void outputInfo() {
        System.out.println(element);
    }
}

class Student extends FunctionTemplate<Student> {
    private int id ;
    public Student(int id) {
        this.id = id;
    }
    public String toString() {
        return "Student:"+id;
    }
}

class Teacher extends FunctionTemplate<Teacher> {
    private int teacherId;
    public Teacher(int id) {
        teacherId = id;
    }
    public String toString() {
        return "Teacher:"+teacherId;
    }
}

public class GeneticSelfBounded {
    public static void main(String[] args) {
        Student a = new Student(1);
        a.set(new Student(2));
        a.outputInfo();

        Teacher b = new Teacher(3);
        b.set(new Teacher(2));
        b.outputInfo();
    }
}
