package edu.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.service.MemberService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins= {"*"}, maxAge=6000)
@RestController
@RequestMapping("/api") // api/memreg 이렇게 부르면 rest를 부르는게 된다.
public class RestMemberController {
	private static final Logger logger = LoggerFactory.getLogger(RestMemberController.class);

	@Autowired
	@Qualifier("MemberServiceImpl")
	MemberService ser;

	//@RequestMapping(value ="/memreg" , method=RequestMethod.POST)
	@PostMapping("/memreg")
	@ApiOperation(value="member 등록 서비스")
	public ResponseEntity<Map<String, Object>> memReg(@RequestBody MemDTO dto) throws MyException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int insert = ser.insert(dto.getNum(), dto.getPw(), dto.getName(), dto.getTel());
//			String msg = insert + " 입력했습니다";
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "등록성공");
			msg.put("resvalue", insert);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
//			String msg = "입력 실패했습니다";
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "입력실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	// json 은 중괄호와 대괄호
	// 중괄호는 객체.
	//@RequestMapping(value="/memlist" , method=RequestMethod.GET)
	@GetMapping("/memlist")
	@ApiOperation(value="member 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String ,Object>> memList() {
		ResponseEntity<Map<String ,Object>> resEntity = null;
		List<MemDTO> list = null;
		try {
			list = ser.selectList();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "멤버전체 조회성공");
			map.put("resvalue", list);
			resEntity = new ResponseEntity<Map<String ,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "멤버전체 조회실패");
			resEntity = new ResponseEntity<Map<String ,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	//@RequestMapping("/memview/{num}")
	@GetMapping("/memview/{num}")
	@ApiOperation(value="num을 받아 member 조회 서비스", response=MemDTO.class)
	public @ResponseBody ResponseEntity<Map<String ,Object>> memView(@PathVariable("num") String num) {
		ResponseEntity<Map<String ,Object>> resEntity = null;
		MemDTO mem = null;
		try {
			mem = ser.selectOne(num);
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "멤버조회성공");
			map.put("resvalue", mem);
			resEntity = new ResponseEntity<Map<String ,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "멤버조회실패");
			resEntity = new ResponseEntity<Map<String ,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	//@RequestMapping("/memdelete/{num}")
	@DeleteMapping("/memdelete/{num}")
	@ApiOperation(value="num을 받아 member 삭제 서비스")
	public @ResponseBody ResponseEntity<Map<String ,Object>> memDelete(@PathVariable("num") String num) {
		ResponseEntity<Map<String ,Object>> resEntity = null;
		try {
			int delete = ser.delete(num);
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "삭제성공");
			map.put("resvalue", delete);
			resEntity = new ResponseEntity<Map<String ,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "삭제실패");
			resEntity = new ResponseEntity<Map<String ,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	//@RequestMapping("/memupdate")
	@PutMapping("/memupdate")
	@ApiOperation(value="num을 받아 member 수정 서비스")
	public @ResponseBody ResponseEntity<Map<String ,Object>> memUpdate(@RequestBody MemDTO mem) {
		ResponseEntity<Map<String ,Object>> resEntity = null;
		try {
			int update = ser.update(mem.getNum(), mem.getPw(), mem.getName(), mem.getTel());
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "수정성공");
			map.put("resvalue", update);
			resEntity = new ResponseEntity<Map<String ,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "수정실패");
			resEntity = new ResponseEntity<Map<String ,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

//	//@RequestMapping("/memlogin")
//	public ModelAndView memLogin(HttpServletRequest req, ModelAndView mv) {
//		HttpSession session = req.getSession();
//
//		String tID = req.getParameter("loginID");
//		String tPW = req.getParameter("loginPW");
//		System.out.println("로그인 시도 ID: " + tID);
//		System.out.println("로그인 시도 PW: " + tPW);
//
//		boolean res = ser.login(tID, tPW);
//		if (res) {
//			session.setAttribute("loginID", tID);
//			System.out.println("로그인성공 : " + tID);
//			mv.setViewName("redirect:memlist");
//		} else {
//			System.out.println("로그인실패");
//			mv.setViewName("redirect:index.jsp");
//		}
//		return mv;
//	}
//
//	@RequestMapping("/memlogout")
//	public ModelAndView logout(HttpServletRequest req, ModelAndView mv) {
//		HttpSession session = req.getSession();
//		session.invalidate();
//		mv.setViewName("redirect:index.jsp");
//		return mv;
//	}

}
