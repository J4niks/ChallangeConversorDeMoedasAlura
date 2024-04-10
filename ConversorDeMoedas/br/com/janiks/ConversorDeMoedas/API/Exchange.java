package br.com.janiks.ConversorDeMoedas.API;

import br.com.janiks.ConversorDeMoedas.json.CurrencyExchange;
import br.com.janiks.ConversorDeMoedas.json.JsonTranslator;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class Exchange {
    public void printExchange(String body, String currency, String currencyPair) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();
        CurrencyExchange exchange = gson.fromJson(body, CurrencyExchange.class);
        JsonTranslator currencyExchange = new JsonTranslator(exchange, currency, currencyPair);
        System.out.println(currencyExchange.toString());
    }
}
