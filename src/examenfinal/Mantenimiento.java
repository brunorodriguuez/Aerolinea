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
public class Mantenimiento {
    private int idavion;
    private String fecha;
    private double valor;
    private String descripcion;

    public Mantenimiento(int idavion, String fecha, double valor, String descripcion) {
        this.idavion = idavion;
        this.fecha = fecha;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public Mantenimiento() {
        
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int idavion) {
        this.idavion = idavion;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" + "idavion=" + idavion + ", fecha=" + fecha + ", valor=" + valor + ", descripcion=" + descripcion + '}';
    }
    
    public void Guardar() throws ClassNotFoundException, SQLException{
        DBConection db = new DBConection();
        db.st.execute("INSERT INTO Mantenimiento (Fecha, Valor, Descripcion, IDAvion) VALUES ('"+getFecha()+"', '"+getValor()+"', '"+getDescripcion()+"', '"+getIdavion()+"')");
        db.st.close();
        db.con.close();   
    }
}
