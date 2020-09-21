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


public class Cliente {
    
    private int idcliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList <Factura> arrayFactura = new ArrayList<>();

    public Cliente(int idcliente, String nombre, String direccion, String telefono) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    
    public ArrayList<Factura> getArrayFactura() {
        return arrayFactura;
    }

    public void setArrayFactura(ArrayList<Factura> arrayFactura) {
        this.arrayFactura = arrayFactura;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

    @Override
    public String toString() {
        return "Cliente{" + "idcliente=" + idcliente + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", arrayFactura=" + arrayFactura + '}';
    }


    public void facturacliente(Factura f){
        arrayFactura.add(f);
    }
    
    public void Guardar() throws ClassNotFoundException, SQLException{
        DBConection db = new DBConection();
        db.st.execute("INSERT INTO Cliente (Nombre, Direccion, Telefono) VALUES ('"+getNombre()+"', '"+getDireccion()+"', '"+getTelefono()+"')");
        db.st.close();
        db.con.close();
    }
    
    public void GuardarFacturasCliente() throws ClassNotFoundException, SQLException{
        DBConection db = new DBConection();
        for(Factura f : arrayFactura){ 
            f.Guardar();
        } 
        db.st.close();
        db.con.close();    
    }
}
