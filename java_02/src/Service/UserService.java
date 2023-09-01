package Service;

import dto.UserDTO;
import respository.UserRespository;

import java.util.List;
import java.util.Scanner;

public class UserService {
    Scanner scanner = new Scanner(System.in);
    UserRespository userRespository = new UserRespository();
    UserDTO userDTO = new UserDTO();
    boolean run= true;
    private static String loginEmail = null;

    public void newID() {
        while(run) {
            System.out.print("이메일입력: ");
            String email = scanner.next();
            UserDTO userDTO = userRespository.check(email);
            if (userDTO == null) {
                System.out.print("비번입력: ");
                String pw = scanner.next();
                System.out.print("이름입력: ");
                String name = scanner.next();
                System.out.print("번호입력: ");
                String phone = scanner.next();

                userDTO = new UserDTO(email, pw, name, phone);

                boolean result = userRespository.newID(userDTO);
                if (!result) {
                    System.out.println("실패했습니다.");
                } else {
                    System.out.println("등록되었습니다.");
                    break;
                }
            }
        }
    }

    public void list() {
        List<UserDTO> userDTOList = userRespository.list();
        for (UserDTO userDTO: userDTOList) {
            System.out.println("유저" + userDTO);
        }
    }

    public void login() {
        if(loginEmail==null) {
            System.out.print("이메일입력: ");
            String email = scanner.next();
            System.out.print("비번입력: ");
            String pw = scanner.next();
            UserDTO userDTO = userRespository.login(email, pw);
            if (userDTO == null) {
                System.out.println("로그인실패");
            } else {
                System.out.println("로그인성공");
                loginEmail = userDTO.getMemberEmail();
            }
        }else{
            System.out.println("이미 로그인상태입니다. 로그아웃바람");
        }
    }

    public void delete() {
        if(loginEmail!=null) {
            System.out.print("비번입력: ");
            String pw = scanner.next();
            UserDTO userDTO = userRespository.delete(pw);
            if (userDTO == null) {
                System.out.println("비번틀림");
            } else {
                System.out.println("삭제완료");
                loginEmail=null;
            }
        }else{
            System.out.print("삭제할 아이디입력: ");
            int id = scanner.nextInt();
            System.out.print("비번입력: ");
            String pw = scanner.next();
            UserDTO userDTO = userRespository.delete(id, pw);
            if (userDTO == null) {
                System.out.println("없는계정이당");
            } else {
                System.out.println("삭제완료");
            }
        }
    }

    public void update() {
        if (loginEmail == null) {
            System.out.print("이메일입력: ");
            String email = scanner.next();
            System.out.print("비번입력: ");
            String pw = scanner.next();
            UserDTO userDTO = userRespository.update(email, pw);
            if (userDTO == null) {

            }else {
                System.out.print("바꿀번호입력: ");
                String phone = scanner.next();
                userDTO.setMemberMobile(phone);
            }
        }else{
            System.out.print("비번입력: ");
            String pw = scanner.next();
            UserDTO userDTO = userRespository.update(pw);
            if (userDTO == null) {
                System.out.println("비밀번호틀렸음");
            } else {
                System.out.print("바꿀번호입력: ");
                String phone = scanner.next();
                userDTO.setMemberMobile(phone);
            }
        }
    }

    public void logout() {
        if(loginEmail!=null) {
            System.out.println("로그아웃되었습니다.");
            loginEmail = null;
        }else {
            System.out.println("로그인안했음");
        }
    }
}
