package com.study.board.controller;

import com.study.board.entity.knwboard;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {


    @Autowired
    private BoardService boardService;

    @GetMapping("/board/writer")
    public String board_writer(){
        return "board_writer";
    }


    @PostMapping("board/board_write_do")
    public String board_write_do(knwboard knwboard, Model m){


    m.addAttribute("message", "글 작성 완료!");
    m.addAttribute("searchUrl", "/board/list");
    boardService.write(knwboard);

        return "message";
    }

    @GetMapping("/board/list")
    public String boardlist(Model m){
        m.addAttribute("list", boardService.knwboardList());
        return "boardlist";
    }

    @GetMapping("/board/view")
    public String view(Model m, Integer id){
        m.addAttribute("board",boardService.boardview(id));
        return "board_view";
    }


    @GetMapping("/board/delete")
    public String delete(Integer id){
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String modify(@PathVariable("id") Integer id,Model m){
        System.out.println("수정!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@@@@@@@@");
        m.addAttribute("board",boardService.boardview(id));
        return "board_modify";
    }


//    @PostMapping("board/update/{id}")
//    public String update(@PathVariable("id") Integer id,
//                         knwboard knwboard,
//                         @RequestParam("title") String title,
//                         @RequestParam("content") String content){
//        System.out.println("업데이트 호출");
//        System.out.println(title + content + "업데이트 아이디");
//
//        knwboard boardtmp = boardService.boardview(id);
//        boardtmp.setTitle(title);
//        boardtmp.setContent(content);
//
//        boardService.write(boardtmp);
//
//        return "redirect:/board/list";
//    }


    @PostMapping("board/modify/{id}")
    public String update(@PathVariable("id") Integer id,
                         knwboard knwboard, Model m){

        System.out.println("업데이트 호출");

        System.out.println(knwboard);

        knwboard boardtmp = boardService.boardview(id);
        boardtmp.setTitle(knwboard.getTitle());
        boardtmp.setContent(knwboard.getContent());

        System.out.println("knwboard : " + knwboard);
        System.out.println("boardtmp : " + boardtmp);

        boardService.write(boardtmp);

        m.addAttribute("message","글 수정 완료!");
        m.addAttribute("searchUrl","/board/modify/"+id);

        return "message";
    }

}
