package webster.back.webster.back.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webster.back.webster.back.domain.Member;
import webster.back.webster.back.dto.EmailRequestDto;
import webster.back.webster.back.dto.MemberLoginDto;
import webster.back.webster.back.dto.MemberRequestDto;
import webster.back.webster.back.service.MailService;
import webster.back.webster.back.service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberApiController {
    @Autowired
    MemberService memberService;

    @Autowired
    MailService mailService;

    @PostMapping("/auth/signup")
    public ResponseEntity joinMember(@Valid @RequestBody MemberRequestDto dto){
        Long memberId = memberService.join(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(memberId+" 회원가입 성공");

    }
    @PostMapping("/auth/login")
    public ResponseEntity loginMember(@RequestBody MemberLoginDto dto, HttpServletRequest request){
        String email = dto.getEmail();
        String password = dto.getPassword();
        Long result = memberService.login(email,password);
        if (result == 1l){
            HttpSession session = request.getSession();
            session.setAttribute("currentMember",email);

        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("로그인 성공");

    }

    @PostMapping("/auth/findpassword")
    public ResponseEntity findPassword(@RequestBody EmailRequestDto dto){
        //String email을 파라미터로 넘기면 JSON 전체 구조가 넘어가 버림
        mailService.findPassword(dto.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto.getEmail()+ " 이메일 전송");
    }

    @PostMapping("/auth/logout")
    public ResponseEntity logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        //세션이 null이 아니면 기존 세션 존재
        if(session != null){
            session.invalidate(); //세션 제거
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("로그아웃");

    }




}
