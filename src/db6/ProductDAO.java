package db6;

//(1) �����ڿ��� DB ����
//(2) selectStudent() �޼��� : �����ͺ��̽��� student ���̺��� select �� ��� ���
//(3) insertStudent(StudentDTO dto) �޼��� 
//		- main()���� �Է��� student �����͸� ���� �޾Ƽ� 
//   - student ���̺� insert �۾� ����

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import db5.StudentDTO;

public class ProductDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// ������ : �����ͺ��̽� ����
	public ProductDAO() {
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
	public void selectProduct() {
		
		try {
			// sql ����
			String sql = "select * from product order by prdNo";
			
			// ������ ������ ���� PreparedStatement ��ü ����
			// Connection �������̽��� prepareStatement() �޼ҵ带 ����Ͽ� ��ü ����	
			pstmt = con.prepareStatement(sql);
			
			// ������ �����Ű�� ��� �޾ƿ�
			// select �����̹Ƿ� executeQuery() �޼��� ���
			// ��ȯ�Ǵ� ����� ResultSet ��ü�� ����	
			rs = pstmt.executeQuery(sql);
			
		
			while(rs.next()) {
				String prdNo = rs.getString(1);
				String prdName = rs.getString(2);
				int prdPrice = rs.getInt(3);
				String prdMaker = rs.getString(4);
				String prdColor = rs.getString(5);
				int ctgNo = rs.getInt(6);
				
				System.out.format("%-10s\t %-10s\t %-4d %-20s %13s %5s\n", 
						prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
			}
			
		} catch (Exception e) {
			System.out.println("���� �߻�");
			e.printStackTrace();
		}
	}
	
	//(3) insertStudent(StudentDTO dto)
	public void insertProduct(ProductDTO dto) {
		try {
			//sql �� �ۼ�
			String sql = "insert into product values(?,?,?,?,?,?)";
			
			//sql�� values�� �� ������ ����
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPrdNo());
			pstmt.setString(2, dto.getPrdName());
			pstmt.setInt(3, dto.getPrdPrice());
			pstmt.setString(4, dto.getPrdMaker());
			pstmt.setString(5, dto.getPrdColor());
			pstmt.setInt(6, dto.getCtgNo());
			
			// ������ ����
			int result = pstmt.executeUpdate();
			
			if(result > 0)
				System.out.println("������ �Է� ����!");
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}		
	}	
	public void updateProduct(ProductDTO dto) {
		try {
		String sql = "update book set bookName=?, bookAuthor=?, "
			    + "bookPrice=?, bookDate=?, bookStock=?, pubNo=? where bookNo=?";

			PreparedStatement pstmt = con.prepareStatement(sql);			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPrdName());
			pstmt.setInt(2, dto.getPrdPrice());
			pstmt.setString(3, dto.getPrdMaker());
			pstmt.setString(4, dto.getPrdColor());
			pstmt.setInt(5, dto.getCtgNo());
			pstmt.setString(6, dto.getPrdNo());
	
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
		
		public void deleteProduct(ProductDTO dto) {
			try {
				String sql = "delete from product where prdNo=?";
				// ������ ������ ���� PreparedStatement ��ü ����
				// Connection �������̽��� prepareStatement() �޼ҵ带 ����Ͽ� ��ü ����
				// sql ������ �˻��� ��(?)�� ������ ����	
				PreparedStatement pstmt = con.prepareStatement(sql);			
				pstmt.setString(1, dto.getPrdNo());
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






