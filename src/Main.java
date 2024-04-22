import com.google.gson.Gson;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CalculoDeConversiones calculo= new CalculoDeConversiones();
        calculo.convertirdeDolares(2,5);
        calculo.convertirADolar(2,19569.482);
    }
}
