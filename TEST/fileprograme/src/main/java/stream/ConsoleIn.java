package stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/28
 * @CLASSNAME
 * @description
 */
public class ConsoleIn {
    public static void main(String[] args) throws IOException {
//        char c;
        String str;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
//        System.out.println("输入字符, 按下 'q' 键退出。");
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        // 读取字符
//        do {
//            c = (char) br.read();
//            System.out.println(c);
//        } while (c != 'q');
        do{
            str = br.readLine();
            System.out.println("输入的字符串为:"+str);
        }while (!"end".equals(str));
    }
}
