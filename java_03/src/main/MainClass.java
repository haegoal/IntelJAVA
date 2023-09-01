package main;

import service.BoardService;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        BoardService boardService = new BoardService();

        while(run){
            System.out.println("----------------------------");
            System.out.println("1.글작성 2.글목록 3.글조회 4.글수정 5.글삭제 6.검색 0종료");
            int menu = sc.nextInt();
            switch (menu){
                case 0:
                    run = false;
                    break;
                case 1:
                    boardService.insert();
                    break;
                case 2:
                    boardService.list();
                    break;
                case 3:
                    boardService.read();
                    break;
                case 4:
                    boardService.update();
                    break;
                case 5:
                    boardService.delete();
                    break;
                case 6:
                    boardService.search();
                    break;
            }
        }
        System.out.println("프로그램이 종료됩니다.");
    }
}
