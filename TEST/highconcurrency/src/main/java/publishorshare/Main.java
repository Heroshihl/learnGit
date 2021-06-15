package publishorshare;

import java.util.Arrays;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/23
 * @CLASSNAME
 * @description 变量逸出原有作用域
 */
public class Main {
    private String[] strs = {"1", "2", "3"};

    public String[] getStrs() {
        return strs;
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        System.out.println(Arrays.toString(m1.getStrs()));
        m1.getStrs()[0] = "4";
        System.out.println(Arrays.toString(m1.getStrs()));
    }
}
