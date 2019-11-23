package Persistencia;


import Logica.Estadistica;
import Logica.Estadistica;
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
public class EstadisticaDB {
    public Estadistica getEstadisticaById(int id){
        Estadistica estadistica = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Estadistica WHERE id  = ? LIMIT 1");
            preparedStmt.setInt(1,id);
            ResultSet rs = preparedStmt.executeQuery();           
            if(rs.next()){
                estadistica = new Estadistica(
                    //rs.getString("Calificacion"),
                    
                    //premios
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return estadistica;
    }
    public int addEstadistica(Estadistica estadistica){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO Estadistica(Calificacion) VALUES (?)");
            preparedStmt.setString(1,estadistica.getCalificacion());
            if(!preparedStmt.execute()){
                retorno = -1;
            }                        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return retorno;
    }   
    public int updateEstadistica(Estadistica estadistica){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("UPDATE Estadistica SET Calificacion = ? WHERE id = ?");
            preparedStmt.setString(1,estadistica.getCalificacion());
            preparedStmt.setInt(2,estadistica.getId());                         
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
