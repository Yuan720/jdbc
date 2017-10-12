import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2.
 */
public class PictureSend
{
    public static void main(String[] args)throws Exception {
new PictureSend().Sent();
    }
    void Sent()throws IOException {
        Socket sk=new Socket("127.0.0.1",4578);
        System.out.println(sk.isConnected()? "已连接。。。":"连接不可达！");
       OutputStream ips=sk.getOutputStream();
        FileInputStream fip=new FileInputStream("D:\\图片\\Saved Pictures/瀑布.jpg");
        int len=0;
        byte[] buf=new byte[1024];

        while ((len=fip.read(buf))!=-1){
            ips.write(buf,0,len);


        }
sk.shutdownOutput();
        System.out.println("发送完毕！");
        sk.close();
    }
}
