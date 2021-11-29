package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ProductUpdate {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);

		System.out.println("제품정보 등록");
		System.out.println("-------------------------\n");
		System.out.println("제품번호 입력:");
		String prdNo = sc.next();
		System.out.println("제품명 입력:");
		String prdName = sc.next();
		System.out.println("가격 입력:");
		int prdPrice = sc.nextInt();
		System.out.println("제조사 입력:");
		String prdMaker = sc.next();
		sc.nextLine();
		System.out.println("색상 입력:");
		String prdColor = sc.next();
		System.out.println("카테고리 번호 입력:");
		int ctgNo = sc.nextInt();
		
		// 수정할 데이터 입력 완료
		
		try {
			//JDBC Driver 클래스의 객체 생성 런타임시 로드
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
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
			
			// DB 연결 완료
			
			String sql = "update product set prdName=?, prdPrice=?, "
					    + "prdMaker=?, prdColor=?, ctgNo=? where prdNo=?";
			
	
			PreparedStatement pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, prdName);
			pstmt.setInt(2, prdPrice);
			pstmt.setString(3, prdMaker);
			pstmt.setString(4, prdColor);
			pstmt.setInt(5, ctgNo);	
			pstmt.setString(6, prdNo);
			
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
