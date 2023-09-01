package service;

import dto.BoardDTO;
import respository.BoardRespository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner sc = new Scanner(System.in);
    BoardDTO boardDTO = new BoardDTO();
    BoardRespository boardRespository = new BoardRespository();

    public void insert() {
        System.out.println("제목입력");
        String title = sc.next();
        System.out.println("작성자입력");
        String writer = sc.next();
        System.out.println("내용입력");
        String contents = sc.next();
        System.out.println("비번입력");
        String pw = sc.next();

        boardDTO = new BoardDTO(title, writer, contents, pw);
        boolean result = boardRespository.insert(boardDTO);
        if(result){
            System.out.println("등록완료");
        }else{
            System.out.println("등록실패");
        }
    }

    public void list() {
        List<BoardDTO> list = boardRespository.list();
        for(BoardDTO boardDTO:list) {
            System.out.println(boardDTO);
        }
    }

    public void read() {
        System.out.println("조회할 번호입력");
        int id = sc.nextInt();
        boardDTO = boardRespository.read(id);
        if(boardDTO!=null){
            System.out.println("증가완료");
        }else{
            System.out.println("없는 글입니다.");
        }
    }

    public void update(){
        System.out.println("조회할 번호입력");
        int id = sc.nextInt();
        System.out.println("비번입력");
        String pw = sc.next();
        int num = boardRespository.find(id, pw);
        if(num==0){
            System.out.println("글을 찾을수가 없서");
        }else if(num==1){
            System.out.println("비번이틀림");
        }else{
            System.out.println("수정할 제목입력");
            String title = sc.next();
            System.out.println("수정할 내용입력");
            String contents = sc.next();
            boardDTO = boardRespository.update(id,title,contents);
            if(boardDTO!=null){
                System.out.println("수정완료");
            }
        }
    }

    public void delete() {
        System.out.println("조회할 번호입력");
        int id = sc.nextInt();
        System.out.println("비번입력");
        String pw = sc.next();
        int num = boardRespository.find(id, pw);
        if(num==0){
            System.out.println("글을 찾을수가 없서");
        }else if(num==1){
            System.out.println("비번이틀림");
        }else{
            boardDTO = boardRespository.delete(id);
        }
    }

    public void search() {
        System.out.println("조회할 제목입력");
        String title = sc.next();
        boardRespository.search(title);
    }
}
