import java.util.*;

public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> pcPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char [][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        printGameBoard(gameBoard);


        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter your placement (1-9):");
            int playerPos = scan.nextInt();
            System.out.println();

            placePiece( gameBoard, playerPos, "player" );

            Random rand = new Random();
            int pcPos = rand.nextInt(9) + 1;

            placePiece( gameBoard, pcPos, "PC" );

            printGameBoard(gameBoard);
            checkWinner ();
        }
    }

    public static void printGameBoard (char [][] gameBoard) {
        for (char [] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece ( char[][] gameBoard, int pos, String user ) {

        char symbol = 'X';

        if (user.equals("PC")) {
            symbol = 'O';
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }
    }

    public static String checkWinner () {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(3, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List leftCross = Arrays.asList(1, 5, 9);
        List rightCross = Arrays.asList(3, 5, 7);

        List <List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(bottomRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(leftCross);
        winning.add(rightCross);

        for(List l: winning) {
            if(playerPositions.containsAll(l)) {
                return "Congratulations you won!";
            }
            if(pcPositions.containsAll(l)) {
                return "PC won! Sorry :(";
            }
        }

        if ( (playerPositions.size() + pcPositions.size()) > 8 ) {
            return "Game over!";
        }
        return "";
    }
}