package stream;

import java.io.File;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/28
 * @CLASSNAME
 * @description
 */
public class DirList {
    public static void main(String args[]) {
        String dirname = "C:/fable";
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("目录 " + dirname);
//            获得该文件下的一级文件名称
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++) {
//                全路径
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " 是一个目录");
                } else {
                    System.out.println(s[i] + " 是一个文件");
                }
            }
        } else {
            System.out.println(dirname + " 不是一个目录");
        }
    }
}
