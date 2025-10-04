import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public GameFrame(){
        CardLayout layout = new CardLayout();
        JPanel mainPanel = new JPanel(layout);

        GamePanel gamePanel = new GamePanel(this);
        GameMenu gameMenu = new GameMenu(gamePanel);
        mainPanel.add(gameMenu, "Menu");
        //mainPanel.add(gamePanel, "Game");

        this.add(gameMenu);
        this.setTitle("louisSnake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        showMenu();
    }

    public void showMenu() {
        cardLayout.show(mainPanel, "Menu");
    }


}
