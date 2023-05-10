package kr.or.kosa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/* @formatter:off */
		http.csrf().disable()
			.authorizeHttpRequests(matchers -> matchers
				 //controller에서 jsp view로 forward 하는 경우는 인증 필요없음   
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/", "/home").permitAll() // 설정한 리소스의 접근을 인증절차 없이 허용
				.anyRequest().authenticated()) // 그 외 모든 리소스를 의미하며 인증 필요 
			.formLogin(login -> login	// form 방식 로그인 사용
				.loginPage("/loginForm.do")	     // [step1] 커스텀 로그인 페이지 URL 설정
                .loginProcessingUrl("/login.do") // [step2] submit 받을 url
                .usernameParameter("uid")	     // [step3] submit할 아이디
                .passwordParameter("pwd")	     // [step3] submit할 비밀번호
                .defaultSuccessUrl("/main.do", true) // 성공 시 이동할 URL 설정 
                .permitAll())
            .logout(logout -> logout 
            	.logoutUrl("/logout.do") // 로그아웃 URL 설정 
    		    .logoutSuccessUrl("/loginForm.do") // 로그아웃 성공시 리턴 URL
    		    .invalidateHttpSession(true) // 인증정보를 지우하고 세션을 무효화
    		    .deleteCookies("JSESSIONID") // JSESSIONID 쿠키 삭제
    			.permitAll());    
		
		return http.build();
		/* @formatter:on */
	}

}
