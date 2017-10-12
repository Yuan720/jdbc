import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by Administrator on 2017/8/12.
 */
public class FileChoose extends JFrame {
    JButton choose=new JButton();
    JTextArea fileList=new JTextArea();
    Label lb;
    JMenu jm;
    JMenuBar jmb;
    JList jl;

   void init (){
    Vector<ListFile> file=new Vector<ListFile>();
       file.add(new ListFile("my.txt","20150702"));
       file.add(new ListFile("hrrt.pdf","20170805"));

        this.setLayout(new GridLayout(10,1));
        lb=new Label("This is a lable can't changge");
        jm=new JMenu("helo");
        jmb=new JMenuBar();
        jl=new JList(file);
jl.setFont(Font.getFont("微软雅黑"));


       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setBounds(400,100,1200,800);
       choose.setText("选择");
       fileList.append("文本显示区");

lb.setBackground(new Color(255,255,255));
       this.add(fileList);
       this.add(choose);
        this.add(lb);
        this.add(jm);
        this.add(jl);
       this.setVisible(true);


   }

    public static void main(String[] args) {
        FileChoose fc=new FileChoose();
        fc.init();

    }
}
class ListFile{
    String name;
    String createdDate;
    public ListFile(String name,String createdDate){
        this.name=name;
        this.createdDate=createdDate;

    }

    @Override
    public String toString() {
        return name+createdDate;
    }
}