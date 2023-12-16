import static org.junit.Assert.*;
import org.junit.Test;

public class GameRulesTests {

    @Test
    public void testGameOverCondition() {
        Grid grid = new Grid(10);
        Mine mine = new Mine(10, grid);
        GameRules gameRules = new GameRules(mine, grid);

        grid.initializeGrid();
        mine.initializeMineField(grid.getGridSize());
        simulateUncoveringAllNonMineCells(grid);

        assertTrue(gameRules.isGameOver());
    }

    @Test
    public void testLifeManagement() {
        Grid grid = new Grid(10);
        Mine mine = new Mine(10, grid);
        GameRules gameRules = new GameRules(mine, grid);

        gameRules.loseLife();
        assertEquals(2, gameRules.getLives());

        gameRules.gainLife();
        assertEquals(3, gameRules.getLives());
    }

    private void simulateUncoveringAllNonMineCells(Grid grid) {
        int gridSize = grid.getGridSize();
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                Cell cell = grid.getCell(row, col);
                if (!(cell instanceof MineCell)) {
                    cell.setDisplayValue('0');
                }
            }
        }
    }
}