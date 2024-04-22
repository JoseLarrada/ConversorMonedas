import javax.swing.*;
import java.util.List;
import java.util.Map;

public class CalculoDeConversiones {
    ObtensiondeDatos datos = new ObtensiondeDatos();
    List<DatosConversion> lista= datos.datosList();

    public void convertirdeDolares(int posicion,double valor){
        double valorFinal=0;
        posicion-=1;
        for (int i = 0; i < lista.toArray().length; i++) {
            if (i==posicion){
                DatosConversion datos=lista.get(i);
                valorFinal= datos.getValor()*valor;
            }
        }
        JOptionPane.showMessageDialog(null, "El valor equivalente a "+valor+"$\n" +
                "en su moneda local es de: "+valorFinal);
    }

    public void convertirADolar(int posicion, double valor){
        double valorFinal=0;
        posicion-=1;
        for (int i = 0; i < lista.toArray().length; i++) {
            if (i==posicion){
                DatosConversion datos=lista.get(i);
                valorFinal= valor/datos.getValor();
            }
        }
        JOptionPane.showMessageDialog(null, "El valor equivalente a "+valor+
                "\nen dolares es de: "+valorFinal+"$");
    }
}
