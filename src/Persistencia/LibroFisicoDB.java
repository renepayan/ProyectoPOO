package Persistencia;


import Logica.GeneroLiterario;
import Logica.LibroFisico;
import Logica.LibroFisicoOld;
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
public class LibroFisicoDB {
    public LibroFisicoOld getLibroFisicoByName(String isbn){
        LibroFisicoOld libroFisico = null;
        Conexion conexion = new Conexion();
        try{
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("SELECT * FROM Libro AS L INNER JOIN LibroFisico AS LF ON LF.Libro = L.ISBN WHERE LF.Libro  = ? LIMIT 1");
            preparedStmt.setString(1,isbn);
            ResultSet rs = preparedStmt.executeQuery();           
            LibroDB ldb = new LibroDB();
            if(rs.next()){
                List<GeneroLiterario> generos = new GeneroLiterarioDB().getGenerosByISBN(rs.getString("ISBN"));
                GeneroLiterario[] generosarr = new GeneroLiterario[generos.size()];      
                int i = 0;
                for(GeneroLiterario gl: generos){
                    generosarr[i++] = gl;
                }
                libroFisico = new LibroFisico(
                    rs.getString("LugarPublicacion"),
                    rs.getString("NivelDeterioro"),
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
                    generosarr
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
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO Libro (Titulo, AnioPublicacion, Edicion, Volumen, Idioma, Portada, ContraPortada, Editorial, Estadistica,ISBN) VALUES (?,?,?,?,?,?,?,?,?,?)");
            preparedStmt.setString(1,libroFisico.getTitulo());
            preparedStmt.setInt(2, libroFisico.getAnioDePublicacion());
            preparedStmt.setString(3, libroFisico.getEdicion());
            preparedStmt.setString(4,libroFisico.getVolumen());
            preparedStmt.setString(5, libroFisico.getIdioma());
            if(libroFisico.getPortada() != null){
                 preparedStmt.setInt(6, libroFisico.getPortada().getId());
            }else{               
                 preparedStmt.setNull(6, java.sql.Types.INTEGER);
            }
            if(libroFisico.getPortada() != null){
                 preparedStmt.setInt(7, libroFisico.getContraPortada().getId());
            }else{
                 preparedStmt.setNull(7, java.sql.Types.INTEGER);
            }

            preparedStmt.setString(8, libroFisico.getEditorial().getNombre());
            preparedStmt.setInt(9, libroFisico.getEstadistica().getId());
            preparedStmt.setString(10, libroFisico.getIsbn());
            if(!preparedStmt.execute()){
                retorno = -1;
            }else{
                preparedStmt = conexion.getConnection().prepareStatement("INSERT INTO LibroFisico(Libro,LugarPublicacion ,NivelDeterioro) VALUES (?,?,?)");
                preparedStmt.setString(1,libroFisico.getIsbn());
                preparedStmt.setString(2,libroFisico.getLugarDePublicacion());
                preparedStmt.setString(3,libroFisico.getNivelDeterioro());
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
