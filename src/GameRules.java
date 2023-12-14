public class GameRules {
    private Mine mine;
    private Grid grid;

    public GameRules(Mine mine, Grid grid) {
        this.mine = mine;
        this.grid = grid;
    }


    public boolean isGameOver() {
        for (int i = 0; i < grid.getGridSize(); i++) {
            for (int j = 0; j < grid.getGridSize(); j++) {
                Cell cell = grid.getCell(i, j);
                if (cell instanceof MineCell && cell.getDisplayValue() == '*') {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasHitMine(int row, int col) {
        Cell cell = grid.getCell(row, col);
        return cell instanceof MineCell;
    }

    public boolean isGameWon() {
        int uncoveredCells = 0;
        for (int i = 0; i < grid.getGridSize(); i++) {
            for (int j = 0; j < grid.getGridSize(); j++) {
                Cell cell = grid.getCell(i, j);
                if (cell instanceof EmptyCell && cell.getDisplayValue() == '-') {
                    return false;
                }

                if (cell.getDisplayValue() != '-') {
                    uncoveredCells++;
                }
            }
        }
        return uncoveredCells + mine.getNumMines() == grid.getGridSize() * grid.getGridSize();
    }
}
