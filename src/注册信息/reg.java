package 注册信息;

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
	 * 初始化窗体组件
	 */
	private void init()
	{
		/*
		 * 设置JTable的列名
		 */
		String[] columnNames =
		{ "account",  "score" };
 
		/*
		 * 初始化JTable里面各项的值，设置两个一模一样的实体"赵匡义"学生。
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
		 * JTable的其中一种构造方法
		 */
		JTable table = new JTable(obj, columnNames);
		/*
		 * 设置JTable的列默认的宽度和高度
		 */
		TableColumn column = null;
		int colunms = table.getColumnCount();
		for(int i = 0; i < colunms; i++)
		{
			column = table.getColumnModel().getColumn(i);
			/*将每一列的默认宽度设置为150*/
			column.setPreferredWidth(150);
			table.setRowHeight(36);
		}
		/*
		 * 设置JTable自动调整列表的状态，此处设置为开启
		 */
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
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

