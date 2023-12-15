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
                grid[i][j] = new EmptyCell('-');
            }
        }
    }

    public void printGrid() {
        int rowNumberWidth = String.valueOf(gridSize).length();

        System.out.print("     ");
        for (int col = 1; col <= gridSize; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        System.out.println("  -----------------------");
        for (int i = 0; i < gridSize; i++) {
            System.out.printf("%" + rowNumberWidth + "d | ", i + 1);
            for (int j = 0; j < gridSize; j++) {
                Cell cell = grid[i][j];
                if (cell.isFlagged()) {
                    System.out.print("F ");
                } else {
                    System.out.print(cell.getDisplayValue() + " ");
                }
            }
            System.out.println();
        }
        System.out.println("  -----------------------");
    }
}
