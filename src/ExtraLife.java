public class ExtraLife extends PowerUp {
    @Override
    public void applyPowerUp(GameRules gameRules, GameService gameService) {
        gameRules.gainLife();
        System.out.println("Power-up activated: Extra Life!");
    }
}