package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.entity.BoardEntity;
import com.icia.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSave(boardDTO);
        Long savedId = boardRepository.save(boardEntity).getId();
        return savedId;
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<BoardDTO> boardDTOList = new ArrayList<>();
        boardEntityList.forEach(entity -> {
            boardDTOList.add(BoardDTO.toDTO(entity));
        });
        return boardDTOList;
    }

    public BoardDTO findById(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        return BoardDTO.toDTO(boardEntity);
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    public void update(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toUpdate(boardDTO);
        boardRepository.save(boardEntity);
    }

    @Transactional
    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }
}
