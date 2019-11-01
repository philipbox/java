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
	
	//상품등록 페이지로 이동
	@RequestMapping("/productRegPage")
	public String productRegisterPage() {
		return "product/proreg";
	}
	
	//상품목록 페이지로 이동
	@RequestMapping("/proList")
	public ModelAndView productList(ModelAndView mv) {
		List<ProductDTO> plist = pser.selectList();
		mv.addObject("productList", plist);
		mv.setViewName("product/prolist");
		return mv;
	}
	
	@RequestMapping("/productRegister")
	public ModelAndView productRegister(HttpServletRequest req, ModelAndView mv) {
		String pnum = req.getParameter("pnum");
		String pname = req.getParameter("pname");
		String price = req.getParameter("price");
		pser.insert(pnum, pname, price);
		
		mv.setViewName("redirect:proList");
		return mv;
	}
	
	@RequestMapping("/productView")
	public ModelAndView productView(HttpServletRequest req, ModelAndView mv) {
		String pnum = req.getParameter("pnum");
		ProductDTO product = pser.selectOne(pnum);
		mv.addObject("product" , product);
		mv.setViewName("product/proview");
		return mv;
	}
	
	@RequestMapping("/productDelete")
	public ModelAndView productDelete(HttpServletRequest req, ModelAndView mv) {
		String pnum = req.getParameter("pnum");
		pser.delete(pnum);
		mv.setViewName("redirect:proList");
		return mv;
	}
	
	@RequestMapping("/productUpdate")
	public ModelAndView productUpdate(HttpServletRequest req, ModelAndView mv) {
		String pnum = req.getParameter("pnum");
		String pname = req.getParameter("pname");
		String price = req.getParameter("price");
		pser.update(pnum, pname, price);
		mv.setViewName("redirect:proList");
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
