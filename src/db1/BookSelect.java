package db1;

// ����Ű : Ctrl + Shift + O
// �ƿ����� Ctrl ��� command Ű ���

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class BookSelect{

	public static void main(String[] args) {
		try {
			//JDBC Driver Ŭ������ ��ü ���� ��Ÿ�ӽ� �ε�
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
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
			
			// DB ���� ���� �� SELECT �۾� ó��
			
			// select ������ ���ڿ� ����
			String sql = "select * from book order by bookNo";
			
			// ������ ������ ���� PreparedStatement ��ü ����
			// Connection �������̽��� prepareStatement() �޼ҵ带 ����Ͽ� ��ü ����
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
			// ������ �����Ű�� ��� �޾ƿ�
			// select �����̹Ƿ� executeQuery() �޼��� ���
			// ��ȯ�Ǵ� ����� ResultSet ��ü�� ����			
			ResultSet rs = pstmt.executeQuery(sql);
			
			System.out.println("\n���� ���� ��ȸ!");
			System.out.println("������ȣ \t\t ������ \t\t\t\t ���� \t\t���� \t ������ \t\t ��� \t ���ǻ��ȣ");
			
			
			// executeQuery() ���� ��� �޾ƿ� ResultSet���� �����͸� ����
			// ResultSet�� next() �޼��带 �̿��ؼ�
			// ���� Ŀ���� �̵��ؼ� �� ���� ������ ���ε��� ��
			// next(): Ŀ���� �̵��ϸ� ���� �� ����
			// ���� ���� ������ true, ������ false ��ȯ
			// �ݺ����� ����ؼ� true�� ���� ���� ���� ����ؼ� ������ : ��� �� ������
			// ������ Ÿ�Կ� ���� getXXX() �޼��� ���
			while(rs.next()) {
				// (1) next() �ϸ鼭 �� �྿ �����͸� �����ͼ� ������ ����
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);	
				
				// (2) �� �྿ ������ ���
				System.out.format("%-10s\t %-25s\t %-10s %6d %13s \t%3d %10s\n", 
						bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
				
			}
			
			// ��� ��ü close() : ���ҽ� �ݳ�
			rs.close();
			pstmt.close();
			con.close();			
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}		
		
	}

}

