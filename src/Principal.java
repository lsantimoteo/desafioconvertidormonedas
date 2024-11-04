import Paridad.Paridad;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        int eleccion = 1;
        String monedaDe = "";
        String monedaA = "";
        System.out.println("""
                **************************************************
                Bienvenido al convertidor de monedas de Lucas Santimoteo
                
                Estas son las alternativas de paridades a la fecha:
                
                1) Dolar =>> Peso argentino
                2) Peso argentino =>> Dolar
                3) Dolar =>> Real brasilero
                4) Real brasilero =>> Dolar
                5) Dolar =>> Peso colombiano
                6) Peso colombiano =>> Dolar
                7) Salir
                
                Elija la opcion deseada:
                **************************************************
                """);
        Scanner teclado = new Scanner(System.in);
        while (eleccion !=7) {
            eleccion = teclado.nextInt();
            if (eleccion == 7) {
                System.out.println("Gracas por utilizar el convertidor de monedas creado por Lucas Santimoteo");
            } else if (eleccion > 7) {
                System.out.println("Ese valor no es una alternativa valida, intentelo nuevamente");
            } else {
                System.out.println("Indique el monto que desea convetir:");
                double montoAConvertir = Double.valueOf(teclado.next());

                switch (eleccion){
                    case 1:
                        monedaDe = "USD";
                        monedaA = "ARS";
                        break;
                    case 2:
                        monedaDe = "ARS";
                        monedaA = "USD";
                        break;
                    case 3:
                        monedaDe = "USD";
                        monedaA = "BRL";
                        break;
                    case 4:
                        monedaDe = "BRL";
                        monedaA = "USD";
                        break;
                    case 5:
                        monedaDe = "USD";
                        monedaA = "COP";
                        break;
                    case 6:
                        monedaDe = "COP";
                        monedaA = "USD";
                        break;
                }

                // estas dos lineas las tendre q eliminar cuando le agregue el impacto d la conversion
                System.out.println(eleccion);
                System.out.println(montoAConvertir);

                String direccion = "https://v6.exchangerate-api.com/v6/8bc719dddc741ad3724c4bb9/pair/" + monedaDe + "/" + monedaA;

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                Gson gson = new Gson();
                Paridad miParidad = gson.fromJson(json, Paridad.class);


                System.out.println("El valor de " + montoAConvertir + monedaDe + " representa " + miParidad.getFactorDeConversion()*montoAConvertir + monedaA);

                System.out.println("Por favor vuelva a indicar la alternativa de paridades "
                        + "o 7 para salir");
            }
        }
    }
}