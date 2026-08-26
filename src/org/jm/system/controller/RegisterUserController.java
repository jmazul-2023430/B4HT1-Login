/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jm.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.jm.system.service.UserService;
import org.jm.system.service.UserStatus;
import org.jm.system.utils.AlertInformation;
import org.jm.system.utils.Validations;
import org.jm.system.utils.ViewFactory;

/**
 *
 * @author informatica
 */
public class RegisterUserController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private PasswordField pwdConfirmPassword;

    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();
    private UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void onCancelRegister(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }

    //Validar el error del correo
    @FXML
    public void onCreateUser(MouseEvent event) {
        boolean isValidEmail = validate.validateEmail(txtEmail.getText().trim());
        if (isValidEmail == false) {
            alertInfo.viewAlert(3, "ERROR EMAIL", "ERROR DE CAMPO", "HAS INGRESADO UN EMAIL INCORRECTO");
        }

        String user, name, lastName, email, password, confirmPassword;
        user = txtUser.getText().trim();
        name = txtName.getText().trim();
        lastName = txtLastName.getText().trim();
        email = txtEmail.getText().trim();
        password = pwdPassword.getText().trim();
        confirmPassword = pwdConfirmPassword.getText().trim();

        if (validate.emptyText(user) == true
                || validate.emptyText(name) == true
                || validate.emptyText(lastName) == true
                || validate.emptyText(email) == true
                || validate.emptyText(confirmPassword) == true
                || validate.emptyText(confirmPassword) == true) {

            alertInfo.viewAlert(3, "ERROR DE CAMNPOS VACIOS", "ERROR DE CAMPO", "DEJO CAMPOS VACIOS EN EL FORMULARIO");
            return;
        }
////                validate.validateLengthText(name, 50) ||
//                validate.validateLengthText(lastName, 50) ||
//                validate.validateLengthText(password, 50) ||
//                validate.validateLengthText(confirmPassword, 50)){
//            
//                return;
//        }
//                

        String msgField = "";
        if (validate.validateLengthText(user, 25) == false) {
            msgField = "El campo USUARIO es mayor a 25 caracteres";

        }

        if (validate.validateLengthText(name, 50) == false) {
            msgField = "El campo NOMBRES es mayor a 50 caracteres";

        }

        if (validate.validateLengthText(lastName, 50) == false) {
            msgField = "El campo APELLIDOS es mayor a 50 caracteres";

        }

        if (validate.validateLengthText(email, 50) == false) {
            msgField = "El campo EMAIL es mayor a 50 caracteres";

        }

        if (validate.validateLengthText(password, 35) == false) {
            msgField = "El campo PASSWORD es mayor a 35 caracteres";

        }

        if (msgField.isEmpty() == false) {
            alertInfo.viewAlert(3, "ERROR", "ERROR DE CAMPO", msgField);
        }

        if (validate.equalsText(password, confirmPassword) == false) {
            alertInfo.viewAlert(3, "ERROR DE PASSWORDS", "ERROR", "SUS PASSWORDS NO COINCIDEN");
            return;
        }
        UserStatus status = userService.createUser(user, name, lastName, email, password);
        switch (status) {
            case UserStatus.ERROR_USER_CREATE ->
                        System.out.println("Error al crear en el crtl");
            case UserStatus.USER_CREATED ->
                        System.out.println("Si se creo el usuario");
            case UserStatus.FIELDS_EMPTY ->
                        System.out.println("Los campos no etsan vacios");
            case UserStatus.VALUE_LENGTH_INVALID ->
                        System.out.println("Validar longitud del texto");
            default ->         System.out.println("Error desconocido");
        }
    }
}
