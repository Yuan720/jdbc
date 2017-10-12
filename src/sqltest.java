import java.sql.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Created by Administrator on 2017/5/2.
 * @version v1.0
 */
public class sqltest {

    static void test()throws SQLException{
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection link=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","yhyhoney");
        Statement st=link.createStatement();

        ResultSet rs=st.executeQuery("select * from website");
        while(rs.next()){
            System.out.println("站点名："+rs.getString("name")+"网址"+rs.getString("url")+"国家"+rs.getString("country"));

        }

        }

    int road(int m,int n){
        if(m==1&n==1)
            return 2;
        else
        if(m==1&&n!=1)
        {
            return road(m,n-1)+1;
        }
        if(n==1&&m!=1)
        {
            return road(m-1,n)+1;
        }
        else
            return road(m-1,n)+road(m,n-1);

    }


        /**
         * @param path
         *            图片路径
         */
        public static void createAsciiPic(final String path) {
            final String base = " 10o";// 字符串由复杂到简单
            try {
                final BufferedImage image = ImageIO.read(new File(path));
                for (int y = 0; y < image.getHeight(); y += 2) {
                    for (int x = 0; x < image.getWidth(); x++) {
                        final int pixel = image.getRGB(x, y);
                        final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                        final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                        final int index = Math.round(gray * (base.length() + 1) / 255);

                      System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                    }
                   System.out.println();
                }
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * test
         *
         * @param args
         */
        public static void main(final String[] args) {
         createAsciiPic("C:\\Users\\Administrator\\Desktop\\huayun.jpg");
        }
    }


