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
public class DAO {
    public static MyConnectUnit getDAO(){
        return new MyConnectUnit("localhost", "root", "", "quanlythuvien?useUnicode=yes&characterEncoding=UTF8");
    }
}
