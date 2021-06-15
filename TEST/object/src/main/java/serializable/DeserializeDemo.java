package serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/29
 * @CLASSNAME
 * @description 将文件反序列化输入
 */
public class DeserializeDemo {
    public static void main(String[] args) throws IOException {
        Employee e = null;
        String dir = "C:emm.txt";
        File file = new File(dir);
        FileInputStream stream = new FileInputStream(file);
        ObjectInputStream inputStream = new ObjectInputStream(stream);
        try {
            e = (Employee) inputStream.readObject();
            inputStream.close();
            stream.close();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        System.out.println(e.getName()+e.getAddress()+e.getNumber()+e.getSSN());
    }
}
