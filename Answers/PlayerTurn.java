import java.util.Scanner;

public class PlayerTurn {
    Scanner scanner = new Scanner(System.in);


    public void SimpleAttack(char[][] opponentGrid, char[][] trackingGrid , int GRID_SIZE) {

        String PlayersMove = scanner.nextLine();
        boolean b = isValidInput(PlayersMove , GRID_SIZE);
        if(b) {
            int row = Integer.parseInt(PlayersMove.substring(1));
            int col = (int)(PlayersMove.charAt(0)) - 65;
            if (opponentGrid[row][col] == 'S') {
                trackingGrid[row][col] = 'X';
                opponentGrid[row][col] = 'X';
                System.out.println("Hit");
            }
            else if(opponentGrid[row][col] == 'X' || trackingGrid[row][col] == 'O') {
                System.out.println("invalid input try again :");
                SimpleAttack(opponentGrid, trackingGrid , GRID_SIZE);
            }
            else{
                trackingGrid[row][col] = 'O';
                System.out.println("Miss");
            }

        }
            if(!b) {
                System.out.println("invalid input try again :");
                SimpleAttack(opponentGrid, trackingGrid , GRID_SIZE);
            }

    }


    public void SuperAttack(char[][] opponentGrid, char[][] trackingGrid, int GRID_SIZE) {
        // متغیر useSuperAttack باید به عنوان یک ویژگی کلاس تعریف شود

            int count = 0;
            System.out.println("1 = horizontal or 2 = vertical");
            int jahat = scanner.nextInt();

            if (jahat == 1) {
                System.out.println("Choose your row (0 to " + (GRID_SIZE - 1) + "):");
                int row = scanner.nextInt();
                if (row >= 0 && row < GRID_SIZE) {
                    for (int j = 0; j < GRID_SIZE; j++) {
                        if (opponentGrid[row][j] == 'S') {
                            trackingGrid[row][j] = 'X';
                            opponentGrid[row][j] = 'X';
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Miss!!!");
                    } else {
                        System.out.println("Hit " + count + " places");
                    }

                } else {
                    System.out.println("Invalid input, try again:");
                }
            }
            else if (jahat == 2) {
                System.out.println("Please entre the number of your column (0 to " + (GRID_SIZE - 1) + "):");
                int col = scanner.nextInt();
                if (col >= 0 && col < GRID_SIZE) {
                    for (int i = 0; i < GRID_SIZE; i++) {
                        if (opponentGrid[i][col] == 'S') {
                            trackingGrid[i][col] = 'X';
                            opponentGrid[i][col] = 'X';
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Miss!!!");
                    }
                    else {
                        System.out.println("Hit " + count + " places");
                    }

                }
                else {
                    System.out.println("Invalid input, try again:");
                }
            }
            else {
                System.out.println("Invalid direction, please choose 1 or 2.");
            }

    }



    private boolean isValidInput(String input, int GRID_SIZE) {

        if (GRID_SIZE == 10) {
            if (input.length() != 2) return false;
            char rowChar = input.charAt(1);
            char colChar = input.charAt(0);
            if (colChar < 'A' || colChar > 'J') return false;
            if (rowChar < '0' || rowChar > '9') return false;
            return true;
        }


        else if (GRID_SIZE == 15) {
            char rowChar = input.charAt(1);
            char colChar = input.charAt(0);
            if (input.length() != 2 ){

                if (input.length() == 3 && input.charAt(1) == '1' && (input.charAt(2) < '0' || input.charAt(2) > '4')) return false;

            }
            if (rowChar < '0' || rowChar > '9') return false;
            if (colChar < 'A' || colChar > 'O') return false;


            return true;
        }

         else if (GRID_SIZE == 20) {

            char rowChar = input.charAt(1);
            char colChar = input.charAt(0);
            if (input.length() != 2 ){

                if (input.length() == 3 && input.charAt(1) == '1' && (input.charAt(2) < '0' || input.charAt(2) > '9')) return false;
                if (input.length() == 3 && input.charAt(1) == '2' && (input.charAt(2) != '0' )) return false;
            }
            if (rowChar < 'A' || rowChar > 'T') return false;
            if (colChar < '0' || colChar > '9') return false;


            return true;
        }

        return false;
    }

}