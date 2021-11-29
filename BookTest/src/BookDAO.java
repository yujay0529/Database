

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
			//JDBC Driver 클래스의 객체 생성 런타임시 로드
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 연결 주소, 사용자 계정, 패스워드 문자열 설정
			String url = "jdbc:mysql://localhost:3306/book_test?serverTimezone=UTC";
			String user = "root";
			String pwd = "1234";
			
			// DB 연결하기 위한 객체 생성
			// DriverManager를 통해 Connection 객체 생성
			// MySQL 서버 연결 : 주소, 사용자 계정, 패스워드 전송
			con = DriverManager.getConnection(url, user, pwd);
			
			// Connection 객체가 생성되면 DB 연결 성공
			if(con != null) {
				System.out.println("DB 연결 성공!");
			}			
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}
	}
	
	//(2) selectStudent() 메서드
	public void selectBook() {
		
		try {
			// sql 직성
			String sql = "select * from book order by bookNo";
			
			// 쿼리문 전송을 위한 PreparedStatement 객체 생성
			// Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성	
			pstmt = con.prepareStatement(sql);
			
			// 쿼리문 실행시키고 결과 받아옴
			// select 구문이므로 executeQuery() 메서드 사용
			// 반환되는 결과는 ResultSet 객체가 받음	
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
			System.out.println("오류 발생");
			e.printStackTrace();
		}
	}
	
	
	public void insertBook(BookDTO dto) {
		try {
			//sql 문 작성
			String sql = "insert into book values(?,?,?,?,?,?)";
			
			//sql문 values에 들어갈 데이터 설정
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBookNo());
			pstmt.setString(2, dto.getBookTilte());
			pstmt.setString(3, dto.getBookAuthor());
			pstmt.setInt(4, dto.getBookYear());
			pstmt.setInt(5, dto.getBookPrice());
			pstmt.setString(6, dto.getBookPublisher());
			
			// 쿼리문 실행
			int result = pstmt.executeUpdate();
			
			if(result > 0)
				System.out.println("데이터 입력 성공!");
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}		
	}	
}





