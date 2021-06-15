package threadsafe;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME
 * @description
 * 一个集合是线程安全的，有两个线程在操作同一个集合对象，
 * 当第一个线程查询集合非空后，删除集合中所有元素的时候。
 * 第二个线程也来执行与第一个线程相同的操作，也许在第一个线程查询后，
 * 第二个线程也查询出集合非空，但是当第一个执行清除后，
 * 第二个再执行删除显然是不对的，因为此时集合已经为空了
 */
public class TestNameList {
    public static void main(String[] args) {
        final NameList nl =new NameList();
        nl.add("苏东坡");
        class NameDropper extends Thread{
            @Override
            public void run() {
                String name = nl.removeFirst();
                System.out.println(name);
            }
        }
        Thread t1=new NameDropper();
        Thread t2=new NameDropper();
        t1.start();
        t2.start();
    }
}
