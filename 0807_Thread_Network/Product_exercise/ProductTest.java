package com.ssafy.java;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {

	private ProductMgrImpl pm;
	private Scanner sc;
	private boolean flag = true;
	private int menu;
	
	public ProductTest() {
		pm = ProductMgrImpl.getInstance();
		
		try {
			pm.ReadData();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc = new Scanner(System.in);
		// open
	}
	
	/*
			1111 하우젠 900000 30 400
			2222 김치냉장고 1300000 18 600
			3333 냉동고 500000 20 500

			777 최신형티비 3000000 30 90
			555 꼬진티비 150000 10 24
	*/


	
	public void go() {
		while(flag) {
			System.out.println("==========메뉴선택==========");
			System.out.println("1. 상품추가");
			System.out.println("2. 전체상품 검색");
			System.out.println("3. 상품검색(번호)");
			System.out.println("4. 상품검색(상품명)");
			System.out.println("5. TV 전체 검색");
			System.out.println("6. 냉장고 전체 검색");
			System.out.println("7. 400L이상 냉장고 검색");
			System.out.println("8. 50inch이상 TV 검색");
			System.out.println("9. 상품가격 수정");
			System.out.println("10. 상품삭제");
			System.out.println("11. 전체 재고 상품 금액");
			System.out.println("12. 상품검색(상품명&가격)");
			System.out.println("13. 서버로 전송");
			System.out.println("0. 종료");
			
			menu=sc.nextInt();
			
			switch(menu) {
			case 1:
				System.out.println("1.TV추가    2.냉장고추가");
				int add_menu = sc.nextInt();
				switch(add_menu) {
				case 1:
					System.out.println("'상품번호 상품명 가격 재고 인치' 를 입력해주세요.");
					int add_serial = sc.nextInt();
					String add_name = sc.next();
					int add_price = sc.nextInt();
					int add_stock = sc.nextInt();
					int add_inch = sc.nextInt();
					try{
						pm.add(new TV(add_serial, add_name, add_price, add_stock, add_inch));
					
					} catch(DuplicateException e) {
						e.print();
					}
					break;
					
				case 2:
					System.out.println("'상품번호 상품명 가격 재고 리터' 를 입력해주세요.");
					int add_serial2 = sc.nextInt();
					String add_name2 = sc.next();
					int add_price2 = sc.nextInt();
					int add_stock2 = sc.nextInt();
					int add_liter = sc.nextInt();
					try{
						pm.add(new Refrigerator(add_serial2, add_name2, add_price2, add_stock2, add_liter));
					} catch(DuplicateException e) {
						e.print();
					}
					break;
				}
				break;
			case 2:
				for(Product tmp : pm.searchAll()) {
					System.out.println(tmp);
				}
				break;
			case 3:
				System.out.println("상품번호를 입력해주세요.");
				int find_serial = sc.nextInt();
				try {
				System.out.println(pm.findBySerial(find_serial));
				} catch(CodeNotFoundException e) {
					e.print();
				}
				break;
			case 4:
				System.out.println("상품이름을 입력해주세요.");
				String find_name = sc.next();
				for(Product tmp : pm.findByName(find_name)) {
					System.out.println(tmp);
				}
				break;
			case 5:
				for(Product tmp : pm.TVAll()) {
					System.out.println(tmp);
				}
				break;
			case 6:
				for(Product tmp : pm.RefriAll()) {
					System.out.println(tmp);
				}
				break;
			case 7:
				try {
					for(Product tmp : pm.Refri400liter()) {
						System.out.println(tmp);
					}
				} catch(ProductNotFoundException e) {
					e.print();
				}
				break;
			case 8:
				try {
					for(Product tmp : pm.TV50inch()) {
						System.out.println(tmp);
					}
				} catch (ProductNotFoundException e) {
					e.print();
				}
				break;
			case 9:
				System.out.println("상품번호와 수정할 가격을 입력해주세요.");
				int modi_serial = sc.nextInt();
				int modi_price = sc.nextInt();
				pm.modifyPrice(modi_serial, modi_price);
				break;
			case 10:
				System.out.println("삭제할 상품번호를 입력해주세요.");
				int delete_serial = sc.nextInt();
				pm.deleteProduct(delete_serial);
				break;
			case 11:
				System.out.println("전체 재고상품 금액 : " + pm.TotalPrice());
				break;
			case 12:
				System.out.println("검색할 상품이름과 가격을 입력해주세요.");
				String find_name2 = sc.next();
				int find_price2 = sc.nextInt();
				for(Product tmp : pm.findByName(find_name2, find_price2)) {
					System.out.println(tmp);
				}
				break;
			case 13:
				pm.send();
				break;
			case 0:
				try {
					pm.StoreData();
					System.out.println(" 프로그램을 종료합니다.");
					flag=false;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}//end switch
		}//end while
	}//end go method
	
	
	
	public static void main(String[] args) {
		new ProductTest().go();
	}
	
}
