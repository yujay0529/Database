package db9;

import java.util.ArrayList;

// 인터페이스 : 표준 규격을 정해 놓은 것
// 이 인터페이스를 구현하는 클래스에서 반드시 정의된 메서드를 반드시 구현해야 함
// @Override 오버라이드 해야 함
public interface IStudentDAO {
	// 추상 메서드 (바디 없음)
	// IStudentDAO 인터페이스를 구현하는 클래스에서 반드시 구현해야 함
	public ArrayList<StudentDTO> selectStudent();
	public void insertStudent(StudentDTO dto);
}
