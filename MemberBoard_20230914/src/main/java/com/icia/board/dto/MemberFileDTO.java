package com.icia.board.dto;

import lombok.Data;

@Data
public class MemberFileDTO {
    private Long id;
    private Long memberId;
    private String originalFileName;
    private String storedFileName;
}
