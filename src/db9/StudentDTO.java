package db9;

public class StudentDTO {
	// 데이터베이싀 테이블 열과 데이터 타입 일치해야 함
	// 변수명은 열이름과 달라도 오류는 없지만 일반적으로 이해하기 쉽게 
	// 열이름과 동일한 변수명으로 한다.
	private String stdNo;
	private String stdName;
	private int stdYear;
	private String stdAddress;
	private String stdBirthday;
	private String dptNo;
	
	// 매개변수가 있는 생성자
	// 자동으로 삽입 : Source /Generate Constructor using Fields
	// 모든 멤버변수 초기화		
	// 생성자는 StudentDTO 클래스 객체가 생성될 때 자동으로 호출되면서
	// 생성자의 매개변수 값을 받음		
	public StudentDTO(String stdNo, String stdName, int stdYear, 
			String stdAddress, String stdBirthday, String dptNo) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdYear = stdYear;
		this.stdAddress = stdAddress;
		this.stdBirthday = stdBirthday;
		this.dptNo = dptNo;
	}
	
	// Getters / Setters
	// setXXX() : 멤버변수에 값을 저장할 때 사용
	// getXXX() : 멤버변수의 값을 반환해줄 때 사용
	// 자동으로 삽입 : Source / Generate Getters and Setters
	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getStdYear() {
		return stdYear;
	}

	public void setStdYear(int stdYear) {
		this.stdYear = stdYear;
	}

	public String getStdAddress() {
		return stdAddress;
	}

	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}

	public String getStdBirthday() {
		return stdBirthday;
	}

	public void setStdBirthday(String stdBirthday) {
		this.stdBirthday = stdBirthday;
	}

	public String getDptNo() {
		return dptNo;
	}

	public void setDptNo(String dptNo) {
		this.dptNo = dptNo;
	}

	@Override
	public String toString() {
		// 한꺼번에 문자열을 저장해서 전달하기 위해 StringBuulder 클래스 사용
		// 기존 문자열에 더하는 방식
		StringBuilder builder = new StringBuilder();
		builder.append(stdNo);
		builder.append("\t");
		builder.append(stdName);
		builder.append("\t\t");
		builder.append(stdYear);
		builder.append("\t");
		builder.append(stdAddress);
		builder.append("\t");
		builder.append(stdBirthday);
		builder.append("\t\t");
		builder.append(dptNo);
		
		return builder.toString();
	}		
}





