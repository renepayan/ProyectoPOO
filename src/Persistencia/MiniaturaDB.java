package Persistencia;


import Logica.Miniatura;
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
public class MiniaturaDB {
    public Miniatura getMiniaturaById(int id){
        Miniatura miniatura = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Miniatura WHERE id  = ? LIMIT 1");
            preparedStmt.setInt(1,id);
            ResultSet rs = preparedStmt.executeQuery();           
            if(rs.next()){
                Blob blob = rs.getBlob("Imagen");                
                miniatura = new Miniatura(
                        rs.getInt("Alto"),
                        rs.getInt("Ancho"),
                        id,
                        blob
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return miniatura;
    }
    public int addMiniatura(Miniatura miniatura){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO Miniatura(Largo, Ancho, Imagen) VALUES (?,?,?)");
            preparedStmt.setInt(1,miniatura.getAlto());
            preparedStmt.setInt(2,miniatura.getAncho());             
            preparedStmt.setBlob(3, miniatura.getImagen());
            if(!preparedStmt.execute()){
                retorno = -1;
            }                        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return retorno;
    }   
    public int updateMiniatura(Miniatura miniatura){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("UPDATE Miniatura SET Largo = ?, Ancho = ?, Imagen = ? WHERE id = ?");
            preparedStmt.setInt(1,miniatura.getAlto());
            preparedStmt.setInt(2,miniatura.getAncho());             
            preparedStmt.setBlob(3, miniatura.getImagen());
            preparedStmt.setInt(4, miniatura.getId());
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
