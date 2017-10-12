import com.sun.org.apache.xpath.internal.operations.Mult;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ChatServer {

    public static void main(String[] args) {
     //   new OnLineCast().start();


    }

    void addRegist() {

    }

}

class OnLineCast extends Thread {

    @Override
    public void run() {
        try {
        //    ObjectOutputStream class_msg=new ObjectOutputStream();
            String msg = "" ;
            MulticastSocket ms = new MulticastSocket(1688);
            ms.joinGroup(InetAddress.getByName("224.0.0.0"));
            DatagramPacket dp = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, InetAddress.getByName("224.0.0.0"), 1688);
            ms.send(dp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
class Massinge{
    String msg="this is what i want to send to you.";
    String Reciver="you";

}