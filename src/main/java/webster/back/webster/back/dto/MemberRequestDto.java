package webster.back.webster.back.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import webster.back.webster.back.domain.GenderStatus;

@Data
public class MemberRequestDto {
    private String password;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private GenderStatus gender;


}
