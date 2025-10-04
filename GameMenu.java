import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameMenu extends JPanel{

    static int SCREEN_WIDTH = 550;
    static int SCREEN_HEIGHT = 550;
    private Rectangle startButton;

    public GameMenu(GamePanel gamePanel) {

        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("Snake Game", SwingConstants.CENTER);
        JTextField playerNameField = new JTextField("Player1", 15);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (startButton != null && startButton.contains(e.getPoint())) {
                    System.out.println("Start button clicked!");
                    gamePanel.startGame();

                    //TODO overschakelen van GameMenu frame naar GamePanel snek game.
                }
            }
        });
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        drawMenu(g);
    }

    private void drawMenu(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        FontMetrics metrics = getFontMetrics(g.getFont());

        String text = "Start Game";
        int textHeight = metrics.getHeight();
        int textWidth = metrics.stringWidth(text);
        int ascent = metrics.getAscent();

        int buttonWidth = textWidth + 20;
        int buttonHeight = textHeight + 10;
        int buttonX = (SCREEN_WIDTH - buttonWidth) / 2;
        int buttonY = (SCREEN_HEIGHT - textHeight) / 2;

        //color rectangle
        g.setColor(Color.BLACK);
        g.drawRect(buttonX, buttonY, buttonWidth, buttonHeight);

        // Teken de tekst gecentreerd in de knop
        int textX = buttonX + (buttonWidth - textWidth) / 2;
        int textY = buttonY + (buttonHeight - textHeight) / 2 + ascent;

        g.setColor(Color.RED);
        g.drawString(text, textX, textY);

        startButton = new Rectangle(buttonX, buttonY, buttonWidth, buttonHeight);

    }

    public void clickStart(){

    }
}
