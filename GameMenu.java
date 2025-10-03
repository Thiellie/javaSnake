import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GameMenu extends JPanel{

    static int SCREEN_WIDTH = 550;
    static int SCREEN_HEIGHT = 550;
    public GameMenu() {

        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("Snake Game", SwingConstants.CENTER);
        JTextField playerNameField = new JTextField("Player1", 15);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            String playerName = playerNameField.getText();
            System.out.println("Starting game for: " + playerName);
        });
    }

    private void drawMenu(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        FontMetrics metrics = getFontMetrics(g.getFont());
        int gHeight = metrics.getHeight();
        g.drawString(String "Start Game", int (SCREEN_WIDTH-metrics.stringWidth("Start Game")/2), int (SCREEN_HEIGHT+gHeight)/2);

    }
}
