package respository;

import dto.AccountDTO;
import dto.ClientDTO;

import java.util.ArrayList;
import java.util.List;

public class BankRespository {

    private ClientDTO clientDTO = new ClientDTO();
    private List<ClientDTO> clientDTOList = new ArrayList<>();
    private List<AccountDTO> dlist = new ArrayList<>();
    private List<AccountDTO> wlist = new ArrayList<>();
    private List<AccountDTO> alist = new ArrayList<>();

    public ClientDTO findId(String account) {
        for (ClientDTO clientDTO: clientDTOList) {
            if(clientDTO.getClientName().equals(account)){
                return clientDTO;
            }
        }return null;
    }

    public boolean save(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    public List<ClientDTO> findAll() {
        return clientDTOList;
    }

    public ClientDTO findPw(String pw) {
        for (ClientDTO clientDTO: clientDTOList) {
            if(clientDTO.getClientPass().equals(pw)){
                return clientDTO;
            }
        }return null;
    }

    public boolean desave(AccountDTO accountDTO) {
        return dlist.add(accountDTO);
    }

    public List<AccountDTO> delist() {
        return dlist;
    }

    public boolean wisave(AccountDTO accountDTO) {
        return wlist.add(accountDTO);
    }
    public boolean asave(AccountDTO accountDTO) {
        return alist.add(accountDTO);
    }
    public List<AccountDTO> wlist() {
        return wlist;
    }

    public List<AccountDTO> alist() {
        return alist;
    }
}
