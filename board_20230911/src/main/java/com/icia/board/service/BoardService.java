package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.BoardFileDTO;
import com.icia.board.dto.CommentDTO;
import com.icia.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) throws IOException {
       if(boardDTO.getBoardFile().isEmpty()){
           boardDTO.setFileAttached(0);
           boardRepository.save(boardDTO);
       }else{
           //파일있다
           boardDTO.setFileAttached(1);
           //게시글 저장후 id값활용을 위해 리턴받음.
           BoardDTO saveBoard = boardRepository.save(boardDTO);
           //파일만 따로가져오기
           MultipartFile boardFile = boardDTO.getBoardFile();
           //파일 이름가져오기
           String originalFilename = boardFile.getOriginalFilename();
           //저장용 이름만들기
           String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
           BoardFileDTO boardFileDTO = new BoardFileDTO();
           boardFileDTO.setOriginalFileName(originalFilename);
           boardFileDTO.setStoredFileName(storedFileName);
           boardFileDTO.setBoardId(saveBoard.getId());
           //파일 저장용 폴더에 파일 저장 처리
           String savePath = "C:\\spring_img\\" + storedFileName;
           boardFile.transferTo(new File(savePath)); //실제 파일옴겨주는 메소드
           boardRepository.saveFile(boardFileDTO);
       }
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

    public List<CommentDTO> list(Long id) {
        return boardRepository.list(id);
    }

    public BoardFileDTO findFile(Long id) {
        return boardRepository.findFile(id);
    }
}
