/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.interfaces;

import farmacia.view.entities.User;
import farmacia.view.libs.mysql.dao.UserDAO;

/**
 *
 * @author kcalixto
 */
public interface ISellingsPanel {
    public static final int STEP_GET_CPF = 0;
    public static final int STEP_SHOW_CPF = 1;
    public static final int STEP_CPF_REGISTER = 2;
    public static final int STEP_SELLINGS = 3;
    public static final int STEP_CONFIRM_SELLING = 4;
    public static final int STEP_CANCEL_SELLING = 5;
    
    public static final int LAST_STEP = 9;
    
    public User currentUser = new User();
    public UserDAO userDAO = new UserDAO();
    
    void confirmPressed(int newStep);
    void cancelPressed(int newStep);
}
