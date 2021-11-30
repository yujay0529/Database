package db6;

import java.util.Scanner;

import db5.StudentDTO;

public class ProductUpdate {
	public void update() {
Scanner sc = new Scanner(System.in);
ProductDAO prdDAO = new ProductDAO();
		
		// 데이터 입력
		System.out.println("제품정보 수정");
		System.out.println("--------------------------\n");
		
		System.out.print("수정할 제품번호 입력 : ");
		String prdNo = sc.nextLine();
		
		System.out.print("제품명 입력 : ");
		String prdName = sc.nextLine();
		
		System.out.print("가격 입력 : ");
		int prdPrice = sc.nextInt();
		sc.nextLine();	
		
		System.out.print("제조사 입력 : ");
		String prdMaker = sc.nextLine();
		
		System.out.print("색상 입력 : ");
		String prdColor = sc.nextLine();
		
		System.out.print("키테고리 넘버 입력 : ");
		int ctgNo = sc.nextInt();
		
		ProductDTO prdDTO = new ProductDTO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
		
		// StudentDAO 클래스의 insertStudent() 메서드 호출하면서 stdDTO 전달
		prdDAO.updateProduct(prdDTO);

	}

}
