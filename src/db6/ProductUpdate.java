package db6;

import java.util.Scanner;

import db5.StudentDTO;

public class ProductUpdate {
	public void update() {
Scanner sc = new Scanner(System.in);
ProductDAO prdDAO = new ProductDAO();
		
		// ������ �Է�
		System.out.println("��ǰ���� ����");
		System.out.println("--------------------------\n");
		
		System.out.print("������ ��ǰ��ȣ �Է� : ");
		String prdNo = sc.nextLine();
		
		System.out.print("��ǰ�� �Է� : ");
		String prdName = sc.nextLine();
		
		System.out.print("���� �Է� : ");
		int prdPrice = sc.nextInt();
		sc.nextLine();	
		
		System.out.print("������ �Է� : ");
		String prdMaker = sc.nextLine();
		
		System.out.print("���� �Է� : ");
		String prdColor = sc.nextLine();
		
		System.out.print("Ű�װ� �ѹ� �Է� : ");
		int ctgNo = sc.nextInt();
		
		ProductDTO prdDTO = new ProductDTO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
		
		// StudentDAO Ŭ������ insertStudent() �޼��� ȣ���ϸ鼭 stdDTO ����
		prdDAO.updateProduct(prdDTO);

	}

}
