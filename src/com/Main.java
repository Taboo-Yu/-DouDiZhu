package com;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import ע����Ϣ.login;

public class Main extends JFrame implements ActionListener {
	
	public Container container = null;// ��������
	JMenuItem start, exit, about,chongzhi;// ����˵���ť
	JButton landlord[]=new JButton[2];//��������ť
	JButton publishCard[]=new JButton[2];//���ư�ť
	int dizhuFlag;//������־
	int turn;
	JLabel dizhu; //����ͼ��
	List<Card> currentList[] =new ArrayList[3]; //  ��ǰ�ĳ���
	List<Card> playerList[] = new ArrayList[3]; // ����3����ұ�
	List<Card> lordList;//������
	Card card[] = new Card[56]; // ����54����
	JTextField time[]=new JTextField[3]; //��ʱ��
	Time t; //��ʱ�����̣߳�
	boolean nextPlayer=false; //ת����ɫ
	

	
public Main(){

	    Music p=new Music();
	    p.loopMusic();
		Init();// ��ʼ��
		SetMenu();// �����˵� ��ť(������������,��ʱ��)
		this.setVisible(true);
		CardInit();//����
	
		getLord(); //�����ƿ�ʼ������
		time[1].setVisible(true);
		//�̰߳�ȫ��,�ѷ����̵߳�UI���Ʒŵ�����
		SwingUtilities.invokeLater(new NewTimer(this,10));
		}
	// ������
	public void getLord(){
		//System.out.println(CardType.c0.toString());
		for(int i=0;i<2;i++)
			landlord[i].setVisible(true);
	}
	//��ʼ����
	// ����ϴ��
	public void CardInit() {
		
		int count = 1;
		//��ʼ����
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 13; j++) {
				if ((i == 5) && (j > 2))
					break;
				else {
					card[count] = new Card(this, i + "-" + j, false);
					card[count].setLocation(300+(i*20), 50);
					container.add(card[count]);
					count++;
				}
			}
		}
		
		//����˳��
		for(int i=0;i<200;i++){
			Random random=new Random();
			int a=random.nextInt(54)+1;
			int b=random.nextInt(54)+1;
			Card k=card[a];
			card[a]=card[b];
			card[b]=k;
		}
		//��ʼ����
		for(int i=0;i<3;i++)
			playerList[i]=new ArrayList<Card>(); //�����
			lordList=new ArrayList<Card>();//����������
		int t=0;
		for(int i=1;i<=54;i++)
		{
			if(i>=52)//������
			{
				Common.move(card[i], card[i].getLocation(),new Point(300+(i-52)*80,16),t);
				lordList.add(card[i]);
				continue;
			}
			switch ((t++)%3) {
			case 0:
				//������
				Common.move(card[i], card[i].getLocation(),new Point(50,60+i*5),t);
				playerList[0].add(card[i]);
				card[i].turnRear(); //��ʾ����
				break;
			case 1:
				//��
				Common.move(card[i], card[i].getLocation(),new Point(180+i*7,450),t);
				playerList[1].add(card[i]);
				card[i].turnFront(); //��ʾ����
				break;
			case 2:
				//�ұ����
				Common.move(card[i], card[i].getLocation(),new Point(700,60+i*5),t);
				playerList[2].add(card[i]);
				card[i].turnRear(); //��ʾ����
				break;
			}
			//card[i].turnFront(); //��ʾ����
			container.setComponentZOrder(card[i], 0);
		}
		//���������򣬴Ӵ�С
		for(int i=0;i<3;i++)
		{
			Common.order(playerList[i]);
			Common.rePosition(this,playerList[i],i);//���¶�λ
		}
		dizhu=new JLabel(new ImageIcon("images/dizhu.gif"));
		dizhu.setVisible(false);
		dizhu.setSize(40, 40);
		container.add(dizhu);
	}

	// ��ʼ������
	public void Init() {

		this.setTitle("����������");
		this.setSize(830, 620);
		setResizable(false);
		setLocationRelativeTo(getOwner()); // ��Ļ����
		container = this.getContentPane();
		container.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setBackground(new Color(46, 139, 87)); // ����Ϊ��ɫ
		
	}

	// �����˵� ���ܰ�ť
	
	public void SetMenu() {
		JMenuBar jMenuBar = new JMenuBar();
		JMenu game = new JMenu("��Ϸ");
		JMenu help = new JMenu("����");
		JMenu hh = new JMenu("��Q����");

		start = new JMenuItem("����Ϸ");
		exit = new JMenuItem("�˳�");
		about = new JMenuItem("����");
        chongzhi = new JMenuItem("��ֵ");
        
		start.addActionListener(this);
		exit.addActionListener(this);
		about.addActionListener(this);
        chongzhi.addActionListener(this);
        
		game.add(start);
		game.add(exit);
		hh.add(chongzhi);
		help.add(about);

		jMenuBar.add(game);
		jMenuBar.add(help);
		jMenuBar.add(hh);
		this.setJMenuBar(jMenuBar);
		
		landlord[0]=new JButton("������");
		landlord[1]=new JButton("��     ��");
		publishCard[0]= new JButton("����");
		publishCard[1]= new JButton("��Ҫ");
		for(int i=0;i<2;i++)
		{
			publishCard[i].setBounds(320+i*100, 400, 60, 20);
			landlord[i].setBounds(320+i*100, 400,75,20);
			container.add(landlord[i]);
			landlord[i].addActionListener(this);
			landlord[i].setVisible(false);
			container.add(publishCard[i]);
			publishCard[i].setVisible(false);
			publishCard[i].addActionListener(this);
		}
		for(int i=0;i<3;i++){
			time[i]=new JTextField("����ʱ:");
			time[i].setVisible(false);
			container.add(time[i]);
		}
		time[0].setBounds(140, 230, 60, 20);
		time[1].setBounds(374, 360, 60, 20);
		time[2].setBounds(620, 230, 60, 20);
		
		for(int i=0;i<3;i++)
		{
			currentList[i]=new ArrayList<Card>();
		}
		
	}

	//�������¼�
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == exit) {
			this.dispose();
		}
		if (e.getSource() == about) {
			JOptionPane.showMessageDialog(this, "����������");
		}
		if (e.getSource() == start) {
			 this.restart();
			
		}
		if (e.getSource() == chongzhi) {
			JOptionPane.showMessageDialog(this, "������ļ�ͥ");
		}
		if(e.getSource()==landlord[0])
		{
			time[1].setText("������");
			t.isRun=false; //ʱ���ս�
		}
		if(e.getSource()==landlord[1])
		{
			time[1].setText("����");
			t.isRun=false; //ʱ���ս�
		}
		//����ǲ�Ҫ
		if(e.getSource()==publishCard[1])
		{
			this.nextPlayer=true;
			currentList[1].clear();
			time[1].setText("��Ҫ");
			
		}
		//����ǳ��ư�ť
		if(e.getSource()==publishCard[0]){
			
			List<Card> c = new ArrayList<Card>();
			//��ѡ����
			for(int i=0;i<playerList[1].size();i++)
			{
				Card card=playerList[1].get(i);
				if(card.clicked)
				{
					c.add(card);//�ѵ��е��Ʒ����¼���
				}
			}
			/** ����ѡ�������� */
			/*for(int i=0;i<c.size();i++){
				System.out.println("��ѡ�����ǣ�"+c.get(i).name);
			}*/
			
			
			int flag=0;
			
			//�������������
			if(time[0].getText().equals("��Ҫ")&&time[2].getText().equals("��Ҫ"))
			{
			
				if(Common.jugdeType(c)!=CardType.c0)
					flag=1;//��ʾ���Գ���
			}//����Ҹ���
			else{
			
				flag=Common.checkCards(c,currentList);
			}
			//�ж��Ƿ���ϳ���
			if(flag==1)
			{
				currentList[1]=c;
				playerList[1].removeAll(currentList[1]);//�Ƴ��ߵ���
				//��λ����
				Point point=new Point();
				point.x=(770/2)-(currentList[1].size()+1)*15/2;;
				point.y=310;
				for(int i=0,len=currentList[1].size();i<len;i++)
				{
					Card card=currentList[1].get(i);
					Common.move(card, card.getLocation(), point,10);
					point.x+=15;
				}
				//�����ƺ�����������
				Common.rePosition(this, playerList[1], 1);
				time[1].setVisible(false);
				this.nextPlayer=true;
			}

		}
	}
	
	
	private void restart() {
		System.out.println("���¿�ʼ");
	     for(int i=0;i<3;i++){
			currentList[i]=null;
		}
		for(int i=0;i<3;i++){
			playerList[i]=null;
		}
		lordList=null;
		for(int i=0;i<card.length;i++){
			card[i]=null;
		}
		nextPlayer=false;
		this.CardInit();
	}

	//public static void main(String args[]) {
		//new Main();
	//}
class NewTimer implements Runnable{

	Main main;
	int i;
	public NewTimer(Main m,int i){
		this.main=m;
		this.i=i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		main.t=new Time(main,15);//��10��ʼ����ʱ
		main.t.start();
	}
	
}
}