package db9;

import java.util.ArrayList;

public class StudentSelect {
	public void select() {
		
		// DAO ��ü �����ϸ鼭 DB ���� 
		// ��ü ������ �� ������ ȣ��Ǹ鼭 DB ����
		StudentDAO stdDAO = new StudentDAO();
		
		// (2) �л� ���� ��ȸ : StudentDAO Ŭ������ selectStudent() �޼��� ȣ��
		//��ü.�޼���
		ArrayList<StudentDTO> dataSet = new ArrayList<StudentDTO>();
		dataSet = stdDAO.selectStudent(); // ��ȯ�� �޾ƾ� ��
		
		System.out.println("\n���� ��� - ���� ���");
		
		for(StudentDTO dto : dataSet) {
			System.out.println(dto);
		}
	}
}
