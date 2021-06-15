package stream;

import java.io.File;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/28
 * @CLASSNAME
 * @description
 */
public class DeleteFileDemo {
    // 删除文件及目录
    public static void deleteFolder(File folder) {
//        获得文件下的一级文件
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
//                    递归调用
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
    public static void main(String args[]) {
        // 这里修改为自己的测试目录
        File folder = new File("C:/home");
        deleteFolder(folder);
    }
}
