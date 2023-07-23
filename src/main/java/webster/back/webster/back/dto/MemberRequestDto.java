package webster.back.webster.back.dto;
import jakarta.validation.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import webster.back.webster.back.domain.GenderStatus;

@Data
public class MemberRequestDto {
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private GenderStatus gender;


}
