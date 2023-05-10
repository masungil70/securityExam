package kr.or.kosa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kr.or.kosa.model.MemberLoginDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
	
    private final MemberLoginService memberService;
    

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        log.debug("MyUserDetailsService.loadUserByUsername()..." + uid);
        Optional<MemberLoginDto> findOne = memberService.findOne(uid);
        MemberLoginDto member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));
      
        return User.builder()
                .username(member.getUid())
                .password(member.getPwd())
                .roles("USER")
                .build();
    }
}