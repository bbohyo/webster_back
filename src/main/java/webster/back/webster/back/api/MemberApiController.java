package webster.back.webster.back.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webster.back.webster.back.domain.GenderStatus;
import webster.back.webster.back.domain.Member;
import webster.back.webster.back.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberservice;

    @PostMapping("api/join")
    public CreateMemberResponse join(@RequestBody CreateMemberRequest request){
        Member member = new Member();
        member.setName(request.name);
        member.setEmail(request.email);
        member.setGender(request.gender);
        member.setPassword(request.password);
        Long id = memberservice.join(member);
        return new CreateMemberResponse();
    }

    @PostMapping("api/login")
    public SignUpMemberResponse login (@RequestBody SignUpMemberRequest request){
        memberservice.login(request.email, request.password);

        return new SignUpMemberResponse();
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
    }


}
