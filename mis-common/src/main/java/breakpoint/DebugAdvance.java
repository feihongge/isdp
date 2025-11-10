package breakpoint;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class DebugAdvance {

    public static void conditions(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread, "thread1");
        Thread t2 = new Thread(myThread, "thread2");
        Thread t3 = new Thread(myThread, "thread3");
        t1.start();
        t2.start();
        t3.start();

    }

    public static void printStackTrace(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
    }

    public static void saveRecourse(){
        System.out.println("错乱数据");

        System.out.println("save to db");
        System.out.println("save to redis");
        System.out.println("send message");
    }

    public static void keysExplain(){
        System.out.println("keys");

        System.out.println("step over");

        System.out.println("step into | step out");
        IService service = new IServiceImpl();
        service.execute();

        StringBuffer sb = new StringBuffer();
        sb.append("hello world");
        System.out.println(sb.toString());

        System.out.println("a");
        System.out.println("a");
        System.out.println("a");
        System.out.println("a");
    }

    public static void sourceCode(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList.size());

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList.size());
    }

    public static void evaluate(){
        System.out.println("evaluate");
        Person p = new Person("aaa", 30);

        List<Integer> list = Arrays.asList(1,2,3,4).stream()
                .map(x -> x*2).collect(Collectors.toList());
    }

    public static void streamDebug(){

        Arrays.asList(1,2,3,45).stream()
                .filter(e -> e % 2 == 0||e % 3 == 0)
                .map(e -> e*e)
                .forEach(System.out::print);

        String string = Optional.of("hi,")
                .map(e ->e + "java")
                .map(e->e+"技术")
                .map(e->"栈").get();
        System.out.println(string);
    }

    public static void main(String[] args) {
       // conditions();
       // printStackTrace();
       // evaluate();
        //saveRecourse();
       // keysExplain();
        //sourceCode();
        streamDebug();
    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--进入");
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + "--离开");
            }
        }
    }
}
