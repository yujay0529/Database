package db7;

public class StudentDTO {
	private String stdNo;
	private String stdName;
	private int stdYear;
	private String stdAddress;
	private String stdBirthday;
	private String dptNo;
	
	//�����ڴ� StudentDTO�� ������ �� �ڵ����� ȣ�� 
	// ȣ���Ǹ鼭 �������� �Ű����� ���� ����
	//menu - sorce - generate constructor using fields ������ �ڵ�����
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


	//set***() : ��������� ���� ������ �� ���
	//get***() : ��������� ���� ��ȯ���� �� ���
	//�ڵ����� - source-generate getters and setters
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
		// �Ѳ����� ���ڿ��� �����ؼ� �����ϱ� ���� StringBuulder Ŭ���� ���
		// ���� ���ڿ��� ���ϴ� ���
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
