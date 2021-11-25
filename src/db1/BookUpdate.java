package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BookUpdate {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		
		// 데이터 입력
		System.out.println("도서 정보 수정");
		System.out.println("--------------------------\n");
		
		System.out.print("수정할 도서번호 입력 : ");
		String bookNo = sc.nextLine();
		
		System.out.print("도서명 입력 : ");
		String bookName = sc.nextLine();
		
		System.out.print("저자 입력 : ");
		String bookAuthor = sc.nextLine();
		
		System.out.print("가격 입력 : ");
		int bookPrice = sc.nextInt();
		
		// 앞의 엔터 값이 다음 변수에 들어가지 않도록 읽어 들임
		sc.nextLine();
		
		System.out.print("발행일 입력 : ");
		String bookDate = sc.nextLine();
		
		System.out.print("재고 입력 : ");
		int bookStock = sc.nextInt();
		
		// 앞의 엔터 값이 다음 변수에 들어가지 않도록 읽어 들임
		sc.nextLine();
		
		System.out.print("출판사 번호 입력 : ");
		String pubNo = sc.nextLine();
		
		// 수정할 데이터 입력 완료
		
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
			
			// DB 연결 완료
			
			// SQL 작성
			// 데이터 수정 : UPDATE문 : UPDATE 테이블명 SET 열이름=값 WHERE 조건;
			// 입력된 수정할 도서 번호로 찾아서 입력된 값으로 변경
			// 주의! 기본키 변경 불가하므로 bookNo는 set에 없음
			String sql = "update book set bookName=?, bookAuthor=?, "
					    + "bookPrice=?, bookDate=?, bookStock=?, pubNo=? where bookNo=?";
			
			// 쿼리문 전송을 위한 PreparedStatement 객체 생성
			// Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성
			// sql 문에서 수정할 값(?)에 데이터 설정
			PreparedStatement pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, bookName);
			pstmt.setString(2, bookAuthor);
			pstmt.setInt(3, bookPrice);
			pstmt.setString(4, bookDate);
			pstmt.setInt(5, bookStock);
			pstmt.setString(6, pubNo);	
			pstmt.setString(7, bookNo);
			
			// 실행 쿼리문 : 영햐을 받은 행의 수 반환
			int result = pstmt.executeUpdate();
			
			// 결과 출력 : 성공!
			if(result > 0)
				System.out.println("데이터 수정 성공!");
			
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}

	}

}
