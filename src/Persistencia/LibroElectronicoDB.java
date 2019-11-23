package Persistencia;


import Logica.LibroElectronico;
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
public class LibroElectronicoDB {
    public LibroElectronico getLibroElectronicoByName(String isbn){
        LibroElectronico libroElectronico = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM LibroElectronico WHERE Libro  = ? LIMIT 1");
            preparedStmt.setString(1,isbn);
            ResultSet rs = preparedStmt.executeQuery();           
            LibroDB ldb = new LibroDB();
            if(rs.next()){
                libroElectronico = new LibroElectronico(
                    ldb.getLibroByIsbn(isbn),
                    rs.getString("Ubicacion"),
                    rs.getString("Extension")
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return libroElectronico;
    }
    public int addLibroElectronico(LibroElectronico libroElectronico){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO LibroElectronico(Libro,ubicacion ,extension) VALUES (?,?,?)");
            preparedStmt.setString(1,libroElectronico.getIsbn());
            preparedStmt.setString(2,libroElectronico.getUbicacion());
            preparedStmt.setString(3,libroElectronico.getExtension());
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
