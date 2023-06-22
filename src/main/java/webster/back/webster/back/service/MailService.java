package webster.back.webster.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import webster.back.webster.back.domain.Mail;
import webster.back.webster.back.domain.Member;
import webster.back.webster.back.repository.MemberRepository;


@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender emailSender;
    private final MemberRepository memberRepository;

    //비밀번호 찾기 서비스
    public void findPassword(String email){
        Member member = memberRepository.findPassword(email);
        Mail mail = new Mail();
        mail.setAddress(member.getEmail());
        mail.setTitle("임시비밀번호 입니다.");
        mail.setContent(member.getPassword());
        sendSimpleMessage(mail);


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
