/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Libro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author payan
 */
public class LibroDB {
   public Libro getLibroByIsbn(String ISBN){
        Libro libro = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Libro WHERE ISBN  = ? LIMIT 1");
            preparedStmt.setString(1,ISBN);
            ResultSet rs = preparedStmt.executeQuery();           
            if(rs.next()){
                libro = new Libro(
                        rs.getString("Titulo"),
                        rs.getInt("AnioPublicacion"),
                        ISBN,
                        rs.getString("Edicion"),
                        rs.getString("Volumen"),
                        rs.getString("Idioma")
                );
                MiniaturaDB mdb = new MiniaturaDB();
                libro.setPortada(mdb.getMiniaturaById(rs.getInt("Portada")));
                libro.setContraPortada(mdb.getMiniaturaById(rs.getInt("ContraPortada")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return libro;
    }
   public int addLibro(Libro libro){
       int retorno = 0;
       Conexion conexion = new Conexion();
       try{
           PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO Libro (Titulo, AnioPublicacion, Edicion, Volumen, Idioma, Portada, ContraPortada, Editorial, Estadistica,ISBN) VALUES (?,?,?,?,?,?,?,?,?,?)");
           preparedStmt.setString(1,libro.getTitulo());
           preparedStmt.setInt(2, libro.getAnioDePublicacion());
           preparedStmt.setString(3, libro.getEdicion());
           preparedStmt.setString(4,libro.getVolumen());
           preparedStmt.setString(5, libro.getIdioma());
           if(libro.getPortada() != null){
                preparedStmt.setInt(6, libro.getPortada().getId());
           }else{               
                preparedStmt.setNull(6, java.sql.Types.INTEGER);
           }
           if(libro.getPortada() != null){
                preparedStmt.setInt(7, libro.getContraPortada().getId());
           }else{
                preparedStmt.setNull(7, java.sql.Types.INTEGER);
           }
           
           preparedStmt.setString(8, libro.getEditorial().getNombre());
           preparedStmt.setInt(9, libro.getEstadistica().getId());
           preparedStmt.setString(10, libro.getIsbn());
           if(!preparedStmt.execute())retorno = -1;
       }catch(SQLException ex){
           retorno = -1;
           ex.printStackTrace();
       }           
       conexion.cerrar();
       return retorno;
   }
   public int updateLibro(Libro libro){
       int retorno = 0;
       Conexion conexion = new Conexion();
       try{
           PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("UPDATE Libro SET Titulo = ?, AnioPublicacion = ?, Edicion = ?, Volumen = ?, Idioma = ?, Portada = ?, ContraPortada = ?, Editorial = ?, Estadistica = ? WHERE ISBN = ? LIMIT 1");
           preparedStmt.setString(1,libro.getTitulo());
           preparedStmt.setInt(2, libro.getAnioDePublicacion());
           preparedStmt.setString(3, libro.getEdicion());
           preparedStmt.setString(4,libro.getVolumen());
           preparedStmt.setString(5, libro.getIdioma());
           preparedStmt.setInt(5, libro.getPortada().getId());
           preparedStmt.setInt(6, libro.getContraPortada().getId());
           preparedStmt.setString(7, libro.getEditorial().getNombre());
           preparedStmt.setInt(8, libro.getEstadistica().getId());
           preparedStmt.setString(9, libro.getIsbn());
           if(!preparedStmt.execute())retorno = -1;
       }catch(SQLException ex){
           retorno = -1;
           ex.printStackTrace();
       }           
       conexion.cerrar();
       
       return retorno;
   }
    
}
