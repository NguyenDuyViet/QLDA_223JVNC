/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.Service;

import java.util.ArrayList;
import shopbandogiadung.Dao.UserDao;
import shopbandogiadung.model.User;

/**
 *
 * @author ADMIN
 */
public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }
    
    public ArrayList<User> getAllUser(){
        return userDao.getAllUser();
    }
    
    public boolean checkLogin(String email, String password){
        return userDao.checkLogin(email,password);
    }
    
    public void addUser(User user){
        userDao.addUser(user);
    }
    
    public User getUserbyuserName(String username){
        return userDao.getUserbyuserName(username);
    }
    
    public boolean checkSingup(String email, String sdt){
        if(!userDao.checkSingup(email, sdt)){
            return false;
        }else{
            return true;
        }
    }
}
