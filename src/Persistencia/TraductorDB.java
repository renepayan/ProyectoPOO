package Persistencia;


import Logica.Traductor;
import Logica.Miniatura;
import java.util.List;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author payan
 */
public class TraductorDB {
    public Traductor getTraductorByName(String nombre){
        Traductor traductor = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Traductor WHERE Nombre  = ? LIMIT 1");
            preparedStmt.setString(1,nombre);
            ResultSet rs = preparedStmt.executeQuery();           
            if(rs.next()){
                traductor = new Traductor(
                    rs.getString("Nombre"),
                    rs.getString("Nacionalidad")
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return traductor;
    }
    public List<Traductor> getTraductores(){
        List<Traductor> traductores = new ArrayList<Traductor>();
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Traductor");            
            ResultSet rs = preparedStmt.executeQuery();           
            while(rs.next()){
                traductores.add(new Traductor(
                    rs.getString("Nombre"),
                    rs.getString("Nacionalidad")
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return traductores;
    }
    public int addTraductor(Traductor traductor){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO Traductor(Nombre, Nacionalidad) VALUES (?,?)");
            preparedStmt.setString(1,traductor.getNombre());
            preparedStmt.setString(2,traductor.getNacionalidad());
            if(!preparedStmt.execute()){
                retorno = -1;
            }                        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return retorno;
    }   
    public int updateTraductor(Traductor traductor){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("UPDATE Traductor SET Nombre = ?, Nacionalidad = ? WHERE Nombre = ?");
            preparedStmt.setString(1,traductor.getNombre());
            preparedStmt.setString(2, traductor.getNacionalidad());             
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
