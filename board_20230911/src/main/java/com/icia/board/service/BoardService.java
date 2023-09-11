package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
    }

    public List<BoardDTO> list() {
        return boardRepository.list();
    }

    public BoardDTO findId(Long id) {
        return boardRepository.findId(id);
    }

    public BoardDTO delete(BoardDTO boardDTO) {
        if(boardRepository.delete(boardDTO)==0){
            return null;
        }else{
            return boardDTO;
        }
    }

    public boolean login(BoardDTO boardDTO) {
        if(boardRepository.login(boardDTO)!=null){
            return true;
        }else{
            return false;
        }
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public List<BoardDTO> search(HashMap<String, String> map) {
        return boardRepository.search(map);
    }
}
