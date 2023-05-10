package kr.or.kosa.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import kr.or.kosa.model.MemberLoginDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberLoginService {
	
	private static PasswordEncoder myPasswdEncoder = new BCryptPasswordEncoder();
	
	public boolean isValidMember(MemberLoginDto member) {
		
		log.debug("uid->" + member.getUid());
		log.debug("pwd->" + member.getPwd());
	
		return false;
	}

	public Optional<MemberLoginDto> findOne(String uid) {
		if ("admin".equals(uid)) {
			return Optional.of(MemberLoginDto.builder().uid(uid).pwd(myPasswdEncoder.encode("1234")).build());
		}
		return Optional.empty();
	}

}
