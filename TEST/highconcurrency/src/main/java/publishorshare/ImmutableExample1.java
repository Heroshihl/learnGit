package publishorshare;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/23
 * @CLASSNAME
 * @description
 */
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = new HashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
//        a = 2;
//        b = "3";
//        map = Maps.newHashMap();
        map.put(1, 3);

    }
}

