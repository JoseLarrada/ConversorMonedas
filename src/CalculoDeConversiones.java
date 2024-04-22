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
        System.out.println("El valor es: "+ valorFinal);
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
        System.out.println("El valor es: "+ valorFinal);
    }
}
