import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class GameMenu extends JPanel{



    public GameMenu(GamePanel panel) {
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("Snake Game", SwingConstants.CENTER);
        JTextField playerNameField = new JTextField("Player1", 15);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            String playerName = playerNameField.getText();
            System.out.println("Starting game for: " + playerName);
            panel.startGame();
        });
    }
}
