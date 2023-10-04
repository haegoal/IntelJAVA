package com.icia.board.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
@Table(name = "board_file_table")
public class BoardFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String originalFileName;

    @Column(length = 100)
    private String storedFileName;

    @ManyToOne
    @JoinColumn(name="board_id", referencedColumnName = "id")
    private BoardEntity board;
}
