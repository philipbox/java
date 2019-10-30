package edu.ssafy.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.MemDTO;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value="testmodelandview") // method 기본 get
	public ModelAndView testModelAndView(HttpServletRequest req,  ModelAndView m) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		m.addObject("message", "Hello SSAFY!" + id +"," + pw);
		m.setViewName("redirect:result.jsp");
		return m;
	}
	
	@RequestMapping(value="testmodel") // method 기본 get
	public String testModel(HttpServletRequest req,  Model m) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		m.addAttribute("message", "Hello SSAFY!" + id + "," + pw);
		return "forward:result";
	}
	
	
	
	@Autowired
	private MemDTO dto;	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println(dto.toString());
		
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
