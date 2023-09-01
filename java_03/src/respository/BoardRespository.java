package respository;

import dto.BoardDTO;

import java.util.*;

public class BoardRespository {
    private List<BoardDTO> list = new ArrayList<>();

    public boolean insert(BoardDTO boardDTO) {
        return list.add(boardDTO);
    }


    public List<BoardDTO> list() {
        return list;
    }

    public BoardDTO delete(int id) {
        for (BoardDTO boardDTO: list) {
            if(boardDTO.getId()==id){
                list.remove(boardDTO);
                return boardDTO;
            }
        }return null;
    }
    public BoardDTO read(int id) {
        for (BoardDTO boardDTO : list) {
            if (boardDTO.getId() == id) {
                boardDTO.setJo(boardDTO.getJo() + 1);
                return boardDTO;
            }
        }
        return null;
    }

    public int find(int id, String pw) {
        for (BoardDTO boardDTO : list) {
            if (boardDTO.getId() == id) {
                if (boardDTO.getBoardPass().equals(pw)) {
                    return 2;
                }
                return 1;
            }
        }
        return 0;
    }

    public BoardDTO update(int id, String title, String contents) {
        for (BoardDTO boardDTO : list) {
            if (boardDTO.getId() == id) {
                boardDTO.setBoardTitle(title);
                boardDTO.setBoardContents(contents);
                return boardDTO;
            }
        }
        return null;
    }


    public void search(String title) {
        for (BoardDTO dto: list) {
            if(dto.getBoardTitle().equals(title)){
                System.out.println(dto.toString());
            }
        }
    }
}
