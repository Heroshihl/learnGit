package concurrentcollaboration.productionandconsumption;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description 仓库
 */
public class Godown {

    /**
     * 最大库存量
     */
    public static final int max_size = 100;
    /**
     * 当前库存量
     */
    public int curnum;

    public Godown() {
    }

    public Godown(int curnum) {
        this.curnum = curnum;
    }

    /**
     * 生产指定数量的产品
     *
     * @param neednum 指定数量的产品
     */
    public synchronized void produce(int neednum) {
//        测试是否需要生产
        while (neednum + curnum > max_size) {
            System.out.println("要生产的产品数量:" + neednum +
                    "超过剩余库存量:" + (max_size - curnum) + "，暂时不能执行生产任务!");
            try {
//                当前的生产线程等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //满足生产条件，则进行生产，这里简单的更改当前库存量
        curnum += neednum;
        System.out.println("已经生产了:" + neednum + "个产品，现仓储量为:" + curnum);
        //唤醒在此对象监视器上等待的所有线程
        notifyAll();
    }

    /**
     * 消费指定数量的产品
     *
     * @param neednum
     */
    public synchronized void consume(int neednum) {
        //测试是否可以消费
        while (curnum < neednum) {
            System.out.println("需要消费" + neednum + "个,当前库存:" + curnum + "个，不够消费");
            try {
                //当前的消费线程等待 释放锁
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //满足消费条件，则进行消费，这里简单的更改当前库存
        curnum -= neednum;
        System.out.println("已经消费了:" + neednum + "个产品，现仓储量为:" + curnum);
        //唤醒在此对象监视器上等待的所有线程
        notifyAll();
    }
}
