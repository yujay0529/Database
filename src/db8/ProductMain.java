package db8;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// DAO ��ü �����ϸ鼭 DB ���� 
		// ��ü ������ �� ������ ȣ��Ǹ鼭 DB ����
		ProductDAO prdDAO = new ProductDAO();
		int menuNo;
		
			System.out.println("******************");
			System.out.println(" <��ǰ���� ���α׷�> ");
			System.out.println("******************");
			System.out.println("���� �޴����� ����");
			System.out.println(" 1. ��ǰ ���");
			System.out.println(" 2. ��ǰ ��ȸ");
			System.out.println(" 3. ��ǰ ���� ����");
			System.out.println(" 4. ��ǰ ���� ����");
			System.out.println(" 5. ����");
			System.out.println("********************************");
			System.out.println(" �޴� ��ȣ �Է�");
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
		default:System.out.println(" �߸� �Է� �Ͽ����ϴ�");
			}
		System.out.println("---------------------");
		System.out.println(" �����մϴ�");
		System.out.println("---------------------");
		
	}
	
}