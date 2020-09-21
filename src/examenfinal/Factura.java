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
public class Factura {
    private int idfactura;
    private int idcliente;
    private String metodopago;
    private double montototal;
    private ArrayList <Venta> arrayVenta = new ArrayList<>();

    public Factura(int idfactura, String metodopago, double montototal) {
        this.idfactura = idfactura;
        this.metodopago = metodopago;
        this.montototal = montototal;
    }

    public Factura() {

    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public String getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }

    public double getMontototal() {
        return montototal;
    }

    public void setMontototal(double montototal) {
        this.montototal = montototal;
    }

    public ArrayList<Venta> getArrayVenta() {
        return arrayVenta;
    }

    public void setArrayVenta(ArrayList<Venta> arrayVenta) {
        this.arrayVenta = arrayVenta;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    

    @Override
    public String toString() {
        return "Factura{" + "idfactura=" + idfactura + ", metodopago=" + metodopago + ", montototal=" + montototal + ", arrayVenta=" + arrayVenta + '}';
    }

    
    public void Guardar() throws ClassNotFoundException, SQLException{
        DBConection db = new DBConection();
        db.st.execute("INSERT INTO Factura (MetodoPago, MontoTotal, IDCliente) VALUES ('"+getMetodopago()+"', '"+getMontototal()+"', '"+getIdcliente()+"' )");
        db.st.close();
        db.con.close();
    }
            
    public void GuardarVentaFactura() throws ClassNotFoundException, SQLException{
        DBConection db = new DBConection();
        for(Venta v : arrayVenta){ 
            db.st.execute("SELECT IDFactura FROM Factura ORDER BY IDFactura DESC LIMIT 1");
            db.resSet = db.st.getResultSet();
            db.resSet.next(); 
            db.st.execute("INSERT INTO Venta (Fecha, MontoUnitario, IDViaje, IDFactura) VALUES ('"+v.getFecha()+"', '"+v.getMontounitario()+"', '"+v.getViaje().getIdviaje()+"', '"+db.resSet.getInt("IDFactura")+"')");
        } 
        db.st.close();
        db.con.close();    
    }   
    
    public double generarmonto (ArrayList<Venta> arrayVentas, Forma_pago metodo_pago) {
        int i;
        double monto=0;
            for(Venta v : arrayVentas){
                monto = monto + v.getMontounitario();
            }
                if(metodo_pago instanceof Pago_Efectivo){
                    monto = metodo_pago.calcularmonto(monto, 0.2);
                }
                else
                    if(metodo_pago instanceof Pago_Debito){
                        monto = metodo_pago.calcularmonto(monto, 0.1);
                    }
                    else{
                         monto = metodo_pago.calcularmonto(monto, 0.2);
                    }        
        return monto;
    }         
}
