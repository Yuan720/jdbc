import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/8/10.
 */
public class ReciveFile {
    public static void main(String[] args) {
        new ReciveFile().recive();
    }

    void recive() {
        try {

            ServerSocket sst = new ServerSocket(8456);
            Socket rs = sst.accept();
            InputStream in = rs.getInputStream();
            int reciveCode;
            byte[] fileName = new byte[200];
            byte[] buf = new byte[1024];
            String name = null;
            reciveCode = in.read(fileName);


            name = new String(fileName, 0, reciveCode);

            FileOutputStream fo = new FileOutputStream("D:\\" + name);

            while ((reciveCode = in.read(buf)) != -1) {
                fo.write(buf, 0, reciveCode);
            }
            System.out.println(name + "已被接收");
            sst.close();
            in.close();
            System.exit(0);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
