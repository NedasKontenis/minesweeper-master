public class GameRules {
    private Mine mine;
    private Grid grid;
    private int lives;

    public GameRules(Mine mine, Grid grid) {
        this.mine = mine;
        this.grid = grid;
        this.lives = 3;
    }

    public boolean isGameOver() {
        int uncoveredCells = 0;
        for (int i = 0; i < grid.getGridSize(); i++) {
            for (int j = 0; j < grid.getGridSize(); j++) {
                Cell cell = grid.getCell(i, j);
                if (!(cell instanceof MineCell) && cell.getDisplayValue() != '-') {
                    uncoveredCells++;
                }
            }
        }

        return uncoveredCells + mine.getNumMines() == grid.getGridSize() * grid.getGridSize();
    }

    public boolean hasHitMine(int row, int col) {
        Cell cell = grid.getCell(row, col);
        return cell instanceof MineCell;
    }

    public void loseLife() {
        if (lives > 0) {
            lives--;
        }
    }

    public boolean hasLives() {
        return lives > 0;
    }

    public int getLives() {
        return lives;
    }

    public void gainLife() {
        lives++;
    }
}
