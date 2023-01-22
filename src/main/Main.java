package main;

import model.Currency;
import persistence.files.CurrencyLoaderFromFile;
import persistence.rest.ExchangeRateLoaderFromWebService;
import view.swing.DialogSwing;
import view.swing.DisplaySwing;
import view.swing.GUISwing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyLoaderFromFile currencyLoaderFromFile = new CurrencyLoaderFromFile("currencies");
        List<Currency> currencies = currencyLoaderFromFile.currencyLoader();
        ExchangeRateLoaderFromWebService exchangerateLoaderFromWebService = new ExchangeRateLoaderFromWebService();

        DisplaySwing displaySwing = new DisplaySwing();
        new GUISwing(new DialogSwing(currencies, exchangerateLoaderFromWebService, displaySwing), displaySwing, "Dialog money...");
    }
}