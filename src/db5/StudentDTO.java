package db5;

public class StudentDTO {
	private String stdNo;
	private String stdName;
	private int stdYear;
	private String stdAddress;
	private String stdBirthday;
	private String dptNo;
	
	//»ı¼ºÀÚ´Â StudentDTO°¡ »ı¼ºµÉ ¶§ ÀÚµ¿À¸·Î È£Ãâ 
	// È£­ŒµÇ¸é¼­ »ı¼ºÀÚÀÇ ¸Å°³º¯¼ö °ªÀ» ¹ŞÀ½
	//menu - sorce - generate constructor using fields »ı¼ºÀÚ ÀÚµ¿»ı¼º
	public StudentDTO(String stdNo, String stdName, int stdYear, 
			String stdAddress, String stdBirthday, String dptNo) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdYear = stdYear;
		this.stdAddress = stdAddress;
		this.stdBirthday = stdBirthday;
		this.dptNo = dptNo;
	}


	//set***() : ¸â¹öº¯¼ö¿¡ °ªÀ» ÀúÀåÇÒ ¶§ »ç¿ë
	//get***() : ¸â¹öº¯¼öÀÇ °ªÀ» ¹İÈ¯ÇØÁÙ ¶¼ »ç¿ë
	//ÀÚµ¿»ğÀÔ - source-generate getters and setters
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
	
	
}
