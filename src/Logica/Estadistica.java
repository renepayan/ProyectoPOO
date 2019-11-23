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
public class Estadistica {
    private int id;
    private String calificacion;
    private String []premios;

    public Estadistica (){
        id = 1;
        calificacion = "";
        premios = new String[0];
    }

    public Estadistica(int id, String calificacion, String[] premios) {
        this.id = id;
        this.calificacion = calificacion;
        this.premios = premios;
    }
    public Estadistica (Estadistica estadistica){
        id = estadistica.id;
        calificacion = estadistica.calificacion;
        premios = estadistica.premios;
    }

    public void destruir(){
        if(calificacion != null)calificacion = null;
        if(premios != null)premios = null;
        System.gc();
    }   

    @Override
    public String toString(){
        return "Calificacion: "+calificacion+"\n"+
                "Premios: "+premios[0];
    }   
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Estadistica)) return false;
        Estadistica estadistica = (Estadistica) obj;
        return calificacion.equals(estadistica.calificacion) && premios[0].equals(estadistica.premios[0]);
    }   

    void premiar(){
        
    }
    
    void premiar(String premio){
        //premios[0] = premio;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getCalificacion() {
        return calificacion;
    }
}
