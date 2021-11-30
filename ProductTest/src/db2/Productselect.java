
package db2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Productselect{

	public static void main(String[] args) {
		try {
			
			String url = "jdbc:mysql://localhost:3306/sqldb2?serverTimezone=UTC";
			String user = "root";
			String pwd = "1234";
			
			
			Connection con = DriverManager.getConnection(url, user, pwd);
			
			// Connection ��ü�� �����Ǹ� DB ���� ����
			if(con != null) {
				System.out.println("DB ���� ����!");
			}	
			
			String sql = "select * from product order by prdNo";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
			
			ResultSet rs = pstmt.executeQuery(sql);
			
			System.out.println("\n��ǰ ���� ��ȸ!");
			System.out.println("��ǰ��ȣ \t\t ��ǰ�� \t\t\t\t���� \t\t������ \t\t ���� \t ī�װ��ѹ�");
			
			
			while(rs.next()) {
				// (1) next() �ϸ鼭 �� �྿ �����͸� �����ͼ� ������ ����
				String prdNo = rs.getString(1);
				String prdName = rs.getString(2);
				int prdPrice = rs.getInt(3);
				String prdMaker = rs.getString(4);
				String prdColor = rs.getString(5);
				int ctgNo = rs.getInt(6);
			
				
				// (2) �� �྿ ������ ���
				System.out.format("%-10s\t %-25s\t %-10d %10s %13s \t%3d\n", 
						prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
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

