package threadsleep;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME
 * @description 一个计数器，计数到100，在每个数字之间暂停1毫秒，每隔10个数字输出一个字符串
 */
public class CalcThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i)%10 == 0){
                System.out.println("每隔十个数字输出一句话,第 " + i + " 个");
            }
            try {
                Thread.sleep(1);
                System.out.println("第 " + i +" 个数字暂停1毫秒 \n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CalcThread().start();
    }
}
