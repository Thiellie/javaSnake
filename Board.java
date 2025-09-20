public class Board {
    //final is onveranderlijke veriabele
    final int rowC, colC;
    //array aanmaken dat het bord voorsteld, van type Cell,
    private Cell[][] cells;


    //bord aanmaken rowC hoog en colC breed.
    //allemaal constructor van het bord
    public Board(int rowC, int colC){
        this.rowC = rowC;
        this.colC = colC;
        cells = new Cell[rowC][colC];

        // de array cells is aangemaakt maar nog niet opgevuld,
        // Om acties te maken op het bord vullen we die het best op, met ofwel de cell locatie ofwel een Type.
        for( int r=0; r<rowC; r++){
            for(int c=0; c<colC; c++){
                cells[r][c] = new Cell(r,c);
                cells[r][c].setType(Type.EMPTY);
                if(r == 0 || c == 0 || r == rowC-1 || c == rowC-1 ){
                    cells[r][c].setType(Type.WALL);
                }
            }
        }
    }

    // terug geven van de volledige array.
    public Cell[][] getCells(){
        return cells;

    }

    public void setCell(int row, int col, Type type){
        cells[row][col].setType(type);
    }

    public Type getCellType(int row, int col){
        return cells[row][col].getType();
    }

    public void generateFood(){
        int row, col;
        do {
            row = (int) (Math.random() * rowC);
            col = (int) (Math.random() * colC);
        } while (cells[row][col].getType() != Type.EMPTY);
        cells[row][col].setType(Type.FOOD);
    }
}
