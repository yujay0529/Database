
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// DAO 객체 생성하면서 DB 연결 
		// 객체 생성될 때 생성자 호출되면서 DB 연결
		BookDAO bookDAO = new BookDAO();
		
		// (1) 학생 데이터 입력
		System.out.println("도서정보 등록");
		System.out.println("--------------------------\n");
		
		System.out.print("도서번호 입력 : ");
		String bookNo = sc.nextLine();
		
		System.out.print("도서제목 입력 : ");
		String bookTitle = sc.nextLine();
		
		System.out.print("저자 입력 : ");
		String bookAuthor = sc.nextLine();
		
		System.out.print("발행연도 입력 : ");
		int bookYear = sc.nextInt();
		
		System.out.print("가격 입력 : ");
		int bookPrice = sc.nextInt();
		
		System.out.print("출판사 입력 : ");
		String bookPubliser = sc.next();
		
		// StudentDTO 객체 생성
		// 생성과 동시에 값저장 : 생성자 호출하면서 값 전달		
		BookDTO bookDTO = new BookDTO(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPubliser);
		
		// StudentDAO 클래스의 insertStudent() 메서드 호출하면서 stdDTO 전달
		bookDAO.insertBook(bookDTO);

		// (2) 학생 정보 조회 : StudentDAO 클래스의 selectStudent() 메서드 호출
		//객체.메서드
		bookDAO.selectBook();
	}
}
