package com.icia.board.repository;

import com.icia.board.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public void save(BoardDTO boardDTO) {
        sql.insert("Board.save", boardDTO);
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
}
