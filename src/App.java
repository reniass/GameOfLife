import javax.swing.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("What size of the universe do you want to generate? ");
        int sizeOfTheUniverse = sc.nextInt();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameOfLife game = new GameOfLife(new Universe(sizeOfTheUniverse));
                try {
                    game.startTheGame();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
