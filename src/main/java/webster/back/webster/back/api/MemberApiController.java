package webster.back.webster.back.api;

import jakarta.servlet.http.HttpSession;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import webster.back.webster.back.domain.GenderStatus;
import webster.back.webster.back.domain.Member;
import webster.back.webster.back.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberservice;

    @PostMapping("/join")
    public CreateMemberResponse join(@RequestBody CreateMemberRequest request){
        Member member = new Member();
        member.setName(request.name);
        member.setEmail(request.email);
        member.setGender(request.gender);
        member.setPassword(request.password);
        Long id = memberservice.join(member);
        return new CreateMemberResponse();
    }

    @PostMapping("/login")
    public SignUpMemberResponse login (@RequestBody SignUpMemberRequest request, @RequestParam HttpSession session){
        List<Member> loginresult = memberservice.login(request.email, request.password);
        if (loginresult.isEmpty()){
            System.out.println("failed");
        }
        else{
            session.setMaxInactiveInterval(60*60*8);
            session.setAttribute("email",request.email);
            session.setAttribute("loginok","yes");

        }

        return new SignUpMemberResponse(request);
    }

    @Data
    static class CreateMemberRequest{
        private String name;
        private String email;
        private GenderStatus gender;

        private String password;
    }
    @Data
    static class CreateMemberResponse{
        private Long id;

    }

    @Data
    static class SignUpMemberRequest{
        private String email;
        private String password;
    }

    @Data
    static class SignUpMemberResponse{
        private String email;
        private String password;

        public SignUpMemberResponse(SignUpMemberRequest request){
            this.email = request.email;
            this.password = request.password;
        }
    }


}
