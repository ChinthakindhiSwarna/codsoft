import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for base and target currencies
        System.out.print("Enter base currency (e.g., USD, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., INR, GBP): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Fetch exchange rates for the base currency
        Map<String, Double> exchangeRates = fetchExchangeRates(baseCurrency);

        // Get the amount to convert
        System.out.print("Enter amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        // Convert the amount using the fetched exchange rate
        double convertedAmount = amountToConvert * exchangeRates.get(targetCurrency);

        // Display the result
        System.out.println(amountToConvert + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
    }

    private static Map<String, Double> fetchExchangeRates(String baseCurrency) {
        Map<String, Double> exchangeRates = new HashMap<>();

        try {
            // Replace with a reliable API URL for fetching exchange rates
            URL url = new URL("https://api.example.com/exchange-rates/" + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the API response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the JSON or XML response to extract exchange rates
                // ... (API-specific parsing logic)
                // Example:
                // exchangeRates.put("INR", 80.0);
                // exchangeRates.put("GBP", 0.8);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error fetching exchange rates.");
        }

        return exchangeRates;
    }
}