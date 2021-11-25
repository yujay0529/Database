package db1;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookInsertInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� ���");
		System.out.println("-------------------------\n");
		System.out.println("������ȣ �Է�:");
		String bookNo = sc.next();
		System.out.println("������ �Է�:");
		String bookName = sc.next();
		System.out.println("���ڸ� �Է�:");
		String bookAuthor = sc.next();
		System.out.println("���� �Է�:");
		int bookPrice = sc.nextInt();
		sc.nextLine();
		System.out.println("������ �Է�:");
		String bookDate = sc.next();
		System.out.println("��� �Է�:");
		int bookStock = sc.nextInt();
		System.out.println("���ǻ� ��ȣ �Է�:");
		String pubNo = sc.next();
		// TODO Auto-generated method stub
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
			//������ ������
			
			
			String sql = "insert into book values(?,?,?,?,?,?,?)";
			// values�� �� �� ����
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,bookNo);
			pstmt.setString(2,bookName);
			pstmt.setString(3,bookAuthor);
			pstmt.setInt(4,bookPrice);
			pstmt.setString(5,bookDate);
			pstmt.setInt(6,bookStock);
			pstmt.setString(7,pubNo);
			
			//������ ���� : ������ ���� ���� �� ��ȯ
			// executeQuery() - ��� �� ResultSet��ȯ
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("������ �Է�  ����!");
			}
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}

	}

}
