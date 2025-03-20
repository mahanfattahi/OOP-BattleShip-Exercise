public class IsGameOver {

    private boolean allShipsSunk(char[][] grid , int GRID_SIZE) {

        int x=0;

        if(GRID_SIZE==10){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == 'X') {
                    x++;
                }
            }
        }
        if (x == 14) {
            return true;
        }

       }
        else if(GRID_SIZE==15){
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (grid[i][j] == 'X') {
                        x++;
                    }
                }
            }
            if (x == 40) {
                return true;
            }

        }
        else if(GRID_SIZE==20){
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (grid[i][j] == 'X') {
                        x++;
                    }
                }
            }
            if (x == 78) {
                return true;
            }
        }
        return false;
    }

    public boolean isGameOver(char[][] player1Grid , char[][] player2Grid , int GRID_SIZE) {
        //todo
        if (allShipsSunk(player1Grid , GRID_SIZE)) {
            System.out.println("player 2 wins");
            return true;
        }
        else if (allShipsSunk(player2Grid , GRID_SIZE)) {
            System.out.println("player 1 wins");
            return true;
        }
        return false;
    }
}