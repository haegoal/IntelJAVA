package com.icia.board.controller;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.BoardFileDTO;
import com.icia.board.dto.CommentDTO;
import com.icia.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller

public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/save")
    public String save(){
        return "boardSave";
    }
    @PostMapping("/board/save")
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.save(boardDTO);
        return "redirect:/board/";
    }

    @GetMapping("/board/")
    public String list(Model model){
        List<BoardDTO> boardDTOList = boardService.list();
        model.addAttribute("board", boardDTOList);
        return "boardList";
    }

    @GetMapping("/board")
    public String findId(@RequestParam("id") Long id,Model model, String a){
        BoardDTO boardDTO = boardService.findId(id);
        boardDTO.setBoardHits(boardDTO.getBoardHits()+1);
        boardService.update(boardDTO);
        if(boardDTO.getFileAttached() ==1 ){
            BoardFileDTO boardFileDTO = boardService.findFile(id);
            model.addAttribute("boardFile", boardFileDTO);
        }

        model.addAttribute("result", boardDTO);
        List<CommentDTO> commentDTOList = boardService.list(id);
        if(commentDTOList.size()!=0){
            model.addAttribute("cl", commentDTOList);
        }else{
            model.addAttribute("cl", a);
        }
        return "boardDetail";
    }

    // 업데이트 후에는 조회수 늘어나지않게하기위해 새로 만듬
    @GetMapping("/board1")
    public String afterupdate(@RequestParam("id") Long id,Model model){
        BoardDTO boardDTO = boardService.findId(id);
        model.addAttribute("result", boardDTO);
        return "boardDetail";
    }

    @GetMapping("/deleteCheck")
    public String delete(@RequestParam("id") Long id, Model model){
        model.addAttribute("id", id);
        return "/deleteCheck";
    }

    @PostMapping("/board/delete")
    public ResponseEntity delete(@ModelAttribute BoardDTO boardDTO){
       boardDTO = boardService.delete(boardDTO);
       if(boardDTO!=null){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/board/update")
    public String update(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findId(id);
        model.addAttribute("result", boardDTO);
        return "boardUpdate";
    }

    @PostMapping("/board/update")
    public ResponseEntity update(@ModelAttribute BoardDTO boardDTO){
        boolean find = boardService.login(boardDTO);
        if(find){
            boardService.update(boardDTO);
            System.out.println("boardDTO = " + boardDTO);
            return new ResponseEntity<>(boardDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/board/search")
    public ResponseEntity search(@RequestParam("key") String key, @RequestParam("query") String query){
        System.out.println("key = " + key + ", query = " + query);
        HashMap<String, String> map = new HashMap<>();
        map.put("k", key);
        map.put("q",query);
        List<BoardDTO> boardDTOList = boardService.search(map);
        if(boardDTOList!=null){
            return new ResponseEntity<>(boardDTOList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
