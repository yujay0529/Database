package db1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class BookDelete {

	public static void main(String[] args) {
		// ������ ������ȣ �Է�
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ���� ����");
		System.out.println("--------------------------\n");
		
		System.out.print("������ ������ȣ �Է� : ");
		String bookNo = sc.nextLine();
		
		try {
			//JDBC Driver Ŭ������ ��ü ���� ��Ÿ�ӽ� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// ���� �ּ�, ����� ����, �н����� ���ڿ� ����
			String url = "jdbc:mysql://localhost:3306/sqldb3?serverTimezone=UTC";
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
			//����Ϸ�
			
			String sql = "delete from book where bookNo=?";
			// ������ ������ ���� PreparedStatement ��ü ����
			// Connection �������̽��� prepareStatement() �޼ҵ带 ����Ͽ� ��ü ����
			// sql ������ �˻��� ��(?)�� ������ ����	
			PreparedStatement pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, bookNo);
			//���������� : ������ ���� ���� �� ��ȯ
			
			int result = pstmt.executeUpdate();
			
			// ��� ��� : ����!
			if(result > 0)
				System.out.println("������ ���� ����!");
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}
		
		
		
	}

}
