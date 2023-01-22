package control;

import model.*;
import view.swing.DialogSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoneyCalculatorController implements ActionListener {
    private final DialogSwing moneyCalculatorDialogSwing;

    public MoneyCalculatorController(DialogSwing moneyCalculatorDialogSwing) {
        this.moneyCalculatorDialogSwing = moneyCalculatorDialogSwing;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Money money = this.moneyCalculatorDialogSwing.getMoney();
        Currency currencyFrom = money.getCurrency();
        Currency currencyTo = this.moneyCalculatorDialogSwing.getCurrencyTo();
        ExchangeRate exchangeRate = this.moneyCalculatorDialogSwing.getExchangeRateLoaderFromWebService().exchangeRateLoader(currencyFrom, currencyTo);
        this.moneyCalculatorDialogSwing.getMoneyCalculatorDisplaySwing().refreshMoney(new Money(exchangeRate.getRate() * money.getAmount(), currencyTo));
    }
}
