package Persistencia;


import Logica.GeneroLiterario;
import Logica.Libro;
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
public class GeneroLiterarioDB {
    public GeneroLiterario getGeneroLiterarioByName(String nombre){
        GeneroLiterario generoLiterario = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM GeneroLiterario WHERE Nombre  = ? LIMIT 1");
            preparedStmt.setString(1,nombre);
            ResultSet rs = preparedStmt.executeQuery();           
            if(rs.next()){
                generoLiterario = new GeneroLiterario(
                    rs.getString("Nombre")
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return generoLiterario;
    }
    public int addGeneroLiterario(GeneroLiterario generoLiterario){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO GeneroLiterario(Nombre) VALUES (?)");
            preparedStmt.setString(1,generoLiterario.getNombre());
            if(!preparedStmt.execute()){
                retorno = -1;
            }                        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return retorno;
    }   
    public int linkGeneroToLibro(GeneroLiterario generoLiterario, Libro libro){
        int retorno = 0;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO GeneroLibro(Genero, Libro) VALUES (?,?)");
            preparedStmt.setString(1, generoLiterario.getNombre());
            preparedStmt.setString(2, libro.getIsbn());
            if(!preparedStmt.execute()){
                retorno = -1;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return retorno;
    }
    public List<GeneroLiterario> getGeneros(){
        List<GeneroLiterario> generos = new ArrayList<GeneroLiterario>();
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM GeneroLiterario");
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                generos.add(new GeneroLiterario(
                        rs.getString("Nombre")
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return generos;
    }
    public List<GeneroLiterario> getGenerosByLibro(Libro libro){
        List<GeneroLiterario> generos = new ArrayList<GeneroLiterario>();
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM GeneroLiterario WHERE id IN (SELECT Genero FROM GeneroLibro WHERE Libro = ?)");
            preparedStmt.setString(1,libro.getIsbn());
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                generos.add(new GeneroLiterario(
                        rs.getString("Nombre")
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return generos;
    }
     public List<GeneroLiterario> getGenerosByISBN(String ISBN){
        List<GeneroLiterario> generos = new ArrayList<GeneroLiterario>();
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM GeneroLiterario WHERE id IN (SELECT Genero FROM GeneroLibro WHERE Libro = ?)");
            preparedStmt.setString(1,ISBN);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                generos.add(new GeneroLiterario(
                        rs.getString("Nombre")
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return generos;
    }
}
