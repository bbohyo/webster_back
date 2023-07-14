package webster.back.webster.back;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.context.web.WebAppConfiguration;
import webster.back.webster.back.domain.*;
import webster.back.webster.back.repository.BoardRepository;
import webster.back.webster.back.service.BoardService;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Test
	@Transactional
	@DisplayName("멤버가 생성되는지 확인")
	void contextLoads() {
		//given
		GroupEntity groupEntity = GroupEntity.builder().id(2022L).location(DevLocation.예시2).numberOfPeople(DevNumberOfPeople.TWO).gender(DevGender.FEMAIL).selectTime(DevSelectTime.FOURFOUR).build();

		//when, then
		assertThat(groupEntity.getId()).isEqualTo(2022L);
		assertThat(groupEntity.getLocation()).isEqualTo(DevLocation.예시2);
		assertThat(groupEntity.getNumberOfPeople()).isEqualTo(DevNumberOfPeople.TWO);
		assertThat(groupEntity.getGender()).isEqualTo(DevGender.FEMAIL);
		assertThat(groupEntity.getSelectTime()).isEqualTo(DevSelectTime.FOURFOUR);
	}

}
