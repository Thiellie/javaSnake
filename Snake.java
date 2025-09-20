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


    public void snakeHead(int rowC, int colC){
        // ik moet een start positie hebben misschien te midden het board.

    }
    public void movementSnake(){

    }
    public void growSnake(){

    }
}
