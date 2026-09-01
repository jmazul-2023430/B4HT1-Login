/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jm.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author jeff2
 */
public class MainMenuController implements Initializable {

    @FXML
    private Label lblWelcome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización estándar de la vista
    }

    // Método para transferir la información desde el Login
    public void setWelcomeMessage(String username) {
        lblWelcome.setText("¡Bienvenido, Camarada " + username + "!");
    }
}
