import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameService {
    private Grid grid;
    private List<Flag> flags;
    private Random random;

    public GameService(Grid grid) {
        this.grid = grid;
        this.flags = new ArrayList<>();
        this.random = new Random();
    }

    public void processCells(int row, int col) {
        Cell cell = grid.getCell(row, col);

        if (cell instanceof EmptyCell) {
            int numAdjacentMines = countAdjacentMines(row, col);
            cell.setDisplayValue((char) ('0' + numAdjacentMines));

            if (numAdjacentMines == 0) {
                clearAdjacentCells(row, col);
            }
        }
    }

    public void clearAdjacentCells(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;

                if (i == 0 && j == 0) {
                    continue;
                }

                    if (newRow >= 0 && newRow < grid.getGridSize() && newCol >= 0 && newCol < grid.getGridSize()) {
                        Cell neighboringCell = grid.getCell(newRow, newCol);
                        if (neighboringCell instanceof EmptyCell && neighboringCell.getDisplayValue() == '-') {
                            int numAdjacentMines = countAdjacentMines(newRow, newCol);
                            neighboringCell.setDisplayValue((char) (numAdjacentMines + '0'));
                            if (numAdjacentMines == 0) {
                                clearAdjacentCells(newRow, newCol);
                            }
                        }
                    }
            }
        }
    }
    public int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;

                if (i == 0 && j == 0) {
                    continue;
                }

                if (newRow >= 0 && newRow < grid.getGridSize() && newCol >= 0 && newCol < grid.getGridSize()) {
                    Cell neighboringCell = grid.getCell(newRow, newCol);
                    if (neighboringCell instanceof MineCell) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void revealAllMines() {
        for (int i = 0; i < grid.getGridSize(); i++) {
            for (int j = 0; j < grid.getGridSize(); j++) {
                Cell cell = grid.getCell(i, j);
                if (cell instanceof MineCell) {
                    cell.setDisplayValue('*');
                }
            }
        }
    }

    public void toggleFlag(int row, int col) {
        Flag flag = new Flag(row, col);
        if (flags.contains(flag)) {
            flags.remove(flag);
            grid.getCell(row, col).setFlagged(false);
        } else {
            flags.add(flag);
            grid.getCell(row, col).setFlagged(true);
        }
    }

    public void revealHitMine(int row, int col) {
        Cell cell = grid.getCell(row, col);
        if (cell instanceof MineCell) {
            cell.setDisplayValue('*');
        }
    }

    public void revealRandomMine() {
        int gridSize = grid.getGridSize();
        while (true) {
            int row = random.nextInt(gridSize);
            int col = random.nextInt(gridSize);
            Cell cell = grid.getCell(row, col);
            if (cell instanceof MineCell) {
                cell.setDisplayValue('*');
                break;
            }
        }
    }

    public void applyPowerUp(PowerUp powerUp, GameRules gameRules) {
            powerUp.applyPowerUp(gameRules, this);
    }
}
