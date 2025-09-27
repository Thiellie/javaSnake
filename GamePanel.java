import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GamePanel extends JPanel implements ActionListener{
    static int SCREEN_WIDTH = 550;
    static int SCREEN_HEIGHT = 550;
    static int UNIT_SIZE = 25;
    static int ROWSIZE = SCREEN_HEIGHT/UNIT_SIZE;
    static int COLSIZE = SCREEN_WIDTH/UNIT_SIZE;
    static int DELAY = 75;
    boolean running = false;
    Timer timer;
    Board board;
    Cell initPos;
    Snake snake;
    private int start = 6;
    private char dir = 'r';
    private boolean generateFood = true;
    private final int extra = 50;



    public GamePanel(){
        board = new Board(ROWSIZE, COLSIZE);
        initPos = new Cell(ROWSIZE/2,(COLSIZE/2)-start+1);
        snake = new Snake(initPos,board);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        startGame();

    }

    public void startGame(){
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        if(running){
            drawBoard(g);
        } else {
            gameOver(g);
        }
    }

    public void drawBoard(Graphics g){
        Cell[][] cells = board.getCells();
        for(int r=0; r>ROWSIZE; r++){
            for(int c=0; c<COLSIZE; c++){
                if (cells[r][c].getType() == Type.SNAKE){
                    g.setColor(Color.GREEN);
                } else if (cells[r][c].getType() == Type.WALL) {
                    g.setColor(Color.BLUE);
                    g.fillRect(c*UNIT_SIZE,r*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                } else if (cells[r][c].getType() == Type.FOOD) {
                    g.setColor(Color.RED);
                    g.fillOval(c*UNIT_SIZE,r*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

