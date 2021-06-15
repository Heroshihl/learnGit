package stream;

import java.io.*;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/28
 * @CLASSNAME
 * @description 程序首先创建文件test.txt，并把给定的数字以二进制形式写进该文件，同时输出到控制台上。
 *
 * 以下代码由于是二进制写入，可能存在乱码，：
 */
public class FileStreamTest {
    public static void main(String args[]) {
        try {
            byte[] bWrite = { 11,2,33,87,22 };
            OutputStream os = new FileOutputStream("C:test.txt");
            for (int x = 0; x < bWrite.length; x++) {
                // writes the bytes
                os.write(bWrite[x]);
            }
            os.close();

            InputStream is = new FileInputStream("C:test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + " ");
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
}
