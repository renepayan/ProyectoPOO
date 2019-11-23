/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

/**
 *
 * @author Palacios Lugo Alan Yoltic                     
           Payan Tellez Rene 
           Zepeta Rivera José Antonio 

 */
public interface Archivo {
    public String leer();
    public String leer(String path);
    public void escribir();
    public void escribir(String path, String contenido);

}
