package com.varxyz.jv300.mod006;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.addProduct(new NoteBook("ThinkPad"));
		cart.addProduct(new SmartPhone("Samsung Galaxy"));
		cart.addProduct(new SmartPhone("Apple iphone"));
		
//		System.out.println(cart.getProducts().length);
		System.out.println(cart.getDetails());
	}

}
