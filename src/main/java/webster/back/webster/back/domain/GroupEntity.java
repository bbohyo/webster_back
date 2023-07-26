package webster.back.webster.back.domain;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private DevLocation location;

    @Enumerated(EnumType.STRING)
    @Column(name = "numberOfPeople")
    private DevNumberOfPeople numberOfPeople;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private DevGender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "selectTime")
    private DevSelectTime selectTime;

    @Column(name = "localDateTime")
    private LocalDateTime localDateTime;

    public GroupEntity() {
    }

    @Builder
    public GroupEntity(Long id, DevLocation location, DevNumberOfPeople numberOfPeople, DevGender gender, DevSelectTime selectTime) {
        this.id = id;
        this.location = location;
        this.numberOfPeople = numberOfPeople;
        this.gender = this.gender;
        this.selectTime = this.selectTime;
    }

}


