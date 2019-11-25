package Persistencia;


import Logica.Autor;
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
public class AutorDB {
    public Autor getAutorByName(String nombre){
        Autor autor = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Autor WHERE Nombre  = ? LIMIT 1");
            preparedStmt.setString(1,nombre);
            ResultSet rs = preparedStmt.executeQuery();           
            if(rs.next()){
                autor = new Autor(
                    rs.getString("Nombre"),
                    rs.getString("Nacionalidad"),
                    rs.getString("FechaNacimiento")
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return autor;
    }
    
    public List<Autor> getAutoresBySearch(String search){
        List<Autor> autores = new ArrayList<Autor>();
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Autor WHERE Nombre LIKE ? ");            
            preparedStmt.setString(1,"%"+search+"%");
            ResultSet rs = preparedStmt.executeQuery();           
            while(rs.next()){
                autores.add(new Autor(rs.getString("Nombre"),
                    rs.getString("Nacionalidad"),
                    rs.getString("FechaNacimiento")
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return autores;
    }
    
    public List<Autor> getAutores(){
        List<Autor> autores = new ArrayList<Autor>();
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Autor");            
            ResultSet rs = preparedStmt.executeQuery();           
            while(rs.next()){
                autores.add(new Autor(
                    rs.getString("Nombre"),
                    rs.getString("Nacionalidad"),
                    rs.getString("FechaNacimiento")
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return autores;
    }
    public int addAutor(Autor autor){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO Autor(Nombre, Nacionalidad, FechaNacimiento) VALUES (?,?,?)");
            preparedStmt.setString(1,autor.getNombre());
            preparedStmt.setString(2,autor.getNacionalidad());
            preparedStmt.setString(3,autor.getFechaNacimiento());
            if(!preparedStmt.execute()){
                retorno = -1;
            }                        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return retorno;
    }   
    public int updateAutor(Autor autor){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("UPDATE Autor SET Nombre = ?, Nacionalidad = ?, FechaNacimiento = ? WHERE Nombre = ?");
            preparedStmt.setString(1,autor.getNombre());
            preparedStmt.setString(2, autor.getNacionalidad());             
            preparedStmt.setString(3, autor.getFechaNacimiento());
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
