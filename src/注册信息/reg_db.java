package 注册信息;

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
	public Connection getConnection() { // 建立返回值为Connection的方法
		try { // 加载数据库驱动类
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try { // 通过访问数据库的URL获取数据库连接对象
			con = DriverManager.getConnection("jdbc:mysql:"
					+ "//127.0.0.1:3306/dbk", "root", "123456");
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con; // 按方法要求返回一个Connection对象
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