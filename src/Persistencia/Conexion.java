package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author payan
 */
public class Conexion {
    private Connection connection;
    public Conexion(){
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost/gbp";
        try{
            Class.forName(myDriver);
            this.connection = DriverManager.getConnection(myUrl, "root", "m1234des");
        }catch(ClassNotFoundException | SQLException ex){        
            ex.printStackTrace();
        }
    }
    public Connection getConnection(){
        return this.connection;
    }
    public void cerrar(){        
        try {
            this.connection.close();
        } catch (SQLException ex) {
            //poner mamadas de error
        }
    }
}
