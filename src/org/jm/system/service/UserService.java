/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jm.system.service;

import org.jm.system.model.Users;
import org.jm.system.model.UsersRepository;
import org.jm.system.utils.AlertInformation;
import org.jm.system.utils.Validations;

/**
 *
 * @author informatica
 */
public class UserService {

    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();

    private UsersRepository userRepo = new UsersRepository();

    public UserStatus createUser(String user, String name, String lastName, String email, String password) {

        if (validate.emptyText(user) == true
                || validate.emptyText(name) == true
                || validate.emptyText(lastName) == true
                || validate.emptyText(email) == true
                || validate.emptyText(password) == true) {

            alertInfo.viewAlert(3, "ERROR DE CAMNPOS VACIOS", "ERROR DE CAMPO", "DEJO CAMPOS VACIOS EN EL FORMULARIO");

            return UserStatus.FIELDS_EMPTY;
        }

        try {
            Users newUser = new Users(password, email, name, lastName, user);
            userRepo.create(newUser);
            return UserStatus.USER_CREATED;
        } catch (Exception e) {
            return UserStatus.ERROR_USER_CREATE;
        }
    }
    }

