import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int gridSize = 10;
        int numMines = 15;

        Grid grid = new Grid(gridSize);
        Mine mine = new Mine(numMines, grid);
        GameService gameService = new GameService(mine, grid);
        GameRules gameRules = new GameRules(mine, grid);

        grid.initializeGrid();
        mine.initializeMineField(grid.getGridSize());

        grid.printGrid();
        Scanner scanner = new Scanner(System.in);

        while (!gameRules.isGameOver()) {

            System.out.print("Enter row and column (e.g., 1 2): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (gameRules.hasHitMine(row, col)){
                System.out.println("Game is over! You hit a mine!");
                break;
            } else {
                gameService.processCells(row, col);
                grid.printGrid();

                if (gameRules.isGameWon()) {
                    System.out.println("Congratulations! You win!");
                    break;
                }
            }
        }

        scanner.close();
    }
}