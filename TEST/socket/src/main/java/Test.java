import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author shihl
 * @date 2020/9/2 14:56
 * @description
 */
public class Test {
//    public static void main(String[] args) {
//        String ip = "192.168.1.192";
//        Integer port = 3306;
//        Integer outTime= 3000;
//        Socket socket;
//        InetSocketAddress address = new InetSocketAddress(ip, port);
//        try {
//             socket = new Socket();
//             socket.connect(address,outTime);
//            System.out.println("连接成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("连接失败");
//            System.out.println(e.getMessage());
//        }
//    }

    public static void main(String[] args) {
        int[] arr = new int[4]; int intvalue = arr[3];
        int[] x = {1,2,3,4};
        int[] y = new int[]{1,2,3,4,5};
        System.out.println("arr :" + arr);
        System.out.println("intvalue :" + intvalue);
        System.out.println("x :" + x);
        System.out.println("y :" + y);
    }
}
