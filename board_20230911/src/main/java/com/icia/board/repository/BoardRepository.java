package com.icia.board.repository;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.BoardFileDTO;
import com.icia.board.dto.CommentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public BoardDTO save(BoardDTO boardDTO) {
        System.out.println("insert전 boardDTO = " + boardDTO);
        sql.insert("Board.save", boardDTO);
        System.out.println("insert후 boardDTO = " + boardDTO);
        return boardDTO;
    }

    public List<BoardDTO> list() {
        return sql.selectList("Board.list");
    }

    public BoardDTO findId(Long id) {
        return sql.selectOne("Board.findId", id);
    }

    public int delete(BoardDTO boardDTO) {
        return sql.delete("Board.delete", boardDTO);
    }

    public BoardDTO login(BoardDTO boardDTO) {
        return sql.selectOne("Board.login", boardDTO);
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }

    public List<BoardDTO> search(HashMap<String, String> map) {
        return sql.selectList("Board.search", map);
    }
    public List<CommentDTO> list(Long id) {
        return sql.selectList("Comment.list", id);
    }

    public void saveFile(BoardFileDTO boardFileDTO) {
        sql.insert("Board.saveFile", boardFileDTO);
    }

    public List<BoardFileDTO> findFile(Long boardId) {
        return sql.selectList("Board.findFile", boardId);
    }

    public List<BoardDTO> paginglist(Map<String, Integer> pagingMap) {
        return sql.selectList("Board.paging", pagingMap);
    }

    public int boardCount() {
        return sql.selectOne("Board.count");
    }
}
