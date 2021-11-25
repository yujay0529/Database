package db1;

// 단축키 : Ctrl + Shift + O
// 맥에서는 Ctrl 대신 command 키 사용

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class BookSelect{

	public static void main(String[] args) {
		try {
			//JDBC Driver 클래스의 객체 생성 런타임시 로드
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
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
			
			// DB 연결 성공 후 SELECT 작업 처리
			
			// select 쿼리문 문자열 생성
			String sql = "select * from book order by bookNo";
			
			// 쿼리문 전송을 위한 PreparedStatement 객체 생성
			// Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
			// 쿼리문 실행시키고 결과 받아옴
			// select 구문이므로 executeQuery() 메서드 사용
			// 반환되는 결과는 ResultSet 객체가 받음			
			ResultSet rs = pstmt.executeQuery(sql);
			
			System.out.println("\n도서 정보 조회!");
			System.out.println("도서번호 \t\t 도서명 \t\t\t\t 저자 \t\t가격 \t 발행일 \t\t 재고 \t 출판사번호");
			
			
			// executeQuery() 실행 결과 받아온 ResultSet에서 데이터를 추출
			// ResultSet의 next() 메서드를 이용해서
			// 논리적 커서를 이동해서 각 열의 데이터 바인딩해 옴
			// next(): 커서를 이동하면 다음 행 지정
			// 다음 행이 있으면 true, 없으면 false 반환
			// 반복문을 사용해서 true인 동안 다음 행을 계속해서 가져옴 : 모든 행 가져옴
			// 데이터 타입에 맞춰 getXXX() 메서드 사용
			while(rs.next()) {
				// (1) next() 하면서 한 행씩 데이터를 가져와서 변수에 저장
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);	
				
				// (2) 한 행씩 변수값 출력
				System.out.format("%-10s\t %-25s\t %-10s %6d %13s \t%3d %10s\n", 
						bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
				
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

