package db6;

import db4.ProductDAO;

public class ProductSelect {
	public void select() {
		ProductDAO prdDAO = new ProductDAO();
		prdDAO.selectProduct();
		
	}

}
