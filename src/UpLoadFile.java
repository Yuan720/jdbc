import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.net.Socket;

public class UpLoadFile {
    static String flieName;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //f.setLocation(400,800);
        FileDialog d = new FileDialog(f, "选择文件", FileDialog.LOAD);
        d.setVisible(true);
        flieName = d.getFile();
        if (flieName.length() > 200) {
            System.err.println("文件名过长,请修改后重试!");
            System.exit(0);
        }
        String path = d.getDirectory() + d.getFile();
        // System.out.println(path);
        new UpLoadFile().upload(path);


    }

    void displayFile(String path) {
        File p = new File(path);
        try {
            int num;
            FileReader fr = new FileReader(p);
            char[] ch = new char[1024];
            while ((num = fr.read(ch)) != -1) {
                System.out.println(new String(ch, 0, num));
            }
        } catch (FileNotFoundException e) {
            System.err.println("错误,未指定文件!请重试");
        } catch (IOException e2) {
            e2.printStackTrace();

        } finally {
            System.exit(0);
        }

    }

    void upload(String path) {

        File localeFile = new File(path);
        byte[] buf = new byte[1024];
        Socket upLoadSocket;
        int num = 0;
        OutputStream upIp;
        try {
            upLoadSocket = new Socket("127.0.0.1", 8456);
            upIp = upLoadSocket.getOutputStream();
            FileInputStream upLoad = new FileInputStream(path);
            upIp.write(flieName.getBytes());
            System.out.println(upLoadSocket.isOutputShutdown());


            while ((num = upLoad.read(buf)) != -1) {
                upIp.write(buf, 0, num);
            }
            upLoadSocket.shutdownOutput();
            upLoadSocket.close();
            upIp.close();
            System.out.println("上传成功!");
            System.exit(0);

        } catch (FileNotFoundException e) {
            System.err.println("请检查文件路径");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
