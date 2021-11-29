
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// DAO ��ü �����ϸ鼭 DB ���� 
		// ��ü ������ �� ������ ȣ��Ǹ鼭 DB ����
		BookDAO bookDAO = new BookDAO();
		
		// (1) �л� ������ �Է�
		System.out.println("�������� ���");
		System.out.println("--------------------------\n");
		
		System.out.print("������ȣ �Է� : ");
		String bookNo = sc.nextLine();
		
		System.out.print("�������� �Է� : ");
		String bookTitle = sc.nextLine();
		
		System.out.print("���� �Է� : ");
		String bookAuthor = sc.nextLine();
		
		System.out.print("���࿬�� �Է� : ");
		int bookYear = sc.nextInt();
		
		System.out.print("���� �Է� : ");
		int bookPrice = sc.nextInt();
		
		System.out.print("���ǻ� �Է� : ");
		String bookPubliser = sc.next();
		
		// StudentDTO ��ü ����
		// ������ ���ÿ� ������ : ������ ȣ���ϸ鼭 �� ����		
		BookDTO bookDTO = new BookDTO(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPubliser);
		
		// StudentDAO Ŭ������ insertStudent() �޼��� ȣ���ϸ鼭 stdDTO ����
		bookDAO.insertBook(bookDTO);

		// (2) �л� ���� ��ȸ : StudentDAO Ŭ������ selectStudent() �޼��� ȣ��
		//��ü.�޼���
		bookDAO.selectBook();
	}
}
