/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author bruno
 */
public class Venta {
    private int idventa;
    private String fecha;
    private double montounitario;
    private Viaje viaje;

    public Venta(String fecha, double montounitario, Viaje viaje) {
        this.fecha = fecha;
        this.montounitario = montounitario;
        this.viaje = viaje;
        this.idventa = 0;
    }

    public Venta(int idventa, String fecha, double montounitario, Viaje viaje) {
        this.idventa = idventa;
        this.fecha = fecha;
        this.montounitario = montounitario;
        this.viaje = viaje;
    }
    
 
    public Venta() {
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMontounitario() {
        return montounitario;
    }

    public void setMontounitario(double montounitario) {
        this.montounitario = montounitario;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }    

    @Override
    public String toString() {
        return "Venta{" + "idventa=" + idventa + ", fecha=" + fecha + ", montounitario=" + montounitario + ", viaje=" + viaje + '}';
    }
 
    
}
