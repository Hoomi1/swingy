package ft.school21.swing.java.view;

public class ChoiceGame {
    private static GameView view;

    public ChoiceGame(GameView gameView) {
        this.view = gameView;
    }

    public GameView getView() {
        return view;
    }
}
