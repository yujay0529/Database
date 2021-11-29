package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductInsert {

	public static void main(String[] args) {
		//연결
		try {
			//JDBC Driver 클래스의 객체 생성 런타임시 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 연결 주소, 사용자 계정, 패스워드 문자열 설정
			String url = "jdbc:mysql://localhost:3306/sqldb2?serverTimezone=UTC";
			String user = "root";
			String pwd = "1234";
			
			// DB 연결하기 위한 객체 생성
			// DriverManager를 통해 Connection 객체 생성
			// MySQL 서버 연결 : 주소, 사용자 계정, 패스워드 전송
			Connection con = DriverManager.getConnection(url, user, pwd);
			
			// Connection 객체가 생성되면 DB 연결 성공
			if(con != null) {
				System.out.println("DB 연결 성공!");
			}		
			//저장할 데이터
			String PrdNo = "1016";
			String PrdName = "갤럭시 z 플립3";
			int prdPrice = 1250000;
			String prdMaker = "삼성";
			String prdColor = "검정";
			int ctgNo = 2;
		
			
			String sql = "insert into product values(?,?,?,?,?,?)";
			// values에 들어갈 거 설정
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,PrdNo);
			pstmt.setString(2,PrdName);
			pstmt.setInt(3,prdPrice);
			pstmt.setString(4,prdMaker);
			pstmt.setString(5,prdColor);
			pstmt.setInt(6,ctgNo);
			
			
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("데이터 입력 성공!");
			}
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}
		//연결 완료
		
	} 

}
