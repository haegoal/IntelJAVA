package main;

import dto.ClientDTO;
import respository.BankRespository;
import service.BankService;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();
        BankRespository bankRespository = new BankRespository();
        boolean run = true;
        while (run) {
            System.out.println("====== 계좌관리 ======");
            System.out.println("1.계좌등록 2.계좌조회 3.입금 4.출금 5.입출금내역조회 6.전체계좌보기 0.종료");
            System.out.println("선택>  ");
            int sel = scanner.nextInt();
            if (sel == 1) {
                System.out.println("계좌등록 메뉴");
                bankService.save();
            } else if (sel == 2) {
                System.out.println("계좌조회 메뉴");
                bankService.read();
            } else if (sel == 3) {
                System.out.println("입금 메뉴");
                bankService.insert();
            } else if (sel == 4) {
                System.out.println("출금 메뉴");
                bankService.withdraw();
            } else if (sel == 5) {
                System.out.println("입출금 메뉴");
                if(bankService.faccount()==0){
                    System.out.println("없는 계좌입니다.");
                }else {
                    boolean find = true;
                    while (find) {
                        System.out.println("====== 입출금관리 ======");
                        System.out.println("1.전체내역 2.입금내역 3.출금내역 4.종료");
                        System.out.println("선택>  ");
                        sel = scanner.nextInt();
                        switch (sel) {
                            case 1:
                                bankService.all();
                                break;
                            case 2:
                                bankService.delist();
                                break;
                            case 3:
                                bankService.wlist();
                                break;
                            case 4:
                                find = false;
                                break;
                        }
                    }
                }
            }else if (sel == 6) {
                System.out.println("전체계좌조회 메뉴");
                bankService.list();
            } else if (sel == 0) {
                System.out.println("종료");
                break;
            }
        }
    }
}