/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Lộc
 */
import DTO.AccountDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class AccountDAO {
    MyConnectUnit connect;
    
    public AccountDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<AccountDTO> list(String condition, String OrderBy) throws Exception {
        ResultSet result=this.connect.Select("account", condition, OrderBy);
        ArrayList<AccountDTO> listAccount=new ArrayList<AccountDTO>();
        while(result.next()){
            AccountDTO account=new AccountDTO();
            account.setUsername(result.getString("username"));
            account.setPassword(result.getString("password"));
            listAccount.add(account);
        }
        return listAccount;
    }
    
    public ArrayList<AccountDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<AccountDTO> list() throws Exception{
        return list(null);
    }
    
    public void Insert(AccountDTO act) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("username", act.getUsername());
        map.put("password", act.getPassword());
        this.connect.Insert("account", map);
    }
    
    public void Update(AccountDTO act) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("username", act.getUsername());
        map.put("password", act.getPassword());
        this.connect.Update("account", map, "username = '" + act.getUsername() + "'");
    }
    
    public void Delete(String username) throws Exception{
        this.connect.Delete("account", "username = '" + username + "'" );    
    }
    
}
