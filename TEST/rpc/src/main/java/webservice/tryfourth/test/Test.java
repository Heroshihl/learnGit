package webservice.tryfourth.test;

import webservice.tryfourth.phoneclient.Phone;
import webservice.tryfourth.phoneclient.PhoneManager;
import webservice.tryfourth.phoneclient.PhoneService;

/**
 * @author shihl
 * @date 2020/9/10 17:29
 * @description
 */
public class Test {
    public static void main(String[] args) {
        PhoneManager phoneManager = new PhoneManager();
        PhoneService service = phoneManager.getPhoneServicePort();
        Phone info = service.getMObileInfo("android");
        System.out.println(info);
    }
}
