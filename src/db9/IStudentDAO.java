package db9;

import java.util.ArrayList;

// �������̽� : ǥ�� �԰��� ���� ���� ��
// �� �������̽��� �����ϴ� Ŭ�������� �ݵ�� ���ǵ� �޼��带 �ݵ�� �����ؾ� ��
// @Override �������̵� �ؾ� ��
public interface IStudentDAO {
	// �߻� �޼��� (�ٵ� ����)
	// IStudentDAO �������̽��� �����ϴ� Ŭ�������� �ݵ�� �����ؾ� ��
	public ArrayList<StudentDTO> selectStudent();
	public void insertStudent(StudentDTO dto);
}
