package webservice.trythird;

/**
 * @author shihl
 * @date 2020/9/9 16:37
 * @description
 */
public class Test {
    public static void main(String[] args) {
        BossServiceService service = new BossServiceService();
        BossService bossServicePort = service.getBossServicePort();
        String boss = bossServicePort.sayBoss("升职加薪");
        System.out.println(boss);
    }
}
