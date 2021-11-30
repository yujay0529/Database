package db8;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// DAO 객체 생성하면서 DB 연결 
		// 객체 생성될 때 생성자 호출되면서 DB 연결
		ProductDAO prdDAO = new ProductDAO();
		int menuNo;
		
			System.out.println("******************");
			System.out.println(" <제품관리 프로그램> ");
			System.out.println("******************");
			System.out.println("다음 메뉴에서 선택");
			System.out.println(" 1. 제품 등록");
			System.out.println(" 2. 제품 조회");
			System.out.println(" 3. 제품 정보 수정");
			System.out.println(" 4. 제품 정보 삭제");
			System.out.println(" 5. 종료");
			System.out.println("********************************");
			System.out.println(" 메뉴 번호 입력");
			menuNo = sc.nextInt();
	
		
		
		switch(menuNo) {
		
		case 1:
			ProductInsert pi = new ProductInsert();
			pi.insert();
			break;
		case 2:
			ProductSelect ps = new ProductSelect();
			ps.select();
		case 3:
			ProductUpdate pu = new ProductUpdate();
			pu.update();
		case 4:
			ProductDelete pd = new ProductDelete();
			pd.delete();
		case 5:
			break;
		default:System.out.println(" 잘못 입력 하였습니다");
			}
		System.out.println("---------------------");
		System.out.println(" 종료합니다");
		System.out.println("---------------------");
		
	}
	
}