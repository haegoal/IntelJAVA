package dto;

public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardWrite;
    private String boardContents;
    private String boardPass;
    private int jo;

    public static long num = 1L;

    public BoardDTO() {
    }

    public BoardDTO(String title, String writer, String contents, String pw) {
        this.id = num++;
        this.boardTitle = title;
        this.boardWrite = writer;
        this.boardContents = contents;
        this.boardPass = pw;
    }

    public int getJo() {
        return jo;
    }

    public void setJo(int jo) {
        this.jo = jo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardWrite() {
        return boardWrite;
    }

    public void setBoardWrite(String boardWrite) {
        this.boardWrite = boardWrite;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public String getBoardPass() {
        return boardPass;
    }

    public void setBoardPass(String boardPass) {
        this.boardPass = boardPass;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardWrite='" + boardWrite + '\'' +
                ", boardContents='" + boardContents + '\'' +
                ", boardPass='" + boardPass + '\'' +
                ", jo=" + jo +
                '}';
    }
}
