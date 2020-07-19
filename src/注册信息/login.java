package 注册信息;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.*;

public class login extends JFrame{
	//JLabel accountL,nameL;
	JTextField accountT,nameT;
	JButton okB,registB;
	Box baseB1,baseB2,box1,box2,box3;		//此登录页面采用Box布局方式；
	login_db log;
	
	public login(){
		init();
	}
	public void init(){
		log = new login_db();
		
		accountT = new JTextField(10);
		nameT = new JTextField(20);
		okB = new JButton("登录");
		registB = new JButton("注册");
		
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("账号："));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("姓名"));
		
		box2 = Box.createVerticalBox();
		box2.add(accountT);
		box2.add(Box.createVerticalStrut(8));
		box2.add(nameT);
		
		box3 = Box.createHorizontalBox();
		box3.add(okB);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(registB);
		
		baseB1 = Box.createHorizontalBox();
		baseB1.add(box1);
		baseB1.add(Box.createHorizontalStrut(8));
		baseB1.add(box2);
		
		baseB2 = Box.createVerticalBox();
		baseB2.add(baseB1);
		baseB2.add(Box.createVerticalStrut(10));
		baseB2.add(box3);
		
		okB.addActionListener(log);
		registB.addActionListener(log);
		
		log.setaccountT(accountT);
		log.setnameT(nameT);
		log.setButton(okB,registB);
		
		add(baseB2);
		setLayout(new FlowLayout());
		setBounds(200,300,300,160);
		setVisible(true);
		setTitle("用户登录界面");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		login lo = new login();
		
	}
}
