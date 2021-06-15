package concurrentcollaboration.productionandconsumption.sankeixingzang;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 */
public class Producer implements Runnable {
    private ShareResource shareResource;

    public Producer(ShareResource shareResource) {
        this.shareResource = shareResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                shareResource.push("生产时逸霏" + i + "号", "女");
            } else {
                shareResource.push("华仔揍" + i + "次", "男");
            }
        }
    }
}
