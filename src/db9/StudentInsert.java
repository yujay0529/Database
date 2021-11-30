package db9;

import java.util.Scanner;

import db3.StudentDAO;
import db3.StudentDTO;

public class StudentInsert {
	public void insert() {
		Scanner sc = new Scanner(System.in);
		
		// (1) �л� ������ �Է�
		System.out.println("�л� ���� ���");
		System.out.println("--------------------------\n");
		
		System.out.print("�й� �Է� : ");
		String stdNo = sc.nextLine();
		
		System.out.print("���� �Է� : ");
		String stdName = sc.nextLine();
		
		System.out.print("�г� �Է� : ");
		int stdYear = sc.nextInt();
		
		// ���� ���� ���� ���� ������ ���� �ʵ��� �о� ����
		sc.nextLine();		
		
		System.out.print("�ּ� �Է� : ");
		String stdAddress = sc.nextLine();
		
		System.out.print("������� �Է� : ");
		String stdBirthday = sc.nextLine();
		
		System.out.print("�а���ȣ �Է� : ");
		String dptNo = sc.nextLine();
		
		// StudentDTO ��ü ����
		// ������ ���ÿ� ������ : ������ ȣ���ϸ鼭 �� ����		
		StudentDTO stdDTO = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
		
		// DAO ��ü �����ϸ鼭 DB ���� 
		// ��ü ������ �� ������ ȣ��Ǹ鼭 DB ����
		StudentDAO stdDAO = new StudentDAO();
				
		// StudentDAO Ŭ������ insertStudent() �޼��� ȣ���ϸ鼭 stdDTO ����
		stdDAO.insertStudent(stdDTO);	
		
		sc.close();
	}
}
