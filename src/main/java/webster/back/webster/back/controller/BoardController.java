package webster.back.webster.back.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import webster.back.webster.back.domain.DevGender;
import webster.back.webster.back.domain.DevLocation;
import webster.back.webster.back.domain.DevNumberOfPeople;
import webster.back.webster.back.domain.DevSelectTime;
import webster.back.webster.back.dto.BoardDto;
import webster.back.webster.back.repository.BoardRepository;
import webster.back.webster.back.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

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
    /*리스트 출력*/
    @GetMapping("/")
    public String list(Model model){
        List<BoardDto> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);

        return "/list.html";
    }

    /*방 만들기 페이지*/
    @GetMapping("/list")
    public String write() {
        return "board/write.html";
    }

    @PostMapping("/post/location")
    public String writeLocation(DevLocation location) {
        boardService.savePost_location(location);

        return "/post/time";
    }
    @PostMapping("/post/time")
    public String writeTime(DevSelectTime selectTime) {
        boardService.savePost_selectTime(selectTime);

        return "/post/num";
    }
    @PostMapping("/post/num")
    public String writeNum(DevNumberOfPeople numberOfPeople, DevGender gender) {
        boardService.savePost_num(numberOfPeople, gender);

        return "/post/fin";
    }

    @GetMapping("/post/fin")
    public String writedb(BoardDto boardDto){
        boardService.savePost_db(boardDto);

        return "/list";
    }

    /*자동삭제*/
    @DeleteMapping("/list/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }


}
