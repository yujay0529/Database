package db5;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// DAO 객체 생성하면서 DB 연결 
		// 객체 생성될 때 생성자 호출되면서 DB 연결
		StudentDAO stdDAO = new StudentDAO();
		int menuNo;
		
			System.out.println("******************");
			System.out.println(" <학생관리 프로그램> ");
			System.out.println("******************");
			System.out.println("다음 메뉴에서 선택");
			System.out.println(" 1. 학생 등록");
			System.out.println(" 2. 학생 정보 조회");
			System.out.println(" 3. 학생 정보 수정");
			System.out.println(" 4. 학생 정보 삭제");
			System.out.println(" 5. 종료");
			System.out.println("********************************");
			System.out.println(" 메뉴 번호 입력");
			menuNo = sc.nextInt();
	
		
		
		switch(menuNo) {
		
		case 1:
			StudentInsert si = new StudentInsert();
			si.insert();
			break;
		case 2:
			StudentSelect ss = new StudentSelect();
			ss.select();
		case 3:
			StudentUpdate su = new StudentUpdate();
			break;
		case 4:
			StudentDelete sd = new StudentDelete();	
			break;
		case 5:
			break;
		default:System.out.println(" 잘못 입력 하였습니다");
			}
		System.out.println("---------------------");
		System.out.println(" 종료합니다");
		System.out.println("---------------------");
		
	}
	
}
