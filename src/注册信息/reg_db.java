package ע����Ϣ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;



public class reg_db{
	static Connection con;
	static Statement sql;
	static ResultSet res;
	static Object[][] jk = new Object[5][2];
	public Connection getConnection() { // ��������ֵΪConnection�ķ���
		try { // �������ݿ�������
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���ݿ��������سɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try { // ͨ���������ݿ��URL��ȡ���ݿ����Ӷ���
			con = DriverManager.getConnection("jdbc:mysql:"
					+ "//127.0.0.1:3306/dbk", "root", "123456");
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con; // ������Ҫ�󷵻�һ��Connection����
	}
	public void number() {
		reg_db c = new reg_db();
		con = c.getConnection();
		try {
			sql =con.createStatement();
			res =sql.executeQuery("select * from my");
			int i = 0;
			
			while(res.next()&&i<5) {
				String account =res.getString("account");
				jk[i][0]=account;
				System.out.print("account:"+jk[i][0]+"  ");
				
				String score = res.getString("score");
				jk[i][1]=score;
				System.out.println("name:"+jk[i][1]);
				
				i=i+1;
			   }
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}