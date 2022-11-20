/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs;

import farmacia.view.interfaces.ISellingsPanel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Objeto que armazena fluxo de passos do usuário, permitindo navegar entre
 * steps que já passou
 * 
 * @author kcalixto
 */
public class StepsTrace implements ISellingsPanel {
    private static ArrayList<Integer> arr = new ArrayList<Integer>();

    private static final Map<Integer, String> STEPS = new LinkedHashMap<>();
    static {
        STEPS.put(STEP_GET_CPF, "getCpf");
        STEPS.put(STEP_SHOW_CPF, "showCpf");
        STEPS.put(STEP_CPF_REGISTER, "registerCpf");
        STEPS.put(STEP_SELLINGS, "sellings");
        STEPS.put(STEP_CONFIRM_SELLING, "confirmSelling");
        STEPS.put(STEP_CANCEL_SELLING, "cancelSelling");
        STEPS.put(LAST_STEP, "last_step");
    };

    /**
     * Adicionar step
     * 
     * @param STEP
     */
    public void add(int STEP) {
        StepsTrace.arr.add(STEP);
    }

    /**
     * @param STEP
     * @return tamanho da array de steps
     */
    public int size() {
        return StepsTrace.arr.size();
    }

    /**
     * 
     * @return step anterior
     */
    public int getLastStep() {
        System.out.println("todos os steps até o momento: \n");
        for (int s : StepsTrace.arr) {
            System.out.print(STEPS.get(s) + ", ");
        }
        System.out.println("last_step: " + STEPS.get(StepsTrace.arr.get(StepsTrace.arr.size() - 2)));
        return StepsTrace.arr.get(StepsTrace.arr.size() - 2);
    }

    @Override
    public void confirmPressed(int newStep) {
    }

    @Override
    public void cancelPressed(int newStep) {
    }
}
