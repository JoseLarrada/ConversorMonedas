import javax.swing.*;

public class OpcionesyMenus {
    CalculoDeConversiones calculo= new CalculoDeConversiones();
    String menuDesplegable= """
                    Ingrese la opcion que corresponde con su pais
                    1 - Argentina
                    2 - Bolivia
                    3 - Brasil
                    4 - Chile
                    5 - Colombia
                    6 - México
                    7 - Perú
                    8 - Paraguay
                    9 - Uruguay
                    10 - Venezuela
                    11 - Salir.
                """;
    public void menuDeDolarAMonedaLocal(){
        boolean salir=false;
        while (!salir){
            int opcionMenuSecundario= Integer.parseInt(JOptionPane.showInputDialog(menuDesplegable));
            switch (opcionMenuSecundario){
                case 11:
                    salir=true;
                    break;
                default:
                    if (opcionMenuSecundario>11){
                        JOptionPane.showMessageDialog(null,"Ingrese un valor valido");
                        break;
                    }
                    double valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor en dolares"));
                    calculo.convertirdeDolares(opcionMenuSecundario,valor);
                    break;
            }
        }
    }

    public void menuDeMonedaLocalADolar(){
        boolean salir=false;
        while (!salir){
            int opcionMenuSecundario= Integer.parseInt(JOptionPane.showInputDialog(menuDesplegable));
            switch (opcionMenuSecundario){
                case 11:
                    salir=true;
                    break;
                default:
                    if (opcionMenuSecundario>11){
                        JOptionPane.showMessageDialog(null,"Ingrese un valor valido");
                        break;
                    }
                    double valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a convertir"));
                    calculo.convertirADolar(opcionMenuSecundario,valor);
                    break;
            }
        }
    }
}
