package service;

import dto.StudentDTO;
import respository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class StudentService {
    Scanner scanner = new Scanner(System.in);
    StudentRepository studentRepository = new StudentRepository();
    // 학생등록 메서드
    // 매개변수 없음.
    // 리턴 없음.
    // 메서드 이름: save()
    // 실행내용
    // 스캐너로 이름(studentName), 학과(studentMajor), 전화번호(studentMobile)를 입력받고
    // 입력값을 DTO객체에 담아서 StudentRepository의 save() 메서드로 전달
    public void save() {
        System.out.println("이름: ");
        String studentName = scanner.next();
        System.out.println("학과: ");
        String studentMajor = scanner.next();
        System.out.println("전화번호: ");
        String studentMobile = scanner.next();
        // DTO 객체
        StudentDTO studentDTO = new StudentDTO(studentName, studentMajor, studentMobile);

        // DTO 객체를 StudentRepository의 save() 메서드로 전달하여 리턴을 boolean으로 받음.
        boolean result = studentRepository.save(studentDTO);
        // repository의 save() 내용
        // 넘겨받은 dto 객체를 리스트에 추가하고 추가하면 true 리턴
        if (result) {
            System.out.println("등록 성공");
            System.out.println(studentRepository.findAll());
        } else {
            System.out.println("등록 실패");
        }
    }

    public void findAll() {
        // - Repository의 findAll 메서드를 호출하여 리스트를 리턴받음.
        List<StudentDTO> studentDTOList = studentRepository.findAll();
        for (StudentDTO studentDTO: studentDTOList) {
            System.out.println("studentDTO = " + studentDTO);
        }
//        for (int i=0; i<studentDTOList.size(); i++) {
//            System.out.println(studentDTOList.get(i));
//        }
    }

    public void findById() {
        findAll();
        System.out.print("찾을 학생 아이디 입력바람>");
        long id = scanner.nextLong();
        StudentDTO studentDTO = studentRepository.findById(id);
        if(studentDTO==null){
            System.out.println("없는 정보입니다.");
        }else {
            System.out.println("조회학생 정보: " + studentDTO);
        }
    }

    public void deleteById(){
        System.out.print("삭제할 아이디 입력바람>");
        long id = scanner.nextLong();
        studentRepository.deleteByID(id);
    }

    public void update(){
        System.out.println("수정할 아이디 입력바람>");
        long id = scanner.nextLong();
        StudentDTO studentDTO = studentRepository.findById(id);
        if(studentDTO==null){
            System.out.println("없는 정보입니다.");
        }else {
            System.out.print("수정할 번호입력바람>");
            String phone = scanner.next();
            studentRepository.update(id, phone);
        }
    }
}