package main;

import service.StudentService;

import java.util.Scanner;

public class MainClass {
    // 스캐너를 이용하여
    // 1. 학생등록
    // 2. 학생상세조회
    // 3. 학생목록조회
    // 를 선택하는 코드를 작성합시다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        boolean run = true;
        while (run) {
            System.out.println("====== 학생관리 ======");
            System.out.println("1.학생등록 2.학생조회 3.학생목록 4.정보수정 5.삭제 0.종료");
            System.out.println("선택>  ");
            int sel = scanner.nextInt();
            if (sel == 1) {
                System.out.println("학생등록 메뉴");
                studentService.save();
            } else if (sel == 2) {
                System.out.println("학생조회 메뉴");
                studentService.findById();
            } else if (sel == 3) {
                System.out.println("학생목록 메뉴");
                studentService.findAll();
            } else if (sel == 4) {
                System.out.println("학생수정 메뉴");
                studentService.update();
            } else if (sel == 5) {
                System.out.println("학생삭제 메뉴");
                studentService.deleteById();
            } else if (sel == 0) {
                System.out.println("종료");
                break;
            }
        }
    }
}