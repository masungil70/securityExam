package kr.or.kosa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/* @formatter:off */
		http
			.authorizeHttpRequests(matchers -> matchers
					//controller에서 jsp view로 forward 하는 경우는 인증 필요없음   
			.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
			.requestMatchers("/", "/home").permitAll() // 설정한 리소스의 접근을 인증절차 없이 허용
			.anyRequest().authenticated()); // 그 외 모든 리소스를 의미하며 인증 필요 
		
		return http.build();
		/* @formatter:on */
	}

}
