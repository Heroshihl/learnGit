package collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/29
 * @CLASSNAME
 * @description
 */
public class TestList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("idea");
        System.out.println("第一种遍历方法使用 For-Each 遍历 List");
        for (String s:list){
            System.out.println(s);
        }

        System.out.println("第二种遍历，把链表变为数组相关的内容进行遍历");
        String[] str = new String[list.size()];
        list.toArray(str);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }

        System.out.println("第三种遍历 使用迭代器进行相关遍历");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
