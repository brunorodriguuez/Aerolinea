/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinal;

/**
 *
 * @author bruno
 */
public class Pago_Debito implements Forma_pago{
    
    @Override
    public double calcularmonto(double m, double porcentaje){
        porcentaje = porcentaje * m;
        m = m + porcentaje;
        return m;
    }
}
