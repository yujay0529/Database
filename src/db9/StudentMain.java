package db9;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menuNum;
		
		System.out.println("********************");
		System.out.println("�л� ���� ���α׷�");
		System.out.println("********************");
		
		System.out.println("���� �޴����� ����");
		System.out.println("********************");
		System.out.println("1. �л� ���");
		System.out.println("2. �л� ���� ��ȸ");
		System.out.println("3. �л� ���� ����");
		System.out.println("4. �л� ���� ����");
		System.out.println("5. ����");
		System.out.println("--------------------");
		
		System.out.print("�޴� ��ȣ �Է� : ");
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
				System.out.println("\n�߸� �Է��Ͽ����ϴ�.");
		}
		
		System.out.println("--------------------");
		System.out.println("�����մϴ�.");
		System.out.println("--------------------");
		sc.close();
	}

}
