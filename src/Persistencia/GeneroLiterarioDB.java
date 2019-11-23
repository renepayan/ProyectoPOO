package Persistencia;


import Logica.GeneroLiterario;
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
}
