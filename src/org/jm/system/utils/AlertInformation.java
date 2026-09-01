/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jm.system.utils;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 *
 * @author informatica
 */
public class AlertInformation {

    /**
     * Constructor vacío público
     */
    public AlertInformation() {
    }

    /**
     * Muestra una ventana de alerta de JavaFX.
     *
     * @param tipoAlerta  Código numérico para definir el tipo de alerta 
     *                    (1: Información, 2: Advertencia, 3: Error, 4: Confirmación, otro: Ninguno)
     * @param titulo      El título de la ventana de la alerta
     * @param encabezado  El texto del encabezado (puede enviarse null si no se desea mostrar)
     * @param mensaje     El mensaje principal o contenido de la alerta
     */
    public void viewAlert(int tipoAlerta, String titulo, String encabezado, String mensaje) {
        
        // Variable local de tipo AlertType donde se guardará el resultado del switch
        AlertType tipoAlertaFX;

        // Switch para determinar el tipo de alerta a mostrar
        switch (tipoAlerta) {
            case 1:
                tipoAlertaFX = AlertType.INFORMATION;
                break;
            case 2:
                tipoAlertaFX = AlertType.WARNING;
                break;
            case 3:
                tipoAlertaFX = AlertType.ERROR;
                break;
            case 4:
                tipoAlertaFX = AlertType.CONFIRMATION;
                break;
            default:
                tipoAlertaFX = AlertType.NONE;
                break;
        }

        // Se crea la instancia de la alerta usando la variable local
        Alert alert = new Alert(tipoAlertaFX);
        
        // Se configuran los parámetros recibidos
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);

        // Se muestra la alerta y se espera a que el usuario la cierre
        alert.showAndWait();
    }
}