

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	public BookDAO() {
		try {
			//JDBC Driver Ŭ������ ��ü ���� ��Ÿ�ӽ� �ε�
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			// ���� �ּ�, ����� ����, �н����� ���ڿ� ����
			String url = "jdbc:mysql://localhost:3306/book_test?serverTimezone=UTC";
			String user = "root";
			String pwd = "1234";
			
			// DB �����ϱ� ���� ��ü ����
			// DriverManager�� ���� Connection ��ü ����
			// MySQL ���� ���� : �ּ�, ����� ����, �н����� ����
			con = DriverManager.getConnection(url, user, pwd);
			
			// Connection ��ü�� �����Ǹ� DB ���� ����
			if(con != null) {
				System.out.println("DB ���� ����!");
			}			
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}
	}
	
	//(2) selectStudent() �޼���
	public void selectBook() {
		
		try {
			// sql ����
			String sql = "select * from book order by bookNo";
			
			// ������ ������ ���� PreparedStatement ��ü ����
			// Connection �������̽��� prepareStatement() �޼ҵ带 ����Ͽ� ��ü ����	
			pstmt = con.prepareStatement(sql);
			
			// ������ �����Ű�� ��� �޾ƿ�
			// select �����̹Ƿ� executeQuery() �޼��� ���
			// ��ȯ�Ǵ� ����� ResultSet ��ü�� ����	
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				String bookNo = rs.getString(1);
				String bookTitle = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookYear = rs.getInt(4);
				int bookPrice = rs.getInt(5);
				String bookPublisher = rs.getString(6);
				
				System.out.format("%-10s\t %-10s\t %-4s %-10d %13d %10s\n", 
						bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
			}
			
		} catch (Exception e) {
			System.out.println("���� �߻�");
			e.printStackTrace();
		}
	}
	
	
	public void insertBook(BookDTO dto) {
		try {
			//sql �� �ۼ�
			String sql = "insert into book values(?,?,?,?,?,?)";
			
			//sql�� values�� �� ������ ����
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBookNo());
			pstmt.setString(2, dto.getBookTilte());
			pstmt.setString(3, dto.getBookAuthor());
			pstmt.setInt(4, dto.getBookYear());
			pstmt.setInt(5, dto.getBookPrice());
			pstmt.setString(6, dto.getBookPublisher());
			
			// ������ ����
			int result = pstmt.executeUpdate();
			
			if(result > 0)
				System.out.println("������ �Է� ����!");
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}		
	}	
}





