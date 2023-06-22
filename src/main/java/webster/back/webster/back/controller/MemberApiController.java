package webster.back.webster.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webster.back.webster.back.domain.Member;
import webster.back.webster.back.dto.MemberRequestDto;
import webster.back.webster.back.service.MemberService;

@RestController
@RequestMapping("/api/auth")
public class MemberApiController {
    @Autowired
    MemberService memberService;

    @PostMapping("/auth/signup")
    public ResponseEntity joinMember(@RequestBody MemberRequestDto dto){
        Long memberId = memberService.join(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(memberId);

    }

    @PostMapping("/auth/login")
    public ResponseEntity loginMember(@RequestBody String email, @RequestBody String password){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberService.login(email,password));

    }


}
