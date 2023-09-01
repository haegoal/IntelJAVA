package dto;

public class ClientDTO {
    private Long id;
    private long balance;
    private String clientName;
    private String accountNumber;
    private String clientPass;
    private String clientCreatedAt;
    private static long num = 1L;

    public ClientDTO() {
    }

    public ClientDTO(String name, String pw, String account) {
        this.id= num++;
        this.accountNumber=account;
        this.clientName = name;
        this.clientPass = pw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientPass() {
        return clientPass;
    }

    public void setClientPass(String clientPass) {
        this.clientPass = clientPass;
    }

    public String getClientCreatedAt() {
        return clientCreatedAt;
    }

    public void setClientCreatedAt(String clientCreatedAt) {
        this.clientCreatedAt = clientCreatedAt;
    }

    public static long getNum() {
        return num;
    }

    public static void setNum(long num) {
        ClientDTO.num = num;
    }

    public String toBalance() {
        return "balance=" + balance;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", balance=" + balance +
                ", clientName='" + clientName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", clientPass='" + clientPass + '\'' +
                ", clientCreatedAt='" + clientCreatedAt + '\'' +
                '}';
    }
}
