package com.icia.board.controller;

import com.icia.board.dto.CommentDTO;
import com.icia.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public String save(@ModelAttribute CommentDTO commentDTO){
        commentService.save(commentDTO);
        System.out.println("commentDTO = " + commentDTO);
        return "boardDetail";
    }

    @GetMapping
    public ResponseEntity  list(@RequestParam("boardId") Long boardId){

        List<CommentDTO> commentDTOList = commentService.list(boardId);
        System.out.println("commentDTOList = " + commentDTOList);
        if(commentDTOList!=null){
            return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
