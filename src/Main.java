public class Main {
    public static void main(String args[]) {

        int size = 10;



        GameEngine gameEngine = new GameEngine(size);

        int board[][] = new int[size][size];

        for (int i = 0; i < size; i++) {
            if(i!=5){
                board[i][i] = 1;
            }

        }
        gameEngine.board = board;
        System.out.println(gameEngine.checkCross(0));
        gameEngine.print();

    }
}
