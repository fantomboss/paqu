package client;

import javax.swing.*;
import java.awt.*;

/**
 * @author fantomboss
 * @date 2019/4/19-15:49
 */
public class mainJFrame extends JFrame {
  JTabbedPane mainJtp;
  JLabel a,b,c;

  private void initJtp(){
    mainJtp = new JTabbedPane();
    a = new JLabel("预留标签");
    b = new JLabel("预留标签");
    c = new JLabel("预留标签");
    mainJtp.addTab("阿里巴巴",a);
    mainJtp.addTab("淘宝",b);
    mainJtp.addTab("天猫",c);
  }

  public void start(){

    initJtp();

    //setLayout(null);
    Container c = getContentPane();

    c.add(mainJtp);

    setVisible(true);
    setSize(1000,800);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }


}
