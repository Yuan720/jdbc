import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/17.
 */
public class Talk_Test_Sent{
    public static void main (String args [])throws Exception {
        DatagramSocket s1 = new DatagramSocket();
        String words;
        while (true){
            System.out.print("输入信息：");
            words=(new Scanner(System.in)).next();
        byte[] ms=words.getBytes();
        DatagramPacket d1 = new DatagramPacket(ms,ms.length,InetAddress.getByName("127.0.0.1"),9999);
s1.send(d1);

        }

    }

}
