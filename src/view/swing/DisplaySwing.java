package view.swing;

import model.Money;
import view.Display;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class DisplaySwing extends JPanel implements Display {
    private JTextPane display;

    public DisplaySwing(Money money) {

        createComponentsGUI();
        refreshMoney(money);
    }

    public DisplaySwing() {
        createComponentsGUI();
    }

    @Override
    public void refreshMoney(Money money) {
        display.setText(money.toString());
    }

    private void createComponentsGUI() {
        this.display = new JTextPane();
        this.display.setEditable(false);
        this.display.setFont(new Font("Monospaced", Font.BOLD, 40));
        SimpleAttributeSet centre = new SimpleAttributeSet();
        StyleConstants.setAlignment(centre, StyleConstants.ALIGN_CENTER);
        this.display.setParagraphAttributes(centre, true);
        setLayout(new BorderLayout());
        JScrollPane scrollPanel = new JScrollPane(this.display);
        this.add(scrollPanel, BorderLayout.CENTER);
    }
}
