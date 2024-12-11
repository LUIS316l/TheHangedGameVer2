package utils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameLogic {

    private String word;
    private int lives;
    private int points;
    private int round;
    private boolean isWordComplete;

    public GameLogic() {
        this.lives = 6;
        this.points = 0;
        this.round = 1;
        this.isWordComplete = false;
    }

    public String getWord() {
        word = "HELLO"; 
        return word;
    }

    // Método para verificar la letra
    public boolean checkGuess(char guessedLetter, JLabel[] letterLabels) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guessedLetter) {
                letterLabels[i].setText(String.valueOf(guessedLetter));
                found = true;
            }
        }

        if (!found) {
            lives--;
        }

        // Verificar si la palabra está completa
        isWordComplete = true;
        for (JLabel label : letterLabels) {
            if (label.getText().equals("_")) {
                isWordComplete = false;
                break;
            }
        }

        return found;
    }

    // Métodos para obtener el estado del juego
    public int getLives() {
        return lives;
    }

    public int getPoints() {
        return points;
    }

    public int getRound() {
        return round;
    }

    public boolean isWordComplete() {
        return isWordComplete;
    }

    public void increaseRound() {
        round++;
    }

    public void increasePoints() {
        points++;
    }

    public void reset() {
        lives = 6;
        points = 0;
        round = 1;
        isWordComplete = false;
    }
}
