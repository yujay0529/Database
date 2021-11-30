package db8;


import java.util.*;

import db7.StudentDTO;

public class ProductSelect {
public void select() {
		
		// DAO 객체 생성하면서 DB 연결 
		// 객체 생성될 때 생성자 호출되면서 DB 연결
		ProductDAO prdDAO = new ProductDAO();
		
		// (2) 학생 정보 조회 : StudentDAO 클래스의 selectStudent() 메서드 호출
		//객체.메서드
		ArrayList<ProductDTO> dataSet = new ArrayList<ProductDTO>();
		dataSet = prdDAO.selectProduct(); // 반환값 받아야 함
		
		
		System.out.println("\n제목 출력 - 각자 출력");
		
		for(ProductDTO dto : dataSet) {
			System.out.println(dto);
		}
	}

		
	}

