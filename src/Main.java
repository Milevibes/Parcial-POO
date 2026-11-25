import clases.Pokemon;
import clases.Trainer;
import frontend.InicioModerno;
import operation.OperationsPokemon;
import operation.OperationsTrainers;

import java.awt.EventQueue;
import java.util.List;
import java.util.Scanner;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        iniciarInterfaz();
    }

    private static void iniciarInterfaz() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }

        EventQueue.invokeLater(() -> {
            try {
                new InicioModerno().setVisible(true);
            } catch (Exception e) {
                System.out.println("No se pudo abrir la interfaz: " + e.getMessage());
            }
        });
    }

}