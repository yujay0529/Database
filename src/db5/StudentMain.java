package db5;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// DAO ��ü �����ϸ鼭 DB ���� 
		// ��ü ������ �� ������ ȣ��Ǹ鼭 DB ����
		StudentDAO stdDAO = new StudentDAO();
		int menuNo;
		
			System.out.println("******************");
			System.out.println(" <�л����� ���α׷�> ");
			System.out.println("******************");
			System.out.println("���� �޴����� ����");
			System.out.println(" 1. �л� ���");
			System.out.println(" 2. �л� ���� ��ȸ");
			System.out.println(" 3. �л� ���� ����");
			System.out.println(" 4. �л� ���� ����");
			System.out.println(" 5. ����");
			System.out.println("********************************");
			System.out.println(" �޴� ��ȣ �Է�");
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
		default:System.out.println(" �߸� �Է� �Ͽ����ϴ�");
			}
		System.out.println("---------------------");
		System.out.println(" �����մϴ�");
		System.out.println("---------------------");
		
	}
	
}
