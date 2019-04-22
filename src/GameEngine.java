public class GameEngine {
    private int size;


    int board[][];

    public GameEngine(int size) {
        this.size = size;
        board = new int[size][size];
    }

    // this function check if column is full
    public boolean checkVertical(int column) {
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            if (board[i][column] == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // this function check if row is full
    public boolean checkHorizontal(int row) {
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            if (board[row][i] == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // this function check if cross is full
    // it check only in one direction
    // if user put X in the middle we need to run this function twice
    // the first run with rowStart equals 0
    // the second run with rowStart equals game size
    public boolean checkCross(int rowStart) {
        boolean flag = true;
        if (rowStart == 0) {
            for (int i = 0; i < size; i++) {
                if(board[i][i] == 0){
                    flag = false;
                    break;
                }
            }
        }else if(rowStart == size){
            for (int i = size; i > 0; i--) {
                if(board[i-1][size-i] == 0){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public void print() {

        // print header
        System.out.print("    |");
        for (int col = 0; col < size; col++) {
            if (col < 10) {
                System.out.print("  " + col + "  |");
            } else if (col < 100) {
                System.out.print("  " + col + " |");
            } else if (col < 1000) {
                System.out.print(" " + col + " |");
            }

        }
        System.out.println();
        for (int col = 0; col <= size; col++) {
            System.out.print("------");
        }

        // print new line after header
        System.out.println();

        for (int row = 0; row < size; row++) {
            // print row num
            if (row < 10) {
                System.out.print(row + "   ");
            } else if (row < 100) {
                System.out.print(row + "  ");
            } else if (row < 1000) {
                System.out.print(row + " ");
            }



            System.out.print("|");

            for (int col = 0; col < size; col++) {
                if(board[row][col] == 1 ){
                    System.out.print("  X  |");
                }else if(board[row][col] == 0){
                    System.out.print("     |");
                }

            }

            System.out.println();

            for (int col = 0; col <= size; col++) {
                System.out.print("------");
            }
            System.out.println();
        }
    }
}
