import com.google.gson.Gson;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        OpcionesyMenus menus= new OpcionesyMenus();
        boolean bandera=false;
        String menuPrincipal= """
                Bienvenido al conversor de monedas latinoamericana
                1 - Convertir de Dolar a Moneda local.
                2 - Convertir de Moneda local a Dolar.
                3 - Salir.
                """;

        while (!bandera){
            int opcionMenuPrincipal= Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            switch (opcionMenuPrincipal){
                case 1:
                    menus.menuDeDolarAMonedaLocal();
                    break;
                case 2:
                    menus.menuDeMonedaLocalADolar();
                case 3:
                    bandera=true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Ingrese un valor valido");
                    break;
            }
        }
    }
}
