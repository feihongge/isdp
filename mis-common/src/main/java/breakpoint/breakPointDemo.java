package breakpoint;

public class breakPointDemo {

    public static void line(){
        System.out.println("line");
    }

    public static void detailLine(){
        System.out.println("detailLine");
    }

    public static void method(){
        System.out.println("method");
        IService iService = new IServiceImpl();
        iService.execute();
    }

    public static void exception(){
        Object o = null;
        o.toString();
        System.out.println("this line will never be print");
    }

    public static void field(){
            Person p = new Person("field",10);
            p.setAge(12);
        System.out.println(p);
    }

    public static void main(String[] args) {
        line();
        detailLine();
       // method();
       // exception();
        field();
    }
}
