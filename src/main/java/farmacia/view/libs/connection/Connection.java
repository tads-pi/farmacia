/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs.connection;

import farmacia.view.entities.User;

/**
 *
 * @author kcalixto
 */
public class Connection {

    public User getUserByCPF(String cpf) {
        if (cpf.equals("valid")) {
            return new User(
                    "Test Name",
                    "teste@teste.com",
                    cpf,
                    "01/01/2000",
                    "(11)93393-8090",
                    "-"
            );
        }

        return new User();
    }
}
