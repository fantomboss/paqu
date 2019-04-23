package signIn;

import Util.HttpUtil.HttpGetPost;
import Util.HttpUtil.QueryParams;
import Util.jsonToBean.Beans.returnBean;
import Util.jsonToBean.returnDate;
import client.mainJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author fantomboss
 * @date 2019/4/18-20:35
 */

public class Log extends JFrame {

  private JLabel accountL,pswL,titleL,message;
  private JTextField account,psw;
  private JButton signIn;
  private JFrame jf;

  //初始化组件
  private void init(){
    accountL = new JLabel("账号：");
    pswL = new JLabel("密码：");
    titleL = new JLabel("爬取工具1.0");
    message = new JLabel();
    account = new JTextField();
    psw = new JTextField();
    signIn = new JButton("登录");
  }

  //设置绝对布局下各个组件位置，大小
  private void setCSS(){
    titleL.setBounds(210,37,181,37);titleL.setFont(new Font(Font.DIALOG,1,20));
    accountL.setBounds(138,108,107,36);
    pswL.setBounds(138,144,107,36);
    account.setBounds(208,111,200,30);
    psw.setBounds(208,147,200,30);
    signIn.setBounds(221,200,100,36);
    message.setBounds(230,250,100,36);
  }

  //容器添加
  private void add(Container container){
    container.add(titleL);
    container.add(accountL);
    container.add(account);
    container.add(pswL);
    container.add(psw);
    container.add(signIn);
    container.add(message);
  }

  //绑定监听
  private void addListen(){
    //登录按钮
    signIn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        QueryParams suffix = new QueryParams();
        suffix.add("account", account.getText());
        suffix.add("psw", psw.getText());
        if(getCheckId().equals("fail"))
          return;
        else
          suffix.add("cpuid",getCheckId());
        String getMessage = new HttpGetPost().sendPostRequest("http://localhost:8080/user/login", suffix);
        if (!getMessage.equals(null)) {
          returnBean r = new returnDate().toOneBean(getMessage);
            //测试阶段，上线请调回
          System.out.println(r.getData());
          if (r.getState() == 200){
            //登录成功
            JOptionPane.showMessageDialog(
                    jf,
                    "登录成功",
                    "ERROR_MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            //========开启子页面==========//
            mainJFrame m = new mainJFrame();
            m.start();
            jf.dispose();   //退出
          }
            //登录错误
          else if (r.getState() == 500)
            JOptionPane.showMessageDialog(
                    jf,
                    "登录错误",
                    "ERROR_MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }

  //初始化窗体
  private void CreateJFrame(String title){

    init();
    setCSS();

    jf = new JFrame(title);
    jf.setLayout(null);
    Container container = jf.getContentPane();
    jf.setLayout(null);

    add(container);
    addListen();

    jf.setVisible(true);
    jf.setSize(560,325);
    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  //通过CPU获取机器识别码
  public String getCheckId(){
    String serial = "fail";
    try {
      Process process = Runtime.getRuntime().exec(
              new String[] { "wmic", "cpu", "get", "ProcessorId" });
      process.getOutputStream().close();
      Scanner sc = new Scanner(process.getInputStream());
      serial = sc.next();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return serial;   //BFEBFBFF000506E3
  }

  public static void main(String args[]) {
    System.out.println("hello--world");
    new Log().CreateJFrame("登录窗口");
  }
}
