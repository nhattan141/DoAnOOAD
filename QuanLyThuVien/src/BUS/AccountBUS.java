/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author Lộc
 */
import DAO.AccountDAO;
import DTO.AccountDTO;
import java.util.ArrayList;
import java.util.Arrays;

public class AccountBUS {
    private ArrayList<AccountDTO> listAccount;
    
    public AccountBUS(){
    
    }
    
    public void listAccount() throws Exception{
        AccountDAO accountdao=new AccountDAO();
        listAccount=new ArrayList<AccountDTO>();
        listAccount=accountdao.list();
    }
    
    public void Add(AccountDTO act) throws Exception {
        listAccount.add(act);
        AccountDAO actdao=new AccountDAO();
        actdao.Insert(act);
    }
    
    public void Edit(AccountDTO act) throws Exception {
        for(int i=0;i<listAccount.size();i++) {
            if(listAccount.get(i).getUsername().equals(act.getUsername())) {
                listAccount.set(i, act);
                AccountDAO actdao = new AccountDAO();
                actdao.Update(act);
                return;
            }
        }
    }
    
    public void Remove(String username) throws Exception {
        for(AccountDTO act: listAccount) {
            if(act.getUsername().equals(username)) {
                listAccount.remove(act);
                AccountDAO actdao = new AccountDAO();
                actdao.Delete(username);
                return;
            }
        }
    }
    
    public ArrayList<AccountDTO> Search(String username, String password){
        ArrayList<AccountDTO> res=new ArrayList<AccountDTO>();
        boolean user=false, pass=false;
        if(username.equals(""))
            user=true;
        if(password.equals(""))
            pass=true;
        for(AccountDTO act: listAccount){
            if(!username.equals(""))
                user=(act.getUsername().contains(username)) ? true : false;
            if(!password.equals(""))
                pass=(act.getPassword().contains(password)) ? true : false;
            if(user && pass)
                res.add(act);
        }
        return res;
    }
    
    public ArrayList<AccountDTO> getList(){
        return listAccount;
    }
    
    public AccountDTO Check(String username, char[] password){
        for(AccountDTO account: listAccount){
            char[] correctPass=account.getPassword().toCharArray();
            if(account.getUsername().equals(username) && Arrays.equals(password, correctPass))
                return account;
        }
        return null;
    }
}
