package service;

import dto.AccountDTO;
import dto.ClientDTO;
import java.time.LocalDateTime;
import respository.BankRespository;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;



public class BankService {
    BankRespository bankRespository = new BankRespository();
    Scanner scanner = new Scanner(System.in);

    public void save() {
        LocalDateTime now = LocalDateTime.now();
        boolean find = true;
        System.out.println("이름: ");
        String name = scanner.next();
        System.out.println("비번: ");
        String pw = scanner.next();
        while(find){
            System.out.println("계좌번호: ");
            String account = scanner.next();
            ClientDTO clientDTO = bankRespository.findId(account);
            if(clientDTO==null){
                find = false;
                String createdAt = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                clientDTO = new ClientDTO(name, pw, account);
                clientDTO.setClientCreatedAt(createdAt);
                boolean result = bankRespository.save(clientDTO);
                if(result){
                    System.out.println("등록완료");
                }else{
                    System.out.println("등록실패");
                }
            }else{
                System.out.println("이미 등록된 계좌입니다.");
            }
        }
    }


    public void list() {
        List<ClientDTO> clientDTOList = bankRespository.findAll();
        for (ClientDTO clientDTO: clientDTOList) {
            System.out.println("clientDTO = " + clientDTO);
        }
    }

    public void read() {
        System.out.println("계좌번호: ");
        String account = scanner.next();
        ClientDTO clientDTO = bankRespository.findId(account);
        if(clientDTO==null){
            System.out.println("없는 계좌입니다.");
        }else{
            System.out.println("잔액은 " + clientDTO.getBalance() + "입니다.");
        }
    }

    public int faccount() {
        System.out.println("계좌번호: ");
        String account = scanner.next();
        ClientDTO clientDTO = bankRespository.findId(account);
        if(clientDTO==null){
            return 0;
        }else{
            return 1;
        }
    }


    public void insert() {
        System.out.println("계좌번호: ");
        String account = scanner.next();
        System.out.println("입금하려는 금액입력바람");
        int money = scanner.nextInt();
        ClientDTO clientDTO = bankRespository.findId(account);
        if(clientDTO==null){
            System.out.println("없는 계좌입니다.");
        }else{
            if(money>0) {
                clientDTO.setBalance(clientDTO.getBalance() + money);
                LocalDateTime now = LocalDateTime.now();
                String bankingAt = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                AccountDTO accountDTO = new AccountDTO(account, money);
                accountDTO.setBankingAt(bankingAt);
                bankRespository.desave(accountDTO);
                bankRespository.asave(accountDTO);
            }else{
                System.out.println("0원이하는 입금못합니다.");
            }
        }
    }

    public void withdraw() {
        System.out.println("계좌번호: ");
        String account = scanner.next();
        System.out.println("계좌비번: ");
        String pw = scanner.next();
        System.out.println("출금액: ");
        long money = scanner.nextInt();
        ClientDTO clientDTO = bankRespository.findId(account);
        if(clientDTO==null){
            System.out.println("없는 계좌입니다.");
        }else{
            clientDTO = bankRespository.findPw(pw);
            if(clientDTO==null){
                System.out.println("비번이틀림");
            }else{
                if(clientDTO.getBalance()<money){
                    System.out.println("금액이부조카다");
                }else{
                    clientDTO.setBalance(clientDTO.getBalance()-money);
                    System.out.println(money + "원 출금완료");
                    LocalDateTime now = LocalDateTime.now();
                    String bankingAt = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    AccountDTO accountDTO = new AccountDTO(account, money);
                    accountDTO.setBankingAt(bankingAt);
                    bankRespository.wisave(accountDTO);
                    bankRespository.asave(accountDTO);
                }
            }
        }
    }

    public void delist() {
        List<AccountDTO> delist = bankRespository.delist();
        for (AccountDTO accountDTO: delist) {
            System.out.println("AccountDTO = " + accountDTO);
        }
    }

    public void wlist() {
        List<AccountDTO> wlist = bankRespository.wlist();
        for (AccountDTO accountDTO: wlist) {
            System.out.println("AccountDTO = " + accountDTO);
        }
    }

    public void all() {
        List<AccountDTO> alist = bankRespository.alist();
        for (AccountDTO accountDTO: alist) {
            System.out.println("AccountDTO = " + accountDTO);
        }
    }
}
