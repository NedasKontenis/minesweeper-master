import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTests {

    @Test
    public void testSetAndGetCell() {
        Grid grid = new Grid(10);
        Cell testCell = new EmptyCell('F');
        int testRow = 5;
        int testCol = 5;

        grid.setCell(testCell, testRow, testCol);
        Cell retrievedCell = grid.getCell(testRow, testCol);

        assertEquals(testCell, retrievedCell);
    }

    @Test
    public void testGridInitializationWithEmptyCells() {
        int gridSize = 10;
        Grid grid = new Grid(gridSize);
        grid.initializeGrid();

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                assertTrue(grid.getCell(row, col) instanceof EmptyCell);
            }
        }
    }

    @Test
    public void testPlacementOfMineCells() {
        int gridSize = 10;
        Grid grid = new Grid(gridSize);
        Mine mine = new Mine(10, grid);
        mine.initializeMineField(gridSize);

        int mineCount = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (grid.getCell(row, col) instanceof MineCell) {
                    mineCount++;
                }
            }
        }

        assertEquals(10, mineCount);
    }
}
