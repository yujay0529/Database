package db8;


import java.util.*;

import db7.StudentDTO;

public class ProductSelect {
public void select() {
		
		// DAO ��ü �����ϸ鼭 DB ���� 
		// ��ü ������ �� ������ ȣ��Ǹ鼭 DB ����
		ProductDAO prdDAO = new ProductDAO();
		
		// (2) �л� ���� ��ȸ : StudentDAO Ŭ������ selectStudent() �޼��� ȣ��
		//��ü.�޼���
		ArrayList<ProductDTO> dataSet = new ArrayList<ProductDTO>();
		dataSet = prdDAO.selectProduct(); // ��ȯ�� �޾ƾ� ��
		
		
		System.out.println("\n���� ��� - ���� ���");
		
		for(ProductDTO dto : dataSet) {
			System.out.println(dto);
		}
	}

		
	}

