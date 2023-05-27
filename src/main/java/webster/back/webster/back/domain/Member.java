package webster.back.webster.back.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long id;

    private String password;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private GenderStatus gender;



}
