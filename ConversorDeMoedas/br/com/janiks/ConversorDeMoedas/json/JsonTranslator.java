package br.com.janiks.ConversorDeMoedas.json;

public class JsonTranslator {
    String conversionResult;
    String conversionRate;
    String lastUpdate;
    String nextUpdate;

    public JsonTranslator(CurrencyExchange exchangeTranslate) {
        this.conversionResult = exchangeTranslate.conversion_result();
        this.conversionRate = exchangeTranslate.conversion_rate();
        this.lastUpdate = exchangeTranslate.time_last_update_utc().substring(0,25);
        this.nextUpdate = exchangeTranslate.time_next_update_utc().substring(0,25);
    }


    @Override
    public String toString() {
        return "\n\n\n******************************************************"+
                "\nConversão: " + conversionResult+
                "\nTaxa de conversão: " + conversionRate+
                "\nUltima atualização: " + lastUpdate +
                "\nPróxima atualização: " + nextUpdate+
                "\n******************************************************\n\n\n";
    }
}
