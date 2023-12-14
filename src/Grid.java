public class Grid {
    private int gridSize;
    private Cell[][] grid;

    public Grid(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new Cell[gridSize][gridSize];
    }

    public int getGridSize() {
        return gridSize;
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public void setCell(Cell cell, int row, int col) {
        grid[row][col] = cell;
    }

    public void initializeGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = new EmptyCell();
            }
        }
    }

    public void printGrid() {
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        System.out.println("  ---------------------");
        for (int i = 0; i < gridSize; i++) {
            System.out.print((i + 1) + "| ");
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j].getDisplayValue() + " ");
            }
            System.out.println();
        }
        System.out.println("  ---------------------");
    }
}
