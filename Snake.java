import java.util.LinkedList;

public class Snake {
    // we maken een linkedlist als snakebody parts omdat we daar makkelijk ana kunnen toevoegen + de linkedList bestaat uit Cell type.
    // kan ook uit int, String, ... bestaan. Nu uit Cell. locatie van bodyparts.
    private LinkedList<Cell> snakePartList = new LinkedList<>();
    private Cell head;
    private int headLength = 1;

    public Snake(Cell initPos, Board board){
        for(int i = 0; i< headLength; i++){
            this.head = new Cell(initPos.getRow(), initPos.getCol());
            this.snakePartList.addFirst(head);
            this.head.setType(Type.SNAKE);
            board.setCell(initPos.getRow(),initPos.getCol(), Type.SNAKE);
        }

    }

    public void grow(Cell nextCell, Board board){
       head = nextCell;
       head.setType(Type.SNAKE);
       board.setCell(head.getRow(), head.getCol(), Type.SNAKE);
       snakePartList.addFirst(head);
    }
    public void move(Cell nextCell, Board board){
        // if head eats food
        //         move head upwards do not remove end bit.
        if( nextCell.getType() != Type.FOOD){
            Cell tail = snakePartList.removeLast();
            board.setCell(tail.getRow(),tail.getCol(),Type.EMPTY);
        };

        head = nextCell;
        head.setType(Type.SNAKE);
        board.setCell(head.getRow(), head.getCol(), Type.SNAKE);
        snakePartList.addFirst(head);

    }

    public LinkedList<Cell> getSnakePartList(){
        return snakePartList;
    }

    public Cell getHead(){
        return head;
    }
}
