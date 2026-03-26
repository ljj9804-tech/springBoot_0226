package com.busanit501.springboot_0226.repository;


import com.busanit501.springboot_0226.domain.MemberRole;
import com.busanit501.springboot_0226.domain.SpringMember;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMembers() {
        IntStream.rangeClosed(1,50).forEach(i ->{
            SpringMember springMember = SpringMember.builder()
                    .mid("member"+i)
                    .mpw(passwordEncoder.encode("1111"))
                    .email("email"+i+"@test.com")
                    .build();

            // 권한 추가.
            springMember.addRole(MemberRole.USER);
            if (i >=95) {
                springMember.addRole(MemberRole.ADMIN);
            }
            memberRepository.save(springMember);
        });
    }

    @Test
    public void testRead() {
        Optional<SpringMember> result = memberRepository.getWithRoles("member1");
        SpringMember member = result.orElseThrow();
        log.info(member);
        log.info(member.getRoleSet());

        member.getRoleSet().forEach(role -> log.info(role.name()));
    }

    @Commit
    @Test
    public void testUpdate() {
        String mid = "ljj9804@naver.com";
        String mpw = passwordEncoder.encode("123456");
        memberRepository.updatePassword(mpw, mid);
    }


}