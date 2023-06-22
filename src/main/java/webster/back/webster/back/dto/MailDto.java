package webster.back.webster.back.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.stereotype.Service;
import webster.back.webster.back.domain.GenderStatus;


@Data
@RequiredArgsConstructor
@Getter @Setter
public class MailDto {
    private Long id;
    private String password;
    private String name;
    private String email;
    private GenderStatus gender;
}

