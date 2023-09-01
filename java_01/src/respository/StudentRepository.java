package respository;

import dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    // 학생정보를 저장할 리스트
    private List<StudentDTO> studentDTOList = new ArrayList<>();
    private StudentDTO studentDTO = new StudentDTO();

    public boolean save(StudentDTO studentDTO) {
        return studentDTOList.add(studentDTO);
    }

    public List<StudentDTO> findAll() {
        return studentDTOList;
    }

    public StudentDTO findById(long id) {
        for (StudentDTO studentDTO: studentDTOList) {
            if(studentDTO.getId()== id){
                return studentDTO;
            }
        }
        return null;
    }


    public void deleteByID(long id) {
        for (StudentDTO studentDTO: studentDTOList) {
            if(studentDTO.getId()== id){
                studentDTOList.remove(studentDTO);
            }
        }
    }

    public void update(long id, String phone) {
        for (StudentDTO studentDTO: studentDTOList) {
            if (studentDTO.getId() == id) {
                studentDTO.setStudentMobile(phone);
                System.out.println("수정완료");
            }
        }
    }
}