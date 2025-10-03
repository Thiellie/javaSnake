import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GamePanel extends JPanel implements ActionListener{
    static int SCREEN_WIDTH = 550;
    static int SCREEN_HEIGHT = 550;
    static int UNIT_SIZE = 25;
    static int ROWSIZE = SCREEN_HEIGHT/UNIT_SIZE;
    static int COLSIZE = SCREEN_WIDTH/UNIT_SIZE;
    static int DELAY = 100;
    boolean running = false;
    Timer timer;
    Board board;
    Cell initPos;
    Snake snake;
    private int start = 6;
    private char dir = 'r';
    private boolean generateFood = true;
    private final int extra = 50;




    public GamePanel(GameFrame frame){
        board = new Board(ROWSIZE, COLSIZE);
        initPos = new Cell(ROWSIZE/2,(COLSIZE/2)-start+1);
        snake = new Snake(initPos,board);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new myKeyAdapter());
        //startGame();
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
        for(int r=0; r<ROWSIZE; r++){
            for(int c=0; c<COLSIZE; c++){
                if (cells[r][c].getType() == Type.SNAKE){
                    g.setColor(Color.GREEN);
                    g.fillRect(c*UNIT_SIZE,r*UNIT_SIZE,UNIT_SIZE,UNIT_SIZE);
                } else if (cells[r][c].getType() == Type.WALL) {
                    g.setColor(Color.BLUE);
                    g.fillRect(c*UNIT_SIZE,r*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                } else if (cells[r][c].getType() == Type.FOOD) {
                    g.setColor(Color.RED);
                    g.fillOval(c*UNIT_SIZE,r*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                }
            }
        }
        g.setColor(Color.WHITE);
        for(int i=0; i<ROWSIZE; i++){
            g.drawLine(0,UNIT_SIZE*(i+1),SCREEN_WIDTH,UNIT_SIZE*(i+1));
        }
        for(int i=0;i<COLSIZE; i++){
            g.drawLine(UNIT_SIZE*(i+1), 0,UNIT_SIZE*(i+1),SCREEN_HEIGHT);
        }
    }
    public void gameOver(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        FontMetrics metrics = getFontMetrics(g.getFont());
        int gHeight = metrics.getHeight();
        g.drawString("GameOver", (SCREEN_WIDTH-metrics.stringWidth("GameOver"))/2, SCREEN_HEIGHT/2);
        String score = Integer.toString(snake.getSnakePartList().size() - 2);
        score = "Score: " + score;
        g.setFont(new Font("Times New Roman",Font.BOLD, 15));
        metrics = getFontMetrics(g.getFont());
        g.drawString(score,(SCREEN_WIDTH-metrics.stringWidth(score))/2, (SCREEN_HEIGHT+gHeight+extra)/2);
    }
    public boolean checkCrash(Cell nextCell){
        if((board.getCellType(nextCell.getRow(), nextCell.getCol())==Type.SNAKE) || (board.getCellType(nextCell.getRow(), nextCell.getCol()) == Type.WALL)){
            return true;

        } else if(board.getCellType(nextCell.getRow(), nextCell.getCol())==Type.FOOD) {
            generateFood = true;
        }
        return false;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (running){
            Cell head = snake.getHead();

            switch(dir){
                case 'l':
                    head = new Cell(head.getRow(), head.getCol()-1);
                    break;
                case 'r':
                    head = new Cell(head.getRow(), head.getCol()+1);
                    break;
                case 'u':
                    head = new Cell(head.getRow()-1, head.getCol());
                    break;
                case 'd':
                    head = new Cell(head.getRow()+1, head.getCol());
                    break;
            }
            if(checkCrash(head)){
                running = false;
            } else if (generateFood){
                board.generateFood();
                generateFood=false;
                snake.grow(head, board);
            }
            else{
                snake.move(head,board);
            }
            repaint();

        }
    }
    public class myKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(dir!='r'){
                        dir = 'l';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(dir!= 'l'){
                        dir = 'r';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(dir!='d'){
                        dir = 'u';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(dir!='u'){
                        dir = 'd';
                    }
                    break;
            }
        }

    }
}

