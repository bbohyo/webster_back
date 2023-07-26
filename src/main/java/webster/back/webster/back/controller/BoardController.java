package webster.back.webster.back.controller;

import jakarta.annotation.Nullable;
import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import webster.back.webster.back.domain.DevLocation;
import webster.back.webster.back.domain.DevGender;
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
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostConstruct
    public void postConstruct() {
        if (boardService == null) {
            throw new IllegalStateException("boardService is not initialized");
        }
    }
    private BoardRepository boardRepository;


    private DevLocation location;


    private DevNumberOfPeople numberOfPeople;


    private DevGender gender;


    private DevSelectTime selectTime;

    public void LocationBean(){
        switch (location){
            case 부대통령:
                this.location = DevLocation.부대통령;
                break;

        }
    }
    public void GenderBeen(){
        switch(gender){
            case FEMAIL:
                this.gender = DevGender.FEMAIL;
                break;
            case MAIL:
                this.gender = DevGender.MAIL;
                break;
            case MIX:
                this.gender = DevGender.MIX;
                break;
        }
    }

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
    public String writeLocation(@RequestParam Long id, @RequestParam DevLocation location) {
        if (boardService == null) {
            return "redirect:/";
        }

        boardService.saveLocation(id, location);

        return "/post/time";
    }
    @PostMapping("/post/time")
    public String writeTime(Long id, DevSelectTime selectTime) {
        boardService.saveSelectTime(id, selectTime);

        return "/post/num";
    }
    @PostMapping("/post/num")
    public String writeNumGender(Long id, DevNumberOfPeople numberOfPeople, DevGender gender) {
        boardService.saveNumberOfPeople(id, numberOfPeople);
        boardService.saveGender(id, gender);

        return "/post/fin";
    }

    @GetMapping("/post/fin")
    public String writeFin(){
        return "/list";
    }

    /*자동삭제*/
    @DeleteMapping("/list/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }


}
