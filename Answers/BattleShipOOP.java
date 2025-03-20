import java.util.Scanner;

public class BattleShipOOP {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Choose the size of board (10 - 15 - 20)");

        System.out.println("size of ships for each size of board : ");
        System.out.println("size of board : 10x10 ==> size of ships : {2, 3, 4, 5}");
        System.out.println("size of board : 15x15 ==> size of ships : {2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5}");
        System.out.println("size of board : 20x20 ==> size of ships : {2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6}");
        System.out.print("choose : ");

        int GRID_SIZE = 0;

        boolean boolgrid = false;
        while (!boolgrid) {
            try {
                GRID_SIZE = input.nextInt();
                boolgrid = true;
                if (GRID_SIZE != 10 && GRID_SIZE != 15 && GRID_SIZE != 20) {
                    boolgrid = false;
                    System.out.print("Please choose from this list (10 - 15 - 20) : ");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.print("Invalid input!! (enter integer) : ");
                input.next();
            }
        }

        char[][] player1Grid = new char[GRID_SIZE][GRID_SIZE];
        char[][] player2Grid = new char[GRID_SIZE][GRID_SIZE];
        char[][] player1TrackingGrid = new char[GRID_SIZE][GRID_SIZE];
        char[][] player2TrackingGrid = new char[GRID_SIZE][GRID_SIZE];

        var safheBazi = new SafheBazi();

        safheBazi.initializeGrid(player1Grid , GRID_SIZE);
        safheBazi.initializeGrid(player2Grid , GRID_SIZE);
        safheBazi.initializeGrid(player1TrackingGrid , GRID_SIZE);
        safheBazi.initializeGrid(player2TrackingGrid , GRID_SIZE);

        var place = new Ship();
        place.setPlaceShip1(player1Grid , GRID_SIZE);
        place.setPlaceShip2(player2Grid , GRID_SIZE);

        var checker = new IsGameOver();
        var turn = new PlayerTurn();

        boolean player1Turn = true;
        boolean player1HasUsedSuperAttack = false;
        boolean player2HasUsedSuperAttack = false;

        while (!checker.isGameOver(player1Grid , player2Grid , GRID_SIZE)) {
            if (player1Turn) {
                System.out.println("Player 1's turn:");
                safheBazi.printGrid(player1TrackingGrid , GRID_SIZE);
                System.out.println("Choose type of your attack:");
                System.out.println("1 = SimpleAttack");
                System.out.println("2 = SuperAttack");
                System.out.print("choose : ");

                int typeOfAttack = input.nextInt();
                if(typeOfAttack==1){
                    System.out.println("please enter your target :");
                    turn.SimpleAttack(player2Grid, player1TrackingGrid , GRID_SIZE);
                }
                else if (typeOfAttack==2){
                    if(!player1HasUsedSuperAttack){
                    turn.SuperAttack(player2Grid, player1TrackingGrid , GRID_SIZE);
                    player1HasUsedSuperAttack = true;
                    }
                    else
                        System.out.println("You used it before");
                }

            }
            else {
                System.out.println("Player 2's turn:");
                safheBazi.printGrid(player2TrackingGrid , GRID_SIZE);
                System.out.println("Choose type of your attack:");
                System.out.println("1 = SimpleAttack");
                System.out.println("2 = SuperAttack");
                System.out.print("choose : ");

                int typeOfAttack = input.nextInt();
                if(typeOfAttack==1){
                    System.out.println("please enter your target :");
                    turn.SimpleAttack(player1Grid, player2TrackingGrid , GRID_SIZE);
                }
                else if (typeOfAttack==2){
                    if(!player2HasUsedSuperAttack){
                        turn.SuperAttack(player1Grid, player2TrackingGrid , GRID_SIZE);
                        player2HasUsedSuperAttack = true;
                    }
                    else
                        System.out.println("You used it before");
                }

            }
            player1Turn = !player1Turn;
        }
        System.out.println("Game Over!");
    }

}