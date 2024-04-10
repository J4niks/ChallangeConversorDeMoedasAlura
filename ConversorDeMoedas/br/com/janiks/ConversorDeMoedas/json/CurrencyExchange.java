package br.com.janiks.ConversorDeMoedas.json;

public record CurrencyExchange(String time_last_update_utc, String conversion_result, String conversion_rate, String time_next_update_utc) {
}
