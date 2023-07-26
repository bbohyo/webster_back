package webster.back.webster.back;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import webster.back.webster.back.domain.*;
import webster.back.webster.back.dto.BoardDto;
import webster.back.webster.back.service.BoardService;


import static org.assertj.core.api.Assertions.assertThat;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private BoardService boardService;

	private BoardDto boardDto;

	@Test
	@Transactional
	@DisplayName("장소저장 확인")
	public void DBsaveTest() {


		//given
		GroupEntity groupEntity = GroupEntity.builder().id(2022L).location(DevLocation.부대통령).numberOfPeople(DevNumberOfPeople.TWO).gender(DevGender.FEMAIL).selectTime(DevSelectTime.FIFTEENFOURTY).build();
		boardService.saveLocation(2022L, DevLocation.리또리또);
		boardService.saveGender(2022L, DevGender.FEMAIL);
		boardService.saveNumberOfPeople(2022L, DevNumberOfPeople.TWO);
		boardService.saveSelectTime(2022L, DevSelectTime.FOURTEENFOURTY);

		//then
		assertThat(groupEntity.getId()).isEqualTo(2022L);
		assertThat(groupEntity.getLocation()).isEqualTo(DevLocation.리또리또);
		assertThat(groupEntity.getNumberOfPeople()).isEqualTo(DevNumberOfPeople.TWO);
		assertThat(groupEntity.getGender()).isEqualTo(DevGender.FEMAIL);
		assertThat(groupEntity.getSelectTime()).isEqualTo(DevSelectTime.FOURTEENFOURTY);
		}

}
