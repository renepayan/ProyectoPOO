package Persistencia;


import Logica.Editorial;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author payan
 */
public class EditorialDB {
    public Editorial getEditorialByName(String nombre){
        Editorial editorial = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Editorial WHERE nombre  = ? LIMIT 1");
            preparedStmt.setString(1,nombre);
            ResultSet rs = preparedStmt.executeQuery();           
            if(rs.next()){
                editorial = new Editorial(
                    rs.getString("Nombre"),
                    rs.getString("Pais")                    
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return editorial;
    }
    public int addEditorial(Editorial editorial){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO Editorial(Nombre,Pais) VALUES (?,?)");
            preparedStmt.setString(1,editorial.getNombre());
            preparedStmt.setString(2,editorial.getPais());
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
