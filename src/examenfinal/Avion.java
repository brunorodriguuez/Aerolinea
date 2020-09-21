/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinal;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Avion {
    private int idavion;
    private String nombre;
    private ArrayList <Mantenimiento> arrayMantenimiento = new ArrayList<>();


    public Avion(int idavion, String nombre) {
        this.idavion = idavion;
        this.nombre = nombre;
    }
    

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int idavion) {
        this.idavion = idavion;
    }


    public Avion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Mantenimiento> getArrayMantenimiento() {
        return arrayMantenimiento;
    }

    public void setArrayMantenimiento(ArrayList<Mantenimiento> arrayMantenimiento) {
        this.arrayMantenimiento = arrayMantenimiento;
    }

    @Override
    public String toString() {
        return "Avion{" + "idavion=" + idavion + ", nombre=" + nombre + '}';
    }

    
    public void Guardar() throws ClassNotFoundException, SQLException{
        DBConection db = new DBConection();
        db.st.execute("INSERT INTO Avion (Nombre) VALUES ('"+getNombre()+"')");
        db.st.close();
        db.con.close();
    }
    
    public void GuardarAvionMantenimiento() throws ClassNotFoundException, SQLException{
        DBConection db = new DBConection();
        for(Mantenimiento m : arrayMantenimiento){ 
            m.Guardar();
        } 
        db.st.close();
        db.con.close();    
    }
}
