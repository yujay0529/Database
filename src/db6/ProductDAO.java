package db6;

//(1) 생성자에서 DB 연결
//(2) selectStudent() 메서드 : 데이터베이스의 student 테이블에서 select 한 결과 출력
//(3) insertStudent(StudentDTO dto) 메서드 
//		- main()에서 입력한 student 데이터를 전달 받아서 
//   - student 테이블에 insert 작업 수행

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
	
	// 생성자 : 데이터베이스 연결
	public ProductDAO() {
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
	public void selectProduct() {
		
		try {
			// sql 직성
			String sql = "select * from product order by prdNo";
			
			// 쿼리문 전송을 위한 PreparedStatement 객체 생성
			// Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성	
			pstmt = con.prepareStatement(sql);
			
			// 쿼리문 실행시키고 결과 받아옴
			// select 구문이므로 executeQuery() 메서드 사용
			// 반환되는 결과는 ResultSet 객체가 받음	
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
			System.out.println("오류 발생");
			e.printStackTrace();
		}
	}
	
	//(3) insertStudent(StudentDTO dto)
	public void insertProduct(ProductDTO dto) {
		try {
			//sql 문 작성
			String sql = "insert into product values(?,?,?,?,?,?)";
			
			//sql문 values에 들어갈 데이터 설정
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPrdNo());
			pstmt.setString(2, dto.getPrdName());
			pstmt.setInt(3, dto.getPrdPrice());
			pstmt.setString(4, dto.getPrdMaker());
			pstmt.setString(5, dto.getPrdColor());
			pstmt.setInt(6, dto.getCtgNo());
			
			// 쿼리문 실행
			int result = pstmt.executeUpdate();
			
			if(result > 0)
				System.out.println("데이터 입력 성공!");
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
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
		
		public void deleteProduct(ProductDTO dto) {
			try {
				String sql = "delete from product where prdNo=?";
				// 쿼리문 전송을 위한 PreparedStatement 객체 생성
				// Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성
				// sql 문에서 검색할 값(?)에 데이터 설정	
				PreparedStatement pstmt = con.prepareStatement(sql);			
				pstmt.setString(1, dto.getPrdNo());
				//실행쿼리문 : 영향을 받은 행의 수 반환
				
				int result = pstmt.executeUpdate();
				
				// 결과 출력 : 성공!
				if(result > 0)
					System.out.println("데이터 삭제 성공!");
				
			} catch (Exception e) {
				System.out.println("오류 발생!");
				e.printStackTrace();
			}
		}
			
}






