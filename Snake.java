import java.util.LinkedList;

public class Snake {
    // we maken een linkedlist als snakebody parts omdat we daar makkelijk ana kunnen toevoegen + de linkedList bestaat uit Cell type.
    // kan ook uit int, String, ... bestaan. Nu uit Cell. locatie van bodyparts.
    private LinkedList<Cell> SnakePartList = new LinkedList<>();
    private Cell head;
    private int headLength = 5;

    public Snake(Cell initPos, Board board){
        for(int i=0; i<headLength; i++){
            Cell head = new Cell(initPos.getRow(), initPos.getCol());
            SnakePartList.addFirst(head);
            head.setType(Type.SNAKE);
            board.setCell(initPos.getRow(),initPos.getCol(), Type.SNAKE);
        }

    }

    public void grow(Cell nextCell, Board board){
       head = nextCell;
       head.setType(Type.SNAKE);
       board.setCell(head.getRow(), head.getCol(), Type.SNAKE);
       SnakePartList.addFirst(head);
    }
    public void move(Cell nextCell, Board board){
        // if head eats food
        //         move head upwards do not remove end bit.
        if( nextCell.getType() != Type.FOOD){
            Cell tail = SnakePartList.removeLast();
            board.setCell(tail.getRow(),tail.getCol(),Type.EMPTY);
        };

        head = nextCell;
        head.setType(Type.SNAKE);
        board.setCell(head.getRow(), head.getCol(), Type.SNAKE);
        SnakePartList.addFirst(head);

    }

    public LinkedList<Cell> getSnakePartList(){
        return SnakePartList;
    }

    public Cell getHead(){
        return head;
    }
}
