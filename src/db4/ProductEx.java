package db4;

import java.util.Scanner;

import db3.StudentDTO;

public class ProductEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// DAO ��ü �����ϸ鼭 DB ���� 
		// ��ü ������ �� ������ ȣ��Ǹ鼭 DB ����
		ProductDAO prdDAO = new ProductDAO();
		
		// (1) �л� ������ �Է�
		System.out.println("��ǰ ���� ���");
		System.out.println("--------------------------\n");
		
		System.out.print("��ǰ��ȣ �Է� : ");
		String prdNo = sc.nextLine();
		
		System.out.print("��ǰ�� �Է� : ");
		String prdName = sc.nextLine();
		
		System.out.print("���� �Է� : ");
		int prdPrice = sc.nextInt();
		
		// ���� ���� ���� ���� ������ ���� �ʵ��� �о� ����
		sc.nextLine();		
		
		System.out.print("������ �Է� : ");
		String prdMaker = sc.nextLine();
		
		System.out.print("���� �Է� : ");
		String prdColor = sc.nextLine();
		
		System.out.print("ī�װ� �ѹ� �Է� : ");
		int ctgNo = sc.nextInt();
		
		// StudentDTO ��ü ����
		// ������ ���ÿ� ������ : ������ ȣ���ϸ鼭 �� ����		
	ProductDTO prdDTO = new ProductDTO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
		
		// StudentDAO Ŭ������ insertStudent() �޼��� ȣ���ϸ鼭 stdDTO ����
		prdDAO.insertProduct(prdDTO);		
		
		// (2) �л� ���� ��ȸ : StudentDAO Ŭ������ selectStudent() �޼��� ȣ��
		//��ü.�޼���
		prdDAO.selectProduct();
	}
}
