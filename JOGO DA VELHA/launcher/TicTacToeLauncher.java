package launcher;

import javax.swing.*;

import languages.LanguageManager;
import view.TicTacToeUI;

import java.util.Locale;

public class TicTacToeLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] options = {"Portugues", "English"};
            int choice = JOptionPane.showOptionDialog(
                null,
                "Escolha o idioma / choose the language:",
                "idioma / language",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
            );

            if(choice == 1){
                LanguageManager.setLanguage(Locale.ENGLISH);
            }
            else{
                LanguageManager.setLanguage(new Locale("pt"));
            }

            new TicTacToeUI();
        });
    }
}
