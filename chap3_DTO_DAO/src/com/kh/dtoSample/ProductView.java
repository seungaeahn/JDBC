package com.kh.dtoSample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	//Ãâ·Â ¸Þ¼Òµå void
	
	public void displayProducts(List<ProductDTO> products) {
		//Çâ»óµÈ for¹®
		for(ProductDTO  p : products) {
			System.out.println("Products ID : " + p.getProduct_id());
			System.out.println("Products Name : " + p.getProductName());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Stock_quantity : " + p.getStock_quantity());
		}
		
	}
	
}