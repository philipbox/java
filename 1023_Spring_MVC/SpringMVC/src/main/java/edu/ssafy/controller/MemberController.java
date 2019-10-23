package edu.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.service.MemberService;

@Controller
@RequestMapping(value="/")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	@Qualifier("MemberServiceImpl")
	MemberService ser;

	@RequestMapping("/memregpage")
	public String memregpage(){
		return "member/memreg";
	}
	
	@RequestMapping("/memreg")
	public ModelAndView memReg(HttpServletRequest req, ModelAndView mv) {
		String num = req.getParameter("num");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		ser.insert(num, pw, name, tel);
		
		mv.setViewName("redirect:memlist");
		return mv;
	}
	
	@RequestMapping("/memlist")
	public ModelAndView memList(ModelAndView mv) {
		List<MemDTO> list = ser.selectList();
		mv.addObject("mems", list);
		mv.setViewName("member/memlist");
		return mv;
	}
	
	
	@RequestMapping("/memview")
	public ModelAndView memView(@RequestParam("num")String num, ModelAndView mv) {
		MemDTO mem = ser.selectOne(num);
		mv.addObject("mem", mem);
		mv.setViewName("member/memview");
		return mv;
	}
	
	
	@RequestMapping("/memdelete")
	public ModelAndView memDelete(@RequestParam("num")String num, ModelAndView mv) {
		ser.delete(num);
		mv.setViewName("redirect:memlist");
		return mv;
	}
	
	
	@RequestMapping("/memupdate")
	public ModelAndView memUpdate(MemDTO mem, ModelAndView mv) {
		ser.update(mem.getNum(), mem.getPw(), mem.getName(), mem.getTel());
		mv.setViewName("redirect:memlist");
		return mv;
	}
}
