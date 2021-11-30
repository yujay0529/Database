package db8;

public class ProductDTO {
	
	
	private String prdName;
	private int prdPrice;
	private String prdMaker;
	private String prdColor;
	private int ctgNo;
	
	
	
	private String prdNo;
	public ProductDTO(String prdNo, String prdName, int prdPrice, String prdMaker, String prdColor, int ctgNo) {
		super();
		this.prdNo = prdNo;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdMaker = prdMaker;
		this.prdColor = prdColor;
		this.ctgNo = ctgNo;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public int getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}
	public String getPrdMaker() {
		return prdMaker;
	}
	public void setPrdMaker(String prdMaker) {
		this.prdMaker = prdMaker;
	}
	public String getPrdColor() {
		return prdColor;
	}
	public void setPrdColor(String prdColor) {
		this.prdColor = prdColor;
	}
	public int getCtgNo() {
		return ctgNo;
	}
	public void setCtgNo(int ctgNo) {
		this.ctgNo = ctgNo;
	}
	public String getPrdNo() {
		return prdNo;
	}
	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
	}

@Override
	public String toString() {
		// �Ѳ����� ���ڿ��� �����ؼ� �����ϱ� ���� StringBuulder Ŭ���� ���
		// ���� ���ڿ��� ���ϴ� ���
		StringBuilder builder = new StringBuilder();
		builder.append(prdNo);
		builder.append("\t");
		builder.append(prdName);
		builder.append("\t\t");
		builder.append(prdPrice);
		builder.append("\t");
		builder.append(prdMaker);
		builder.append("\t");
		builder.append(prdColor);
		builder.append("\t\t");
		builder.append(ctgNo);
		
		return builder.toString();
	}		
	
	
}
	