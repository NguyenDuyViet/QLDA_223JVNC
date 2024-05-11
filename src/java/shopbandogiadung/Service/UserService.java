/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopbandogiadung.Service;

import java.util.ArrayList;
import shopbandogiadung.Dao.UserDao;
import shopbandogiadung.model.TKUser;
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
    
    public void addUser(User user){
        userDao.addUser(user);
    }
    
    public ArrayList<TKUser> getAllTKUser(){
        return userDao.getAllTKUser();
    }
    public User findUser(String username, String password){
        return userDao.findUser(username, password);
    }
}
