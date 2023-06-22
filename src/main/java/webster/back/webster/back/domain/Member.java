package webster.back.webster.back.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @Entity @NoArgsConstructor
public class Member {
    @Id
    @SequenceGenerator(name="T_WD_APLY_APLYSN_GENERATOR", sequenceName="T_WD_APLY_APLY_SN_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="T_WD_APLY_APLYSN_GENERATOR")
    @Column(name="user_id")
    private  Long id;
    private   String password;
    private   String name;
    private   String email;
    @Enumerated(EnumType.STRING)
    private   GenderStatus gender;



}
