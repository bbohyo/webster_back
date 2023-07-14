package webster.back.webster.back.dto;


import webster.back.webster.back.domain.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardDto {
    private Long id;
    private LocalDateTime localDateTime;
    private DevLocation location;
    private DevNumberOfPeople numberOfPeople;
    private DevGender gender;

    private DevSelectTime selectTime;

    public GroupEntity toEntity() {
        GroupEntity groupEntity = GroupEntity.builder()
                .id(id)
                .location(location)
                .numberOfPeople(numberOfPeople)
                .gender(gender)
                .selectTime(selectTime)
                .build();
        return groupEntity;
    }


    @Builder
    public BoardDto(Long id, DevLocation location, DevNumberOfPeople numberOfPeople, DevGender gender, LocalDateTime localDateTime, DevSelectTime selectTime) {
        this.id = id;
        this.location = location;
        this.numberOfPeople = numberOfPeople;
        this.gender = gender;
        this.localDateTime = localDateTime;
        this.selectTime = selectTime;
    }

}