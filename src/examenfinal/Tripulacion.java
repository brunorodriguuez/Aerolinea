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
public class Tripulacion {
    
    private int idtripulante;
    private String nombre;
    private double valor_hora;

    public Tripulacion(int idtripulante, String nombre, double valor_hora) {
        this.idtripulante = idtripulante;
        this.nombre = nombre;
        this.valor_hora = valor_hora;
    }

    public Tripulacion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public int getIdtripulante() {
        return idtripulante;
    }

    public void setIdtripulante(int idtripulante) {
        this.idtripulante = idtripulante;
    }

    @Override
    public String toString() {
        return "Tripulacion{" + "idtripulante=" + idtripulante + ", nombre=" + nombre + ", valor_hora=" + valor_hora + '}';
    }
    
    public void Guardar() throws ClassNotFoundException, SQLException{
        DBConection db = new DBConection();
        db.st.execute("INSERT INTO Tripulacion (Nombre, Valor_hora) VALUES ('"+getNombre()+"', '"+getValor_hora()+"')");
        db.st.close();
        db.con.close();
    }
    
}
