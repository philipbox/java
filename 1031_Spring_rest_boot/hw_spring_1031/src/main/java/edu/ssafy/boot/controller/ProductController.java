package edu.ssafy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.ProductDTO;
import edu.ssafy.boot.service.ProductService;

@Controller(value="/")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	@Qualifier("ProductServiceImpl")
	ProductService pser;
	
	// 상품목록을 리스트에 담아서 index로.
	@RequestMapping("/productlist")
	public ModelAndView productList(ModelAndView mv) {
		List<ProductDTO> plist = pser.selectList();
		mv.addObject("productList", plist);
		mv.setViewName("index");
		return mv;
	}
	
	// 입력된 상품정보를 등록 후 화면은 index로.
	@RequestMapping("/productregister")
	public ModelAndView productRegister(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String info = req.getParameter("info");

		System.out.println("등록진입------------------------");
		System.out.println(id +" / " + name+" / "+price+" / "+info);
		pser.insert(id, name, price, info);
		
		mv.setViewName("index");
		return mv;
	}
	
	//클릭된 상품 id의 정보를 index로.
	@RequestMapping("/productview")
	public ModelAndView productView(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");
		ProductDTO product = pser.selectOne(id);
		mv.addObject("productOne" , product);
		mv.setViewName("index");
		return mv;
	}
	
	//입력된 상품 id의 정보를 삭제 후 화면은 index로.
	@RequestMapping("/productdelete")
	public ModelAndView productDelete(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");
		pser.delete(id);
		mv.setViewName("index");
		return mv;
	}
	
	// 입력된 상품정보를 수정 후 화면은 index로.
	@RequestMapping("/productupdate")
	public ModelAndView productUpdate(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String info = req.getParameter("info");
		pser.update(id, name, price, info);
		mv.setViewName("index");
		return mv;
	}
}
