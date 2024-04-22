import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObtensiondeDatos {
    private Map<String, Double> consumirApi(){
        try {
            String apiUrl = "https://v6.exchangerate-api.com/v6/89a0855964363102cd6b8c44/latest/USD";
            // Crear cliente HttpClient
            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            // Enviar solicitud y obtener respuesta
            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

            if (respuesta.statusCode() == 200) {
                String cuerpoRespuesta = respuesta.body();

                // Analizar la respuesta JSON con Gson
                Gson gson = new Gson();
                Map<String, Object> respuestaJson = gson.fromJson(cuerpoRespuesta, Map.class);

                Map<String, Double> datos = (Map<String, Double>) respuestaJson.get("conversion_rates");
                return datos;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al consumir la API", e);
        }
    }
    private Map<String, Double> datosFiltrados(){
        Map<String, Double> datos = consumirApi();
        Map<String, Double> filtrarPaises = new HashMap<>();
        filtrarPaises.put("ARS", datos.get("ARS"));
        filtrarPaises.put("BOB", datos.get("BOB"));
        filtrarPaises.put("BRL", datos.get("BRL"));
        filtrarPaises.put("CLP", datos.get("CLP"));
        filtrarPaises.put("COP", datos.get("COP"));
        filtrarPaises.put("MXN", datos.get("MXN"));
        filtrarPaises.put("PEN", datos.get("PEN"));
        filtrarPaises.put("PYG", datos.get("PYG"));
        filtrarPaises.put("UYU", datos.get("UYU"));
        filtrarPaises.put("VEF", datos.get("VEF"));
        return filtrarPaises;
    }

    public List<DatosConversion> datosList(){
        Map<String, Double> datos= datosFiltrados();
        List<DatosConversion> lista = new ArrayList<>();
        for (Map.Entry<String, Double> entry : datos.entrySet()) {
            DatosConversion conversion = new DatosConversion();
            conversion.setCodigo(entry.getKey());
            conversion.setValor(entry.getValue());
            lista.add(conversion);
        }
        return lista;
    }
}
