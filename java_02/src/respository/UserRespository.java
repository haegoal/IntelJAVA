package respository;

import dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserRespository {
    private List<UserDTO> userDTOList = new ArrayList<>();
    private UserDTO userDTO = new UserDTO();


    public boolean newID(UserDTO userDTO) {
        return userDTOList.add(userDTO);
    }

    public List<UserDTO> list() {
        return userDTOList;
    }

    public UserDTO login(String email, String pw) {
        for (UserDTO userDTO: userDTOList) {
            if (userDTO.getMemberEmail().equals(email) && userDTO.getMemberPassword().equals(pw)) {
                return userDTO;
            }
        }return null;
    }

    public UserDTO delete(int id, String pw) {
        for (UserDTO userDTO: userDTOList) {
            if (userDTO.getId()==id && userDTO.getMemberPassword().equals(pw)) {
                userDTOList.remove(userDTO);
                return userDTO;
            }
        }return null;
    }

    public UserDTO delete(String pw) {
        for (UserDTO userDTO: userDTOList) {
            if (userDTO.getMemberPassword().equals(pw)) {
                userDTOList.remove(userDTO);
                return userDTO;
            }
        }return null;
    }

    public UserDTO update(String email, String pw) {
        for (UserDTO userDTO: userDTOList) {
            if (userDTO.getMemberEmail().equals(email) && userDTO.getMemberPassword().equals(pw)) {
                return userDTO;
            }
        }return null;
    }

    public UserDTO update(String pw) {
        for (UserDTO userDTO: userDTOList) {
            if (userDTO.getMemberPassword().equals(pw)) {
                return userDTO;
            }
        }return null;
    }

    public UserDTO check(String email) {
        for (UserDTO userDTO: userDTOList) {
            if (userDTO.getMemberEmail().equals(email)) {
                System.out.println("사용중인 이메일입니다.");
                return userDTO;
            }
        }return null;
    }
}
