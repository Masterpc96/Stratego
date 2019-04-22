import java.util.Scanner;

public class GameEngine {
    private int size;


    int board[][];

    private int firstGamerPoints = 0;

    private int secondGamerPoints = 0;

    private int gamerNumber;

    private Scanner scanner;

    private int row;

    private int column;

    private int insertionNumber;


    public GameEngine(int size) {
        this.size = size;
        board = new int[size][size];
        gamerNumber = 1;
        scanner = new Scanner(System.in);
        print();
    }

    public void move() {
        while (insertionNumber != 2 * size) {
            System.out.println("Gracz nr " + gamerNumber + " podaj miejsce wstawienia X");

            System.out.print("Wiersz ");
            row = scanner.nextInt();

            System.out.print("Kolumna ");
            column = scanner.nextInt();

            while (row >= size || column >= size) {
                System.out.println("Podano wartość z poza zakresu wprowadź wiersz i kolumnę jeszcze raz ");
                System.out.print("Wiersz ");
                row = scanner.nextInt();

                System.out.print("Kolumna ");
                column = scanner.nextInt();
            }

            while (board[row][column] == 1) {
                System.out.println("X już znajduje się na tej pozycji. Proszę wybrać inną");
                System.out.print("Wiersz ");
                row = scanner.nextInt();

                System.out.print("Kolumna ");
                column = scanner.nextInt();
            }


            board[row][column] = 1;

            insertionNumber++;
            if (gamerNumber == 1) {
                gamerNumber = 2;
                firstGamerPoints += (checkVertical(column) + checkHorizontal(row) + checkCross(row, column));
            } else {
                gamerNumber = 1;
                secondGamerPoints += (checkVertical(column) + checkHorizontal(row) + checkCross(row, column));
            }
            print();
        }
    }


    // this function check if column is full
    private int checkVertical(int column) {
        int points = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][column] == 0) {
                return 0;
            }
            points++;
        }
        return points;
    }

    // this function check if row is full
    private int checkHorizontal(int row) {
        int points = 0;
        for (int i = 0; i < size; i++) {
            if (board[row][i] == 0) {
                return 0;
            }
            points++;
        }
        return points;
    }

    // this function check if cross is full left and right direction
    public int checkCross(int row, int column) {

        int points = 0;
        int _points = 0;

        int _row = row;
        int _column = column;

        if (!(row == size-1 && column == 0) &&  !(column == size-1 && row == 0) ) {
            while (row != 0) {
                row--;
                column--;
            }


            while (column < size) {
                if (board[row][column] == 0) {
                    points = 0;
                    break;
                }
                row++;
                column++;
                points++;
            }
        }

        if (!(_row == 0 && _column == 0) &&  !(_column == size-1 && _row == size-1) ) {
            while (_row != 0) {
                _row--;
                _column++;
            }


            while (_column >= 0) {
                if (board[_row][_column] == 0) {
                    points = 0;
                    break;
                }
                _row++;
                _column--;
                _points++;
            }
        }


        return points + _points;
    }

    public void print() {

        System.out.println("Gracz 1 " + firstGamerPoints);
        System.out.println("Gracz 2 " + secondGamerPoints);

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
                if (board[row][col] == 1) {
                    System.out.print("  X  |");
                } else if (board[row][col] == 0) {
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
