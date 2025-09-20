//#1 create board
//#2 create moving dot in grid board
//#3 create randomized food in grid
//#4 create growth snake
//#5 check snake growth en movement
//#5 create control snake


import java.util.LinkedList;

public class Main {


    public static void main(String[] args){

        int board_width = 30;
        int board_height = 5;

        LinkedList width = createwidth(board_width);
        LinkedList height = createHeight(board_height);
        createGrid(board_width,board_height);
        int [] gamestart = calculate_start_game(board_width, board_height);
        System.out.println("gamestart width; " + gamestart[0] + "gamestart height:" + gamestart[1]);

    }

//            #--------------------
//            #-                  -
//            #-                  -
//            #-                  -
//            #-                  -
//            #-                  -
//            #-                  -
//            #-                  -
//            #--------------------
    public static void createGrid(int board_width,int board_height){
        for (int i = -1; i <= board_height; i++){
            if(i == -1 || (i == ( board_height))){
                int counting_width = board_width;
                while ((counting_width + 2) > 0) {
                    System.out.print("-");
                    counting_width--;
                }
                System.out.print("\n");
            } else {
                int counting_width = board_width;
                while ((counting_width) > 0){
                    if(counting_width == ( board_width)){
                        System.out.print("|");
                    }
                    System.out.print(" ");
                    counting_width --;
                }
                System.out.print("|\n");

            }
        }
    }


    public static LinkedList createwidth(int total_board_width) {
        LinkedList<String> width = new LinkedList<>();
        for (int i = 1; i <= total_board_width; i++){
            width.add(String.valueOf(i));
        }
        return width;
    }

    public static LinkedList createHeight(int total_board_height) {

        LinkedList<String> height = new LinkedList<>();
        for (int i = 1; i <= total_board_height; i++){
            height.add(String.valueOf(i));
        }
        return height;
    }

    public static int[] calculate_start_game(int total_board_width, int total_board_height){
        int[] startPos = new int[2];
        startPos[0] = (total_board_width / 2) + total_board_width % 2;
        startPos[1] = (total_board_height / 2) + total_board_height % 2;
        return startPos;
    }
}