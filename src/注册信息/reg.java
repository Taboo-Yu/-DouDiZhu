package ע����Ϣ;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;


public class reg extends JFrame
{
 
	public reg()
	{   
		reg_db p =new reg_db();
         p.getConnection();
         p.number();
		init();
	}
 
	/**
	 * ��ʼ���������
	 */
	private void init()
	{
		/*
		 * ����JTable������
		 */
		String[] columnNames =
		{ "account",  "score" };
 
		/*
		 * ��ʼ��JTable��������ֵ����������һģһ����ʵ��"�Կ���"ѧ����
		 */
		Object[][] obj = new Object[5][2];
				for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				switch (j)
				{
				case 0:
					obj[i][j] =reg_db.jk[i][j];
					break;
				case 1:
					obj[i][j] =reg_db.jk[i][j];
					break;
				
				}
			}
		}
		
		
		/*
		 * JTable������һ�ֹ��췽��
		 */
		JTable table = new JTable(obj, columnNames);
		/*
		 * ����JTable����Ĭ�ϵĿ�Ⱥ͸߶�
		 */
		TableColumn column = null;
		int colunms = table.getColumnCount();
		for(int i = 0; i < colunms; i++)
		{
			column = table.getColumnModel().getColumn(i);
			/*��ÿһ�е�Ĭ�Ͽ������Ϊ150*/
			column.setPreferredWidth(150);
			table.setRowHeight(36);
		}
		/*
		 * ����JTable�Զ������б��״̬���˴�����Ϊ����
		 */
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		/*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/
		JScrollPane scroll = new JScrollPane(table);
		scroll.setSize(200, 200);
		
		
		add(scroll);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	//public static void main(String[] args)
	//{  
	    
		//new reg();
	//}
}

