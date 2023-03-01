package projectpalindroma.main;

import projectpalindroma.view.Interfaz;

public class Main {

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);

            }
        });
    }
}
