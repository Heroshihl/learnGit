package stream;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/28
 * @CLASSNAME
 * @description 下面的例子用 write() 把字符 "A" 和紧跟着的换行符输出到屏幕：
 */
public class ConsoleOut {
    public static void main(String[] args) {
        int b;
        b = 'A';
        char c;
        c = 'A';
        System.out.write(b);
        System.out.write('\n');
        System.out.write(c);
        System.out.write('\n');
    }
}
