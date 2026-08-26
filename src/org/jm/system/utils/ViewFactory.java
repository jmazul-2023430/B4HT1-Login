/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jm.system.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import org.jm.system.ClasePrincipal;

/**
 *
 * @author informatica
 */
public class ViewFactory {

    private final String PATH_VIEWS = "/org/jm/system/view/";

    public ViewFactory() {
    }

    public Scene loadFileFXML(String nameFXML, int width, int height) {
        String pathOfFile = PATH_VIEWS + nameFXML;
        try {
            //FXMLLoader
            FXMLLoader loaderFXML = new FXMLLoader();
            //Leer la ruta del archivo
            URL urlFile = ClasePrincipal.class.getResource(pathOfFile);
            loaderFXML.setBuilderFactory(new JavaFXBuilderFactory());
            loaderFXML.setLocation(urlFile);

            return new Scene(loaderFXML.load(), width, height);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void loadScene(String nameFXML) {

        Scene scene = null;

        try {
            switch (nameFXML) {
                case "login" -> {
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().setTitle("LOGIN DE CAMARADAS");
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().setResizable(false);
                    scene = loadFileFXML("LoginView.fxml", 400, 500);
                }
                case "register" -> {
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().setTitle("REGISTRO DE CAMARADAS");
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().setResizable(false);
                    scene = loadFileFXML("RegisterView.fxml",500,500);
                }
                default ->
                    scene = loadFileFXML("LoginView.fxml", 400, 500);
            }
            SceneManager.getInstanciaSceneManager().changeScene(scene);
        } catch (NullPointerException nullObject) {
            //Alert
            System.out.println("error load scene");
        }
    }

    public void viewLogin() {
        loadScene("login");
    }
    
    public void viewRegister(){
        loadScene("register");
    }
}
