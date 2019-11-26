package Persistencia;


import Logica.GeneroLiterario;
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
public class LibroElectronicoDB {
    public LibroElectronico getLibroElectronicoByName(String isbn){
        LibroElectronico libroElectronico = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Libro AS L INNER JOIN LibroElectronico AS LE ON LE.Libro = L.ISBN WHERE LE.Libro  = ? LIMIT 1");
            preparedStmt.setString(1,isbn);
            ResultSet rs = preparedStmt.executeQuery();                       
            if(rs.next()){
                List<GeneroLiterario> generos = new GeneroLiterarioDB().getGenerosByISBN(rs.getString("ISBN"));
                GeneroLiterario[] generosarr = new GeneroLiterario[generos.size()];      
                int i = 0;
                for(GeneroLiterario gl: generos){
                    generosarr[i++] = gl;
                }
                libroElectronico = new LibroElectronico(
                    rs.getString("Ubicacion"),
                    rs.getString("Extension"),
                    rs.getFloat("Tamanio"),
                    rs.getString("Titulo"),                    
                    rs.getInt("AnioPublicacion"),
                    rs.getString("ISBN"),
                    new AutorDB().getAutorByName(rs.getString("Autor")),
                    new IlustradorDB().getIlustradorByName(rs.getString("Ilustrador")),
                    new TraductorDB().getTraductorByName(rs.getString("Traductor")),
                    rs.getString("Edicion"),
                    rs.getString("Volumen"),
                    rs.getString("Idioma"),
                    new MiniaturaDB().getMiniaturaById(rs.getInt("Portada")),
                    new MiniaturaDB().getMiniaturaById(rs.getInt("ContraPortada")),
                    new EditorialDB().getEditorialByName(rs.getString("Editorial")),
                    new EstadisticaDB().getEstadisticaById(rs.getInt("Estadistica")),
                    generosarr);                
                
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
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO Libro (Titulo, AnioPublicacion, Edicion, Volumen, Idioma, Portada, ContraPortada, Editorial, Estadistica,ISBN) VALUES (?,?,?,?,?,?,?,?,?,?)");
            preparedStmt.setString(1,libroElectronico.getTitulo());
            preparedStmt.setInt(2, libroElectronico.getAnioDePublicacion());
            preparedStmt.setString(3, libroElectronico.getEdicion());
            preparedStmt.setString(4,libroElectronico.getVolumen());
            preparedStmt.setString(5, libroElectronico.getIdioma());
            if(libroElectronico.getPortada() != null){
                 preparedStmt.setInt(6, libroElectronico.getPortada().getId());
            }else{               
                 preparedStmt.setNull(6, java.sql.Types.INTEGER);
            }
            if(libroElectronico.getPortada() != null){
                 preparedStmt.setInt(7, libroElectronico.getContraPortada().getId());
            }else{
                 preparedStmt.setNull(7, java.sql.Types.INTEGER);
            }

            preparedStmt.setString(8, libroElectronico.getEditorial().getNombre());
            preparedStmt.setInt(9, libroElectronico.getEstadistica().getId());
            preparedStmt.setString(10, libroElectronico.getIsbn());
            if(!preparedStmt.execute()){
                retorno = -1;
            }else{
                preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO LibroElectronico(Libro,Ubicacion ,Extension, Tamanio) VALUES (?,?,?,?)");
                preparedStmt.setString(1,libroElectronico.getIsbn());
                preparedStmt.setString(2,libroElectronico.getUbicacion());
                preparedStmt.setString(3,libroElectronico.getExtension());
                preparedStmt.setFloat(4,libroElectronico.getTamanio());
                if(!preparedStmt.execute()){
                    retorno = -1;
                }                                    
            }            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conexion.cerrar();
        return retorno;
    }   
}
