public class GameConfig {
    private static GameConfig instance;

    private int gridSize;
    private int numMines;

    private GameConfig(int gridSize, int numMines) {
        this.gridSize = gridSize;
        this.numMines = numMines;
    }

    public static GameConfig getInstance(int gridSize, int numMines) {
        if (instance == null) {
            instance = new GameConfig(gridSize, numMines);
        }
        return instance;
    }

    public int getGridSize() {
        return gridSize;
    }

    public int getNumMines() {
        return numMines;
    }
}