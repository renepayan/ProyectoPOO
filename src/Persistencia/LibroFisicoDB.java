package Persistencia;


import Logica.LibroFisico;
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
public class LibroFisicoDB {
    public LibroFisico getLibroFisicoByName(String isbn){
        LibroFisico libroFisico = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM LibroFisico WHERE Libro  = ? LIMIT 1");
            preparedStmt.setString(1,isbn);
            ResultSet rs = preparedStmt.executeQuery();           
            LibroDB ldb = new LibroDB();
            if(rs.next()){
                libroFisico = new LibroFisico(
                    ldb.getLibroByIsbn(isbn),
                    rs.getString("LugarPublicacion"),
                    rs.getString("NivelDeterioro")
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return libroFisico;
    }
    public int addLibroFisico(LibroFisico libroFisico){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO LibroFisico(Libro,LugarPublicacion ,NivelDeterioro) VALUES (?,?,?)");
            preparedStmt.setString(1,libroFisico.getIsbn());
            preparedStmt.setString(2,libroFisico.getLugarDePublicacion());
            preparedStmt.setString(3,libroFisico.getNivelDeterioro());
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
