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
	
	// ������ : �����ͺ��̽� ����
	public StudentDAO() {
		try {
			//JDBC Driver Ŭ������ ��ü ���� ��Ÿ�ӽ� �ε�
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			// ���� �ּ�, ����� ����, �н����� ���ڿ� ����
			String url = "jdbc:mysql://localhost:3306/sqldb2?serverTimezone=UTC";
			String user = "root";
			String pwd = "1234";
			
			// DB �����ϱ� ���� ��ü ����
			// DriverManager�� ���� Connection ��ü ����
			// MySQL ���� ���� : �ּ�, ����� ����, �н����� ����
			con = DriverManager.getConnection(url, user, pwd);
			
			// Connection ��ü�� �����Ǹ� DB ���� ����
			if(con != null) {
				System.out.println("DB ���� ����!");
			}			
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<StudentDTO> selectStudent() {
		ArrayList<StudentDTO> dataSet = null; // try �Ȱ� �ۿ��� ���
		
		try {
			// sql ����
			String sql = "select * from student order by stdNo";
			
			// ������ ������ ���� PreparedStatement ��ü ����
			// Connection �������̽��� prepareStatement() �޼ҵ带 ����Ͽ� ��ü ����	
			pstmt = con.prepareStatement(sql);
			
			// ������ �����Ű�� ��� �޾ƿ�
			// select �����̹Ƿ� executeQuery() �޼��� ���
			// ��ȯ�Ǵ� ����� ResultSet ��ü�� ����	
			rs = pstmt.executeQuery(sql);
			
			dataSet = new ArrayList<StudentDTO>();			
			
			while(rs.next()) {
				dataSet.add(new StudentDTO(rs.getString(1),
						                   rs.getString(2),
						                   rs.getInt(3),
						                   rs.getString(4),
						                   rs.getDate(5).toString(),
						                   rs.getString(6)
							));		// DTO 1���� 1�࿡ �ش�		
				
			}
			
		} catch (Exception e) {
			System.out.println("���� �߻�");
			e.printStackTrace();
		}
		return dataSet;  // ArrayList<StudentDTO> ��ȯ
	}

	@Override
	public void insertStudent(StudentDTO dto) {
		try {
			//sql �� �ۼ�
			String sql = "insert into student values(?,?,?,?,?,?)";
			
			//sql�� values�� �� ������ ����
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getStdNo());
			pstmt.setString(2, dto.getStdName());
			pstmt.setInt(3, dto.getStdYear());
			pstmt.setString(4, dto.getStdAddress());
			pstmt.setString(5, dto.getStdBirthday());
			pstmt.setString(6, dto.getDptNo());	
			
			// ������ ����
			int result = pstmt.executeUpdate();
			
			if(result > 0)
				System.out.println("������ �Է� ����!");
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}	
	}

}
