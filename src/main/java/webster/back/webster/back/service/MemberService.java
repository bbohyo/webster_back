package webster.back.webster.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webster.back.webster.back.domain.Member;
import webster.back.webster.back.dto.MemberRequestDto;
import webster.back.webster.back.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {


    private final MemberRepository memberRepository;


    public Long join(MemberRequestDto dto){
        validateDuplicateMember(dto);
        Member member = new Member();
        member.setName(dto.getName());
        member.setPassword(dto.getPassword());
        member.setEmail(dto.getEmail());
        member.setGender(dto.getGender());
        //가입 처리
        memberRepository.save(member);

        return member.getId();
    }

    public Long login(String email, String password){
        Optional<Member> member= memberRepository.findByEmailAndPassword(email,password);

        if(member.isEmpty()){
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        else{
            return 1L;
        }
    }



    private void validateDuplicateMember(MemberRequestDto dto) {
        Optional<Member> findMember = memberRepository.findByEmail(dto.getEmail());
        if (!findMember.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

}
