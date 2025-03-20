import java.util.Random;

public class Ship {

   public static int [] SizeOfShip;

   private void PlaceShips(char[][] grid , int GRID_SIZE) {

       if (GRID_SIZE == 10){
           SizeOfShip = new int[]{2, 3, 4, 5};
       }
       else  if (GRID_SIZE == 15){
           SizeOfShip = new int[]{2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5};
       }
       else if (GRID_SIZE == 20){
           SizeOfShip = new int[]{2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6};
       }
        Random rand = new Random();

        for ( int size : SizeOfShip ) {
            boolean placed = false;
            while ( !placed ) {
                int x = rand.nextInt(GRID_SIZE-1);
                int y = rand.nextInt(GRID_SIZE-1);
                boolean horizontal = rand.nextBoolean();

                if(canPlaceShip(grid, x, y, size, horizontal , GRID_SIZE)) {
                    for (int j = 0; j < size ; j++) {
                        if (horizontal) {
                            grid[x][y + j] = 'S';
                        } else {
                            grid[x + j][y] = 'S';
                        }
                    }
                    placed = true;
                }

            }
        }
   }

    private boolean canPlaceShip(char[][] grid, int row, int col, int size, boolean horizontal , int GRID_SIZE) {
        //todo
        if (horizontal) {
            for (int i = 0; i < size; i++) {
                if(col+ i >= GRID_SIZE) return false;
                if(grid[row][col + i] != '~') return false;
            }
        }
        else{
            for (int i = 0; i < size; i++) {
                if(row+ i >= GRID_SIZE) return false;
                if(grid[row + i][col] != '~') return false;
            }
        }
        return true;
    }

    public void setPlaceShip1(char[][] player1Grid , int GRID_SIZE ) {
        var placeShip = new Ship();
        placeShip.PlaceShips(player1Grid , GRID_SIZE);

    }

    public void setPlaceShip2( char[][] player2Grid , int GRID_SIZE ) {
        var placeShip = new Ship();

        placeShip.PlaceShips(player2Grid , GRID_SIZE);
    }
}