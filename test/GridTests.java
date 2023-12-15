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

        assertEquals(testCell, retrievedCell, "Retrieved cell should be the one that was set");
    }
}
