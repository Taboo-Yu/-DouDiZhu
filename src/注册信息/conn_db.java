package ע����Ϣ;
import java.sql.*; //����java.sql��

public class conn_db { // ������Conn
	Connection con; // ����Connection����

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

	public static void main(String[] args) { // ������
		conn_db c = new conn_db(); // �����������
		c.getConnection(); // �����������ݿ�ķ���
	}
}
