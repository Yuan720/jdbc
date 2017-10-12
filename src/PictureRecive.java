import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/8/2.
 */
public class PictureRecive {
    public static void main(String[] args) throws Exception{
new PictureRecive().recive(4578);
    }
    void recive(int port)throws Exception{
        ServerSocket ssk=new ServerSocket(port);
        Socket ss=ssk.accept();
        System.out.println(ss.getInetAddress());
        InputStream is=ss.getInputStream();
        byte[] pic=new byte[1024];
        FileOutputStream writeFile=new FileOutputStream("D:\\瀑布.jpg");
        int len=0;
        System.out.println("正在接收。。。");
        while((len=is.read(pic))!=-1){
            writeFile.write(pic,0,len);


        }
        System.out.println("完毕！");
ssk.close();ss.close();
    }
}
