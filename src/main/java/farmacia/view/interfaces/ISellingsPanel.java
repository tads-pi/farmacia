/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.interfaces;

/**
 *
 * @author kcalixto
 */
public interface ISellingsPanel {
    public static final byte STEP_GET_CPF = 0;
    public static final byte STEP_SHOW_CPF = 1;
    public static final byte STEP_CPF_REGISTER = 2;
    public static final byte STEP_CONFIRM_CPF_DATA = 3;
    public static final byte STEP_SELLINGS = 4;
    public static final byte STEP_CONFIRM_SELLING = 5;
    public static final byte STEP_CANCEL_SELLING = 6;
    
    void confirmPressed(byte newStep);
    void cancelPressed(byte newStep);
}
