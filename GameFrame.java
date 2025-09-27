import javax.swing.JFrame;


public class GameFrame extends JFrame {
    public GameFrame(){
        this.add(new GamePanel());
        initialize();
    }

    public void initialize() {
        setTitle("louisSnake");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);


    }

}
