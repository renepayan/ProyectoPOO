package Persistencia;


import Logica.Ilustrador;
import Logica.Miniatura;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author payan
 */
public class IlustradorDB {
    public Ilustrador getIlustradorByName(String nombre){
        Ilustrador ilustrador = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Ilustrador WHERE Nombre  = ? LIMIT 1");
            preparedStmt.setString(1,nombre);
            ResultSet rs = preparedStmt.executeQuery();           
            if(rs.next()){
                ilustrador = new Ilustrador(
                    rs.getString("Nombre")
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return ilustrador;
    }
    
    public List<Ilustrador> getIlustradoresBySearch(String search){
        List<Ilustrador> ilustradores = new ArrayList<Ilustrador>();
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Ilustrador WHERE Nombre LIKE ? ");            
            preparedStmt.setString(1,"%"+search+"%");
            ResultSet rs = preparedStmt.executeQuery();           
            while(rs.next()){
                ilustradores.add(new Ilustrador(
                        rs.getString("Nombre")
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return ilustradores;
    }
    
    public List<Ilustrador> getIlustradores(){
        List<Ilustrador> ilustradores = new ArrayList<Ilustrador>();
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Ilustrador");            
            ResultSet rs = preparedStmt.executeQuery();           
            while(rs.next()){
                ilustradores.add(new Ilustrador(
                    rs.getString("Nombre")                    
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return ilustradores;
    }
    public int addIlustrador(Ilustrador ilustrador){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO Ilustrador(Nombre) VALUES (?)");
            preparedStmt.setString(1,ilustrador.getNombre());
            if(!preparedStmt.execute()){
                retorno = -1;
            }                        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return retorno;
    }   

}
