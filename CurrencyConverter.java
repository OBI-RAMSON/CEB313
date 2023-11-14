import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

public class CurrencyConverter {
    public static void main(String[] args) {
        CurrencyUnit fromCurrency = Monetary.getCurrency("USD"); // Replace with user input
        CurrencyUnit toCurrency = Monetary.getCurrency("EUR"); // Replace with user input
        double amount = 100.0; // Replace with user input

        ExchangeRateProvider exchangeRateProvider = MonetaryConversions.getExchangeRateProvider();
        CurrencyConversion conversion = exchangeRateProvider.getCurrencyConversion(fromCurrency, toCurrency);
        double result = conversion.convert(amount);

        System.out.println(amount + " " + fromCurrency + " is equal to " + result + " " + toCurrency);
    }
}