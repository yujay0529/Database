package db4;

import java.util.Scanner;

import db3.StudentDTO;

public class ProductEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// DAO 객체 생성하면서 DB 연결 
		// 객체 생성될 때 생성자 호출되면서 DB 연결
		ProductDAO prdDAO = new ProductDAO();
		
		// (1) 학생 데이터 입력
		System.out.println("제품 정보 등록");
		System.out.println("--------------------------\n");
		
		System.out.print("제품번호 입력 : ");
		String prdNo = sc.nextLine();
		
		System.out.print("제품명 입력 : ");
		String prdName = sc.nextLine();
		
		System.out.print("가격 입력 : ");
		int prdPrice = sc.nextInt();
		
		// 앞의 엔터 값이 다음 변수에 들어가지 않도록 읽어 들임
		sc.nextLine();		
		
		System.out.print("제조사 입력 : ");
		String prdMaker = sc.nextLine();
		
		System.out.print("색상 입력 : ");
		String prdColor = sc.nextLine();
		
		System.out.print("카테고리 넘버 입력 : ");
		int ctgNo = sc.nextInt();
		
		// StudentDTO 객체 생성
		// 생성과 동시에 값저장 : 생성자 호출하면서 값 전달		
	ProductDTO prdDTO = new ProductDTO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
		
		// StudentDAO 클래스의 insertStudent() 메서드 호출하면서 stdDTO 전달
		prdDAO.insertProduct(prdDTO);		
		
		// (2) 학생 정보 조회 : StudentDAO 클래스의 selectStudent() 메서드 호출
		//객체.메서드
		prdDAO.selectProduct();
	}
}
