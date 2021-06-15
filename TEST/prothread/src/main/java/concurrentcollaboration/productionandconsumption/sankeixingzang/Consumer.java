package concurrentcollaboration.productionandconsumption.sankeixingzang;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 */
public class Consumer implements Runnable {
    private ShareResource shareResource;

    public Consumer(ShareResource shareResource) {
        this.shareResource = shareResource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            shareResource.popup();
        }
    }
}
