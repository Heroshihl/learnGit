package stream;

import java.io.*;
import java.util.Scanner;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/28
 * @CLASSNAME
 * @description 从指定文件中读取内容，展现在控制台，然后控制台修改内容，
 * 将内容输出到源文件
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
//        用它来读文件
        File fileIn = new File("C:IN.txt");
//        用来写文件
        File fileOut = new File("C:OUT.txt");
//        输入流
        FileInputStream inputStream = new FileInputStream(fileIn);
//        输出流
        FileOutputStream outputStream = new FileOutputStream(fileOut);
//        读取流
        InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
//        写入流
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");

        StringBuffer buffer = new StringBuffer();
//        读取文件中的内容
        while (streamReader.ready()) {
            buffer.append((char) streamReader.read());
        }
        System.out.println("文中的内容如下:");
        System.out.println(buffer);
//        关闭读取流
        streamReader.close();
//        关闭输入流
        inputStream.close();

        System.out.println("是否需要修改，请输入yes or no");
//        从控制台获取结果
//        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if ("yes".equals(s)) {
            System.out.println("请输入修改后的内容");
//            获取控制台的修改内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String readLine = reader.readLine();
//           // 把字符串转换成字节写入到缓冲区
            writer.append(readLine);
            writer.append("\r\n");
        } else {
            System.out.println("不做任何修改");
        }
//        关闭写入流
        writer.close();
//        关闭输出流
        outputStream.close();
    }
}
