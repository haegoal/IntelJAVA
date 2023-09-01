package dto;

public class AccountDTO{
    private Long id;
    private String accountNumber;
    private int deposit;
    private long withdraw;
    private String bankingAt;
    private static long num = 1L;



    public AccountDTO() {
    }

    public AccountDTO(String account, int money) {
        this.id = num++;
        this.accountNumber = account;
        this.deposit = money;
    }

    public AccountDTO(String account, long money) {
        this.id = num++;
        this.accountNumber = account;
        this.withdraw = money;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }



    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    public String getBankingAt() {
        return bankingAt;
    }

    public void setBankingAt(String bankingAt) {
        this.bankingAt = bankingAt;
    }

    public static long getNum() {
        return num;
    }

    public static void setNum(long num) {
        AccountDTO.num = num;
    }

    public long getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(long withdraw) {
        this.withdraw = withdraw;
    }


    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", bankingAt='" + bankingAt + '\'' +
                '}';
    }


}
