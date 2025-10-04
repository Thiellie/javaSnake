import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    final static String MENUPANEL = "Menu";
    final static String GAMEPANEL = "Game";

    public GameFrame(){
        GamePanel gamePanel = new GamePanel(this);
        GameMenu gameMenu = new GameMenu(gamePanel);

        mainPanel = new JPanel(new CardLayout());

        mainPanel.add(gameMenu, MENUPANEL);
        mainPanel.add(gamePanel, GAMEPANEL);
        //TODO Volg de guide voor CardPanels: https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html

        this.add(gamePanel);
        this.setTitle("louisSnake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //showMenu();
    }

    public void showMenu() {
        cardLayout.show(mainPanel, "Menu");
    }


}
