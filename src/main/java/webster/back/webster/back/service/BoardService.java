package webster.back.webster.back.service;

import jakarta.annotation.Nullable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import webster.back.webster.back.domain.GroupEntity;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import webster.back.webster.back.domain.*;
import webster.back.webster.back.repository.BoardRepository;
import webster.back.webster.back.dto.BoardDto;


import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @PostConstruct
    public void PostConstruct(){
        if (boardRepository == null){
            throw new IllegalStateException("ERROR");
        }
    }

    private DevLocation location = DevLocation.함께식당;


    private DevNumberOfPeople numberOfPeople = DevNumberOfPeople.TWO;


    private DevGender gender = DevGender.MIX;


    private DevSelectTime selectTime = DevSelectTime.ELEVENOCLOCK;

    private GroupEntity groupEntity;

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
    public void saveLocation(Long id, DevLocation location) {
        if (boardRepository == null) {
            throw new IllegalStateException("boardRepository is not initialized");
        }

        GroupEntity groupEntity = boardRepository.findById(id)
                .orElseGet(() -> new GroupEntity(id, location, numberOfPeople, gender, selectTime));

        groupEntity.setLocation(location);

        boardRepository.save(groupEntity);
    }


    @Transactional
    public void saveNumberOfPeople(Long id, DevNumberOfPeople numberOfPeople) {

        if (boardRepository == null) {
            throw new IllegalStateException("boardRepository is not initialized");
        }

        GroupEntity groupEntity = boardRepository.findById(id)
                .orElseGet(() -> new GroupEntity(id, location, numberOfPeople, gender, selectTime));

        groupEntity.setNumberOfPeople(numberOfPeople);

        boardRepository.save(groupEntity).getId();
    }
    @Transactional
    public void saveGender(Long id, DevGender gender){
        if (boardRepository == null) {
            throw new IllegalStateException("boardRepository is not initialized");
        }

        GroupEntity groupEntity = boardRepository.findById(id)
                .orElseGet(() -> new GroupEntity(id, location, numberOfPeople, gender, selectTime));

        groupEntity.setGender(gender);
        boardRepository.save(groupEntity).getId();
    }

    @Transactional
    public void saveSelectTime (Long id, DevSelectTime selectTime){
        if (boardRepository == null) {
            throw new IllegalStateException("boardRepository is not initialized");
        }

        GroupEntity groupEntity = boardRepository.findById(id)
                .orElseGet(() -> new GroupEntity(id, location, numberOfPeople, gender, selectTime));

        groupEntity.setGender(gender);

        boardRepository.save(groupEntity).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }


}
