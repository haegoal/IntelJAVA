package main;

import Service.UserService;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        UserService userService = new UserService();


        while(run){
            System.out.println("-------------회원--------------");
            System.out.print("1.회원가입 2.로그인 3.회원목록조회 4.회원정보수정 5.회원탈퇴 6.로그아웃 0.종료");
            int menu= scanner.nextInt();
            switch (menu){
                case 0:
                    run=false;
                    break;
                case 1:
                    userService.newID();
                    break;
                case 2:
                    userService.login();
                    break;
                case 3:
                    userService.list();
                    break;
                case 4:
                    userService.update();
                    break;
                case 5:
                    userService.delete();
                    break;
                case 6:
                    userService.logout();
                    break;
            }
        }
        System.out.println("프로그램이 종료됩니다.");
    }
}
