/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinal;

import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class Viaje {
    
    private int idviaje;
    private double valorviaje;
    private Tripulacion tripulante;
    private Avion avion;
    private Ruta ruta;
    private String fecha;

    public Viaje(int idviaje, double valorviaje, Tripulacion tripulante, Avion avion, Ruta ruta, String fecha) {
        this.idviaje = idviaje;
        this.valorviaje = valorviaje;
        this.tripulante = tripulante;
        this.avion = avion;
        this.ruta = ruta;
        this.fecha = fecha;
    }
    public Viaje() {

    }

    public int getIdviaje() {
        return idviaje;
    }

    public void setIdviaje(int idviaje) {
        this.idviaje = idviaje;
    }

    public double getValorviaje() {
        return valorviaje;
    }

    public void setValorviaje(double valorviaje) {
        this.valorviaje = valorviaje;
    }

    public Tripulacion getTripulante() {
        return tripulante;
    }

    public void setTripulante(Tripulacion tripulante) {
        this.tripulante = tripulante;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Viaje{" + "idviaje=" + idviaje + ", valorviaje=" + valorviaje + ", tripulante=" + tripulante + ", avion=" + avion + ", ruta=" + ruta + ", fecha=" + fecha + '}';
    }


    public void Guardar() throws ClassNotFoundException, SQLException{
        DBConection db = new DBConection();
        db.st.execute("INSERT INTO Viaje (ValorViaje, IDTripulante, IDAvion, IDRuta, Fecha) VALUES ('"+getValorviaje()+"', '"+getTripulante().getIdtripulante()+"', '"+getAvion().getIdavion()+"', '"+getRuta().getIdruta()+"', '"+getFecha()+"')");
        db.st.close();
        db.con.close();
    }
    
    
}
