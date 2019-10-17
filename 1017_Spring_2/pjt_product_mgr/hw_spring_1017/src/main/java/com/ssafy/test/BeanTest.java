package com.ssafy.test;

import java.util.List;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;


public class BeanTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BeanFactory fac = new AnnotationConfigApplicationContext(ProductConfig.class);
		ProductService pmgr = (ProductService) fac.getBean("pservice");
		
		List<Product> plist = null;
		Product product = null;
		
		String id;
		String name;
		String price;
		String company;
		String description;
		out:while (true) {
			System.out.println("================================================");
			System.out.println("1.제품추가   2.제품삭제   3.제품수정   4.제품검색   5.제품목록   0.종료");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("제품의 '제품번호  제품명  가격  제조사  상세설명'을 모두 입력해주세요.");
				id = sc.next();
				name = sc.next();
				price = sc.next();
				company = sc.next();
				description = sc.next();
				
				if(pmgr.insert(new Product(id, name, price, company, description))<0) {
					System.out.println("제품추가 실패(중복된 제품번호)");
				}else System.out.println("제품추가 성공");
				break;
			case 2:
				System.out.println("삭제할 제품의 제품번호를 입력해주세요.");
				id = sc.next();
				if(pmgr.delete(id)<=0) {
					System.out.println("제품삭제 실패");
				}else System.out.println("제품삭제 성공");
				break;
			case 3:
				System.out.println("수정할 제품의 '제품번호  제품명  가격  제조사  상세설명'을 모두 입력해주세요.");
				id = sc.next();
				name = sc.next();
				price = sc.next();
				company = sc.next();
				description = sc.next();
				
				if(pmgr.update(new Product(id, name, price, company, description))<=0) {
					System.out.println("제품수정 실패");
				}else System.out.println("제품수정 성공");
				break;
			case 4:
				System.out.println("검색할 제품의 제품번호를 입력해주세요.");
				id = sc.next();
				product = pmgr.select(id);
				if(product==null) {
					System.out.println("제품검색 실패");
				}else System.out.println("제품번호:"+product.getId()+"  제품명:"+product.getName()+"  제품가격:"
					+product.getPrice()+"  제조사:"+product.getCompany()+"  상세설명:"+product.getDescription());
				break;
			case 5:
				plist = pmgr.selectAll();
				if(plist.size() <=0) System.out.println("등록된 제품이 없습니다.");
				else {
					System.out.println("***제품목록***");
					for (Product p : plist) {
						System.out.println("제품번호:"+p.getId()+"  제품명:"+p.getName()+"  제품가격:"
								+p.getPrice()+"  제조사:"+p.getCompany()+"  상세설명:"+p.getDescription());
					}
				}
				break;
			default:
				System.out.println("종료합니다.");
				break out;
			}// end switch
		}
	}
}
