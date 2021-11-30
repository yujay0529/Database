package db9;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menuNum;
		
		System.out.println("********************");
		System.out.println("학생 관리 프로그램");
		System.out.println("********************");
		
		System.out.println("다음 메뉴에서 선택");
		System.out.println("********************");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 정보 조회");
		System.out.println("3. 학생 정보 수정");
		System.out.println("4. 학생 정보 삭제");
		System.out.println("5. 종료");
		System.out.println("--------------------");
		
		System.out.print("메뉴 번호 입력 : ");
		menuNum = sc.nextInt();
		
		switch(menuNum) {
			case 1:
				StudentInsert si = new StudentInsert();
				si.insert();
				break;
			case 2: 
				StudentSelect ss = new StudentSelect();
				ss.select();
			case 3:
				StudentUpdate su = new StudentUpdate();
				su.update();
				break;
			case 4:
				StudentDelete sd = new StudentDelete();
				sd.delete();
				break;
			case 5:
				break;
			default:
				System.out.println("\n잘못 입력하였습니다.");
		}
		
		System.out.println("--------------------");
		System.out.println("종료합니다.");
		System.out.println("--------------------");
		sc.close();
	}

}
