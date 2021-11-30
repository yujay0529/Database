package db9;

import java.util.ArrayList;

public class StudentSelect {
	public void select() {
		
		// DAO 객체 생성하면서 DB 연결 
		// 객체 생성될 때 생성자 호출되면서 DB 연결
		StudentDAO stdDAO = new StudentDAO();
		
		// (2) 학생 정보 조회 : StudentDAO 클래스의 selectStudent() 메서드 호출
		//객체.메서드
		ArrayList<StudentDTO> dataSet = new ArrayList<StudentDTO>();
		dataSet = stdDAO.selectStudent(); // 반환값 받아야 함
		
		System.out.println("\n제목 출력 - 각자 출력");
		
		for(StudentDTO dto : dataSet) {
			System.out.println(dto);
		}
	}
}
