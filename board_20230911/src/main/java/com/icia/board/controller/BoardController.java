package com.icia.board.controller;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.BoardFileDTO;
import com.icia.board.dto.CommentDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.service.BoardService;
import org.apache.taglibs.standard.lang.jstl.ModulusOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "redirect:/board/list";
    }


    @GetMapping("/board")
    public String findId(@RequestParam("id") Long id,
                         @RequestParam(value = "query", required = false, defaultValue = "") String query,
                         @RequestParam(value = "key", required = false, defaultValue = "boardTitle") String key,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                         Model model){
        BoardDTO boardDTO = boardService.findId(id);
        boardDTO.setBoardHits(boardDTO.getBoardHits()+1);
        boardService.update(boardDTO);
        if(boardDTO.getFileAttached() ==1 ){
            List<BoardFileDTO> boardFileList = boardService.findFile(id);
            model.addAttribute("boardFileList", boardFileList);
        }
        model.addAttribute("result", boardDTO);
        List<CommentDTO> commentDTOList = boardService.list(id);
        if(commentDTOList.size()!=0){
            model.addAttribute("cl", commentDTOList);
        }else{
            model.addAttribute("cl", null);
        }
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        model.addAttribute("key", key);
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

    @GetMapping("/board/list")
    public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                       @RequestParam(value = "query", required = false, defaultValue = "") String query,
                       @RequestParam(value = "key", required = false, defaultValue = "boardTitle") String key,
                       Model model){

        List<BoardDTO> boardDTOList =null;
        PageDTO pageDTO = null;

        if(query.equals("")){
            boardDTOList = boardService.paginglist(page);
            pageDTO = boardService.pageNumber(page);
        }else{
            boardDTOList = boardService.search(key, query, page);
            pageDTO = boardService.searchPageNumber(key, query, page);
        }
        model.addAttribute("boardList", boardDTOList);
        model.addAttribute("paging", pageDTO);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        return "boardList";
    }

//    @GetMapping("/board/search")
//    public String search(@RequestParam("key") String key,
//                                 @RequestParam("query") String query,
//                                 @RequestParam(value = "page", required = false, defaultValue = "1")int page,
//                                 Model model)
//                                {
//        System.out.println("key = " + key + ", query = " + query);
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("k", key);
//        map.put("q",query);
//
//        int pageLimit = 3;
//        int pageingStart = (page -1) * pageLimit;
//        map.put("start", pageingStart);
//        map.put("limit", pageLimit);
//        List<BoardDTO> boardDTOList = boardService.search(map);
//        model.addAttribute("boardList", boardDTOList);
//        PageDTO pageDTO = boardService.searchPageNumber(key, query, page);
//        model.addAttribute("paging", pageDTO);
//        return "boardList";
//    }
}
