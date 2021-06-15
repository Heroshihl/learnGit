package serializable;

import java.io.*;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/29
 * @CLASSNAME
 * @description 序列化方法，将员工信息输出到指定目录下面
 */
public class SerializeDemo {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee();
        employee.setName("张三");
        employee.setAddress("南京");
        employee.setNumber(1000);
        employee.setSSN(9);
        String dir = "C:emm.txt";
        File file = new File(dir);
        OutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(employee);
        objectOutputStream.close();
        outputStream.close();
        System.out.println("员工信息写入"+dir);
    }
}
