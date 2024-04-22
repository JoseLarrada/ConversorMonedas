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
        Map<String, Double> filteredRates = new HashMap<>();
        filteredRates.put("ARS", datos.get("ARS"));
        filteredRates.put("BOB", datos.get("BOB"));
        filteredRates.put("BRL", datos.get("BRL"));
        filteredRates.put("CLP", datos.get("CLP"));
        filteredRates.put("COP", datos.get("COP"));
        filteredRates.put("MXN", datos.get("MXN"));
        filteredRates.put("PEN", datos.get("PEN"));
        filteredRates.put("PYG", datos.get("PYG"));
        filteredRates.put("UYU", datos.get("UYU"));
        filteredRates.put("VEF", datos.get("VEF"));
        return filteredRates;
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
