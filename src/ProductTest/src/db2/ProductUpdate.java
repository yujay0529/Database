package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ProductUpdate {

	public static void main(String[] args) {
		// �Է�
		Scanner sc = new Scanner(System.in);

		System.out.println("��ǰ���� ���");
		System.out.println("-------------------------\n");
		System.out.println("��ǰ��ȣ �Է�:");
		String prdNo = sc.next();
		System.out.println("��ǰ�� �Է�:");
		String prdName = sc.next();
		System.out.println("���� �Է�:");
		int prdPrice = sc.nextInt();
		System.out.println("������ �Է�:");
		String prdMaker = sc.next();
		sc.nextLine();
		System.out.println("���� �Է�:");
		String prdColor = sc.next();
		System.out.println("ī�װ� ��ȣ �Է�:");
		int ctgNo = sc.nextInt();
		
		// ������ ������ �Է� �Ϸ�
		
		try {
			//JDBC Driver Ŭ������ ��ü ���� ��Ÿ�ӽ� �ε�
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
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
			
			// DB ���� �Ϸ�
			
			String sql = "update product set prdName=?, prdPrice=?, "
					    + "prdMaker=?, prdColor=?, ctgNo=? where prdNo=?";
			
	
			PreparedStatement pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, prdName);
			pstmt.setInt(2, prdPrice);
			pstmt.setString(3, prdMaker);
			pstmt.setString(4, prdColor);
			pstmt.setInt(5, ctgNo);	
			pstmt.setString(6, prdNo);
			
			// ���� ������ : ������ ���� ���� �� ��ȯ
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
