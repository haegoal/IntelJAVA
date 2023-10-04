package com.icia.board.dto;

import lombok.Data;

@Data
public class BoardFileDTO {
    private Long id;
    private String originalFileName;
    private String storedFileName;
    private Long boardId;

}
