package Util.HttpUtil;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author fantomboss
 * @date 2019/4/19-10:30
 */
public class HttpGetPost {

  public static String sendPostRequest(String reqUrl,QueryParams suffix){
    StringBuilder sb=new StringBuilder();
    try {
      //打开post通道
      URL url=new URL(reqUrl);
      URLConnection urlCon=url.openConnection();
      urlCon.setDoOutput(true);
      //写参数
      OutputStreamWriter out=new OutputStreamWriter(urlCon.getOutputStream(),"UTF-8");
      out.write(suffix.toString());
      out.flush();
      out.close();
      //读返回
      BufferedReader reader = new BufferedReader(new InputStreamReader(urlCon.getInputStream(),"UTF-8"));
      String line;
      while((line=reader.readLine())!=null){
        sb.append(line);
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
    }
    System.out.println(sb);
    return sb.toString();
  }
}
