package kr.or.kosa.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@GetMapping({"/", "home"}) 
	public String home() {
		return "home";
	}
	
	@GetMapping("/main.do") 
	public String main(Authentication authentication) {
		//로그인 사용자 정보 얻기 
		UserDetails user = (UserDetails)authentication.getPrincipal();

		log.debug("user.getUsername()->" + user.getUsername());
		log.debug("user.getPassword()->" + user.getPassword());
		
		return "main";
	}
}
