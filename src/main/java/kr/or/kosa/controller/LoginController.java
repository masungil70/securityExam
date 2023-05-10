package kr.or.kosa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.kosa.config.SecurityConfiguration;
import kr.or.kosa.model.MemberLoginDto;
import kr.or.kosa.service.MemberLoginService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	@Autowired
	MemberLoginService memberLoginService;
	
	
	@GetMapping("/loginForm.do") 
	public String loginForm() {
		return "loginForm";
	}
//	
//	@PostMapping("/login.do") 
//	public String login(MemberLoginDto member) {
//		log.debug("/login.do -> ", member);
//		boolean isValidMember = memberLoginService.isValidMember(member);
//		if (isValidMember) {
//			return "redirect:/";
//		}
//		return "loginForm";
//	}
	
	@GetMapping("/logout.do") 
	public String logout() {
		log.debug("logout.do 호출 ");
		return "loginForm.do";
	}	
}
