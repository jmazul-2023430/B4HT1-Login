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
        
        if(validate.validateLengthText(user, 25) || 
                validate.validateLengthText(name, 50) ||
                validate.validateLengthText(lastName, 50) ||
                validate.validateLengthText(password, 50) ||
                validate.validateLengthText(confirmPassword, 50)){
            
        }
        
    }

}
