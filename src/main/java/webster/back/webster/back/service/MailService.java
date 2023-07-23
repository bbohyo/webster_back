package webster.back.webster.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webster.back.webster.back.domain.Mail;
import webster.back.webster.back.domain.Member;
import webster.back.webster.back.repository.MemberRepository;

import java.io.Console;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class MailService {
    private final JavaMailSender emailSender;
    private final MemberRepository memberRepository;

    //비밀번호 찾기 서비스
    public void findPassword(String email){
        Optional<Member> member = memberRepository.findByEmail(email);
        Mail mail = new Mail();
//        if (member.isEmpty()){
//            throw new IllegalStateException("존재하지 않는 회원");
//        }
        if (member.isPresent()){
            System.out.println(1L);
            mail.setAddress(member.get().getEmail());
            mail.setTitle("임시비밀번호 입니다.");
            mail.setContent(member.get().getPassword());
            sendSimpleMessage(mail);

        }
        else {
            System.out.println(0);
//            mail.setAddress("kym2675@naver.com");
//            mail.setTitle("임시비밀번호 입니다.");
//            mail.setContent("임시");
//            sendSimpleMessage(mail);

        }


    }

    public void sendSimpleMessage(Mail mail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kymyy2675@gmail.com");
        message.setTo(mail.getAddress());
        message.setSubject(mail.getTitle());
        message.setText(mail.getContent());
        emailSender.send(message);
    }
}
