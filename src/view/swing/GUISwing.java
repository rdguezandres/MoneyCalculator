package view.swing;

import javax.swing.*;
import java.awt.event.*;

public class GUISwing extends JFrame {

    public GUISwing(JPanel dialogSwing, JPanel displaySwing, String string) {
        super(string);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(dialogSwing, "North");
        this.getContentPane().add(displaySwing, "South");
        this.pack();
        this.setVisible(true);
    }


    private static class WindowCloseManager extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent windowEvent) {
            System.exit(0);
        }
    }

}
