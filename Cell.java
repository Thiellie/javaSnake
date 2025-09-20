public class Cell {
    private final int row, col;
    private Type type;

    //constructor initialiseren van array door row en cel de defineren
    public Cell( int row, int col){
        this.row=row;
        this.col=col;
    }

    //reden type is om cell op te vullen met item
    public void setType(Type type){
        this.type=type;
    }
    // kijken wat zit er in de cell type of geen type + welk soort
    public Type getType(){
        return type;
    }
    // Hier weet ik niet of dit de totale aantal rijen zijn/ niet
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

}
