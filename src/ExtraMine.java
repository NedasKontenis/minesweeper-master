public class ExtraMine extends PowerUp {
    @Override
    public void applyPowerUp(GameRules gameRules, GameService gameService) {
        gameService.revealRandomMine();
        System.out.println("Power-up activated: Extra Mine Revealed!");
    }
}