package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookInsert {

	public static void main(String[] args) {
		//연결
		try {
			//JDBC Driver 클래스의 객체 생성 런타임시 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 연결 주소, 사용자 계정, 패스워드 문자열 설정
			String url = "jdbc:mysql://localhost:3306/sqldb3?serverTimezone=UTC";
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
			String bookNo = "1016";
			String bookName = "알고리즘";
			String bookAuthor = "김철수";
			int bookPrice = 25000;
			String bookDate = "2021-10-10";
			int bookStock = 10;
			String pubNo = "1";
			
			String sql = "insert into book values(?,?,?,?,?,?,?)";
			// values에 들어갈 거 설정
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,bookNo);
			pstmt.setString(2,bookName);
			pstmt.setString(3,bookAuthor);
			pstmt.setInt(4,bookPrice);
			pstmt.setString(5,bookDate);
			pstmt.setInt(6,bookStock);
			pstmt.setString(7,pubNo);
			
			//퀴리문 실행 : 영향을 받은 행의 수 변환
			// executeQuery() - 결과 행 ResultSet반환
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("데이터 입력  성공!");
			}
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}
		//연결 완료
		
	} 

}
