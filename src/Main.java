import java.util.Random;

public class Main {

    boolean isPoliceAlive;
    GameManager gameManager;
    Random random;

    public static void main(String[] args) {

        Main main = new Main();
        main.Start();
    }

    private void Start() {
        InitGame();
        ConsoleText.Intro();
        UpdateGame();
        random = new Random();
    }

    private void InitGame(){
        System.out.println("initGame");
        gameManager = new GameManager(12);
        gameManager.setFloor();
        System.out.println(gameManager.getFloor());


    }

    private void UpdateGame() {

        while (isPoliceAlive)
        {

        }
    }


}
