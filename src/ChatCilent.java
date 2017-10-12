import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Scanner;

class ChatCilent{
    HashMap<String,String> contact;
    public static void main(String[] args) {
new  ChatCilent().regist();

    }



void regist(){
    contact=new HashMap<String,String>();
      try {
            byte[] buf=new byte[1024];
            MulticastSocket ms=new MulticastSocket(1688);
            ms.joinGroup(InetAddress.getByName("224.0.0.0"));
            DatagramPacket dp=new DatagramPacket(buf,0,buf.length);

            ms.receive(dp);
          System.out.println(new String(buf));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void getOnLine(){

    }
void Sending(){

}
void Listen(){
boolean a;
boolean b;

}
void registToServer(){
    

}
}
