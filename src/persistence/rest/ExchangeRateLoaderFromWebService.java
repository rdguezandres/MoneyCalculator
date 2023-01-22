package persistence.rest;

import model.Currency;
import model.ExchangeRate;
import persistence.ExchangeRateLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExchangeRateLoaderFromWebService implements ExchangeRateLoader {

    @Override
    public ExchangeRate exchangeRateLoader(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, getRate(from.getCode(), to.getCode()));
        } catch (Exception e) {
            return null;
        }
    }

    public double getRate(String codeFrom, String codeTo) throws IOException {
        String line = read(new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + codeFrom + "/" + codeTo + ".json"));
        return Double.parseDouble(getStringRateFromJSONLine(line));
    }

    private String getStringRateFromJSONLine(String line) {
        String[] split = line.split(",");
        return split[1].substring(split[1].indexOf(":") + 1, split[1].indexOf("}") - 1);
    }

    private String read(URL url) {
        try (InputStream is = url.openStream()) {
            byte[] buffer = new byte[1024];
            int length = is.read(buffer);
            return new String(buffer, 0, length);
        } catch (IOException e) {
            System.out.println("ExchangeRateLoaderFromWebService :: read, IOException " + e.getMessage());
            return null;
        }
    }
}

