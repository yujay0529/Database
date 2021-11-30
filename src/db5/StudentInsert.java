package db5;

import java.util.Scanner;

public class StudentInsert {
public void insert () {
		Scanner sc = new Scanner(System.in);
		// DAO 객체 생성하면서 DB 연결 
		// 객체 생성될 때 생성자 호출되면서 DB 연결
		StudentDAO stdDAO = new StudentDAO();
		
		// (1) 학생 데이터 입력
		System.out.println("학생 정보 등록");
		System.out.println("--------------------------\n");
		
		System.out.print("학번 입력 : ");
		String stdNo = sc.nextLine();
		
		System.out.print("성명 입력 : ");
		String stdName = sc.nextLine();
		
		System.out.print("학년 입력 : ");
		int stdYear = sc.nextInt();
		
		// 앞의 엔터 값이 다음 변수에 들어가지 않도록 읽어 들임
		sc.nextLine();		
		
		System.out.print("주소 입력 : ");
		String stdAddress = sc.nextLine();
		
		System.out.print("생년월일 입력 : ");
		String stdBirthday = sc.nextLine();
		
		System.out.print("학과번호 입력 : ");
		String dptNo = sc.nextLine();
		
		// StudentDTO 객체 생성
		// 생성과 동시에 값저장 : 생성자 호출하면서 값 전달		
		StudentDTO stdDTO = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
		
		// StudentDAO 클래스의 insertStudent() 메서드 호출하면서 stdDTO 전달
		stdDAO.insertStudent(stdDTO);
	
	}
}

		