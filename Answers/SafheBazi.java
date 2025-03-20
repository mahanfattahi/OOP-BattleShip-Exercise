public class SafheBazi {

    public void initializeGrid(char[][] grid, int GRID_SIZE) {
        //todo
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = '~';
            }
        }

    }

    public void printGrid(char[][] grid , int GRID_SIZE) {
        //todo

        System.out.print("    ");
        for (char ch = 'A'; ch <'A' + GRID_SIZE; ch++) {
            System.out.print(ch + " ");
        }
        System.out.println();

        for (int i = 0; i < GRID_SIZE; i++) {
            if (i<10) {
                System.out.print(i + "   ");
            }
            else {
            System.out.print(i + "  ");
            }
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();

        }
    }

}