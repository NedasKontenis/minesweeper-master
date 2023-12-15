// Command for placing a flag
public class PlaceFlagCommand implements Command {
    private GameService gameService;
    private int row, col;

    public PlaceFlagCommand(GameService gameService, int row, int col) {
        this.gameService = gameService;
        this.row = row;
        this.col = col;
    }

    @Override
    public void execute() {
        gameService.toggleFlag(row, col);
    }
}