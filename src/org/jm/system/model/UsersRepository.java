/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jm.system.model;

/**
 *
 * @author informatica
 */
import java.sql.CallableStatement;
import org.jm.system.config.ConexionDB;
import org.jm.system.model.UsersInterface;
public class UsersRepository implements UsersInterface{
    
    //CallebStatement
    private CallableStatement callSP;
    //ConexionDB
    private ConexionDB conexionDB  = ConexionDB.getInstanciaConexionDB();
    
    @Override
    public void create(Users user){
        try {
            callSP = conexionDB.getConnection().prepareCall("{call_sp_create_users(?,?,?,?,?)}");
            callSP.setString(1, user.getName());
            callSP.setString(2, user.getLastname());
            callSP.setString(3, user.getEmail());
            callSP.setString(4, user.getUser());
            callSP.setString(5, user.getPassword());
            
            callSP.execute();
            callSP.close();
        } catch (Exception e) {
        }
    }
}
