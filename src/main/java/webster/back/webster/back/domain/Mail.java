package webster.back.webster.back.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mail {
    @Id
    @SequenceGenerator(name="T_WD_APLY_APLYSN_GENERATOR", sequenceName="T_WD_APLY_APLY_SN_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="T_WD_APLY_APLYSN_GENERATOR")
    @Column(name="mail_id")
    private Long id;
    private String address;
    private String title;
    private String content;
}

