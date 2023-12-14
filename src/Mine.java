import java.util.Random;

public class Mine {
    private int numMines;
    private Grid grid;

    public Mine(int numMines, Grid grid) {
        this.numMines = numMines;
        this.grid = grid;
    }

    public int getNumMines() {
        return numMines;
    }

    public void initializeMineField(int gridSize) {
        Random rand = new Random();
        for (int i = 0; i < numMines; i++) {
            int row, col;
            do {
                row = rand.nextInt(gridSize);
                col = rand.nextInt(gridSize);
            } while (grid.getCell(row, col) instanceof MineCell);
            grid.setCell(new MineCell(), row, col);
        }
    }
}
