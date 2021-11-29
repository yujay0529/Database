
public class BookDTO {
	
		private String bookNo;
		private String bookTilte;
		private String bookAuthor;
		private int bookYear;
		private int bookPrice;
		private String bookPublisher;
		
		
		
		public BookDTO(String bookNo, String bookTilte, String bookAuthor, int bookYear, int bookPrice,
				String bookPublisher) {
			super();
			this.bookNo = bookNo;
			this.bookTilte = bookTilte;
			this.bookAuthor = bookAuthor;
			this.bookYear = bookYear;
			this.bookPrice = bookPrice;
			this.bookPublisher = bookPublisher;
		}



		public String getBookNo() {
			return bookNo;
		}



		public void setBookNo(String bookNo) {
			this.bookNo = bookNo;
		}



		public String getBookTilte() {
			return bookTilte;
		}



		public void setBookTilte(String bookTilte) {
			this.bookTilte = bookTilte;
		}



		public String getBookAuthor() {
			return bookAuthor;
		}



		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}



		public int getBookYear() {
			return bookYear;
		}



		public void setBookYear(int bookYear) {
			this.bookYear = bookYear;
		}



		public int getBookPrice() {
			return bookPrice;
		}



		public void setBookPrice(int bookPrice) {
			this.bookPrice = bookPrice;
		}



		public String getBookPublisher() {
			return bookPublisher;
		}



		public void setBookPublisher(String bookPublisher) {
			this.bookPublisher = bookPublisher;
		}
		
		
		
		
		

}
