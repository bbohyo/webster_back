package webster.back.webster.back.service;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import webster.back.webster.back.domain.*;
import webster.back.webster.back.repository.BoardRepository;
import webster.back.webster.back.dto.BoardDto;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    @NonNull
    private DevLocation location;
    @Autowired
    @NonNull
    private DevNumberOfPeople numberOfPeople;
    @Autowired
    @NonNull
    private DevGender gender;
    @Autowired
    @NonNull
    private DevSelectTime selectTime;

    private BoardDto convertEntityToDto(GroupEntity groupEntity) {
        return BoardDto.builder()
                .id(groupEntity.getId())
                .location(groupEntity.getLocation())
                .numberOfPeople(groupEntity.getNumberOfPeople())
                .gender(groupEntity.getGender())
                .selectTime(groupEntity.getSelectTime())
                .build();
    }

    @Transactional
    public List<BoardDto> getBoardlist() {
        List<GroupEntity> groupEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (GroupEntity groupEntity : groupEntities){
            boardDtoList.add(this.convertEntityToDto(groupEntity));
        }

        return boardDtoList;
    }
    @Transactional
    public void savePost_location(DevLocation location) {
        this.location = location;
    }

    @Transactional
    public void savePost_num(DevNumberOfPeople numberOfPeople, DevGender gender) {
        this.numberOfPeople = numberOfPeople;
        this.gender = gender;
    }

    @Transactional
    public void savePost_selectTime (DevSelectTime selectTime){
        this.selectTime = selectTime;
    }
    @Transactional
    public Long savePost_db(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
}
    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }


}
