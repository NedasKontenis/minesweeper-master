import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameConfig config = GameConfig.getInstance(10, 15);

        Grid grid = new Grid(config.getGridSize());
        Mine mine = new Mine(config.getNumMines(), grid);
        GameService gameService = new GameService(grid);
        GameRules gameRules = new GameRules(mine, grid);
        PowerUp extraLife = new ExtraLife();
        PowerUp extraMine = new ExtraMine();
        GameInvoker invoker = new GameInvoker();

        grid.initializeGrid();
        mine.initializeMineField(grid.getGridSize());

        Scanner scanner = new Scanner(System.in);
        int attempt = 0;

        while (gameRules.hasLives()) {
            if (attempt == 0) {
                gameService.applyPowerUp(extraMine, gameRules);
            }
            else if (attempt % 10 == 0) {
                gameService.applyPowerUp(extraLife, gameRules);
            }

            grid.printGrid();
            System.out.print("Enter row and column to open cell or 'F' to toggle a flag (e.g., 1 2 or F 1 2): ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length == 3 && parts[0].equalsIgnoreCase("F")) {
                int row = Integer.parseInt(parts[1]) - 1;
                int col = Integer.parseInt(parts[2]) - 1;
                Command placeFlag = new PlaceFlagCommand(gameService, row, col);
                invoker.executeCommand(placeFlag);
            } else if (parts.length == 2) {
                int row = Integer.parseInt(parts[0]) - 1;
                int col = Integer.parseInt(parts[1]) - 1;

                if (gameRules.hasHitMine(row, col)) {
                    gameService.revealHitMine(row, col);
                    gameRules.loseLife();
                    if (gameRules.hasLives()) {
                        System.out.println("You hit a mine! Lives remaining: " + gameRules.getLives());
                    } else {
                        gameService.revealAllMines();
                        grid.printGrid();
                        System.out.println("Game over! You have no more lives.");
                        break;
                    }
                } else {
                    gameService.processCells(row, col);

                    if (gameRules.isGameOver()) {
                        grid.printGrid();
                        System.out.println("Congratulations! You win!");
                        break;
                    }
                }
            }
            attempt++;
        }

        scanner.close();
    }
}