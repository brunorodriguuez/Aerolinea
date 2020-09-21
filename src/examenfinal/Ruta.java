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
public class Ruta {
    
    private int idruta;
    private String origen;
    private String destino;

    public Ruta(int idruta, String origen, String destino) {
        this.idruta = idruta;
        this.origen = origen;
        this.destino = destino;
    }

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    public Ruta() {
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Ruta{" + "idruta=" + idruta + ", origen=" + origen + ", destino=" + destino + '}';
    }

    
    public void Guardar() throws ClassNotFoundException, SQLException{
        DBConection db = new DBConection();
        db.st.execute("INSERT INTO Ruta (Origen, Destino) VALUES ('"+getOrigen()+"', '"+getDestino()+"')");
        db.st.close();
        db.con.close();
    }
}
