
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
			
			// Connection 객체가 생성되면 DB 연결 성공
			if(con != null) {
				System.out.println("DB 연결 성공!");
			}	
			
			String sql = "select * from product order by prdNo";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
			
			ResultSet rs = pstmt.executeQuery(sql);
			
			System.out.println("\n제품 관리 조회!");
			System.out.println("제품번호 \t\t 제품명 \t\t\t\t가격 \t\t제조사 \t\t 섹상 \t 카테고리넘버");
			
			
			while(rs.next()) {
				// (1) next() 하면서 한 행씩 데이터를 가져와서 변수에 저장
				String prdNo = rs.getString(1);
				String prdName = rs.getString(2);
				int prdPrice = rs.getInt(3);
				String prdMaker = rs.getString(4);
				String prdColor = rs.getString(5);
				int ctgNo = rs.getInt(6);
			
				
				// (2) 한 행씩 변수값 출력
				System.out.format("%-10s\t %-25s\t %-10d %10s %13s \t%3d\n", 
						prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
			}
			
			
			// 모든 객체 close() : 리소스 반납
			rs.close();
			pstmt.close();
			con.close();			
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}		
		
	}

}

