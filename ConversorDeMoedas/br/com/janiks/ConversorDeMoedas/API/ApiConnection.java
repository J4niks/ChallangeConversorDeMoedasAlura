package br.com.janiks.ConversorDeMoedas.API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnection {
    private String apikey = System.getenv("API_KEY");
    private String exchangeUri = "https://v6.exchangerate-api.com/v6/";

    public void Connection(String currency,String currencyPair, double value){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(exchangeUri+apikey+"/pair/"+currency+"/"+currencyPair+"/"+value))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Exchange z = new Exchange();
            z.printExchange(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
