package db9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO implements IStudentDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 생성자 : 데이터베이스 연결
	public StudentDAO() {
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
	
	@Override
	public ArrayList<StudentDTO> selectStudent() {
		ArrayList<StudentDTO> dataSet = null; // try 안과 밖에서 사용
		
		try {
			// sql 직성
			String sql = "select * from student order by stdNo";
			
			// 쿼리문 전송을 위한 PreparedStatement 객체 생성
			// Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성	
			pstmt = con.prepareStatement(sql);
			
			// 쿼리문 실행시키고 결과 받아옴
			// select 구문이므로 executeQuery() 메서드 사용
			// 반환되는 결과는 ResultSet 객체가 받음	
			rs = pstmt.executeQuery(sql);
			
			dataSet = new ArrayList<StudentDTO>();			
			
			while(rs.next()) {
				dataSet.add(new StudentDTO(rs.getString(1),
						                   rs.getString(2),
						                   rs.getInt(3),
						                   rs.getString(4),
						                   rs.getDate(5).toString(),
						                   rs.getString(6)
							));		// DTO 1개가 1행에 해당		
				
			}
			
		} catch (Exception e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}
		return dataSet;  // ArrayList<StudentDTO> 반환
	}

	@Override
	public void insertStudent(StudentDTO dto) {
		try {
			//sql 문 작성
			String sql = "insert into student values(?,?,?,?,?,?)";
			
			//sql문 values에 들어갈 데이터 설정
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getStdNo());
			pstmt.setString(2, dto.getStdName());
			pstmt.setInt(3, dto.getStdYear());
			pstmt.setString(4, dto.getStdAddress());
			pstmt.setString(5, dto.getStdBirthday());
			pstmt.setString(6, dto.getDptNo());	
			
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
