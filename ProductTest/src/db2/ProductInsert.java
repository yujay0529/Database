package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductInsert {

	public static void main(String[] args) {
		//����
		try {
			//JDBC Driver Ŭ������ ��ü ���� ��Ÿ�ӽ� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// ���� �ּ�, ����� ����, �н����� ���ڿ� ����
			String url = "jdbc:mysql://localhost:3306/sqldb2?serverTimezone=UTC";
			String user = "root";
			String pwd = "1234";
			
			// DB �����ϱ� ���� ��ü ����
			// DriverManager�� ���� Connection ��ü ����
			// MySQL ���� ���� : �ּ�, ����� ����, �н����� ����
			Connection con = DriverManager.getConnection(url, user, pwd);
			
			// Connection ��ü�� �����Ǹ� DB ���� ����
			if(con != null) {
				System.out.println("DB ���� ����!");
			}		
			//������ ������
			String PrdNo = "1016";
			String PrdName = "������ z �ø�3";
			int prdPrice = 1250000;
			String prdMaker = "�Ｚ";
			String prdColor = "����";
			int ctgNo = 2;
		
			
			String sql = "insert into product values(?,?,?,?,?,?)";
			// values�� �� �� ����
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,PrdNo);
			pstmt.setString(2,PrdName);
			pstmt.setInt(3,prdPrice);
			pstmt.setString(4,prdMaker);
			pstmt.setString(5,prdColor);
			pstmt.setInt(6,ctgNo);
			
			
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("������ �Է� ����!");
			}
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}
		//���� �Ϸ�
		
	} 

}
