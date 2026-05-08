import java.util.Random;
import java.util.Scanner;

public class Main {

    boolean isPoliceAlive;
    int floor;


    public static void main(String[] args) throws Exception {

        Main main = new Main();
        main.Start();
    }

    private void Start() throws Exception {
        InitGame();
        ConsoleText.Intro();


        UpdateGame();

    }

    private void InitGame() {
        System.out.println("      ------------InitGame------------");
        Random random = new Random();
        floor = random.nextInt(1, 101);
        System.out.println(floor);
        isPoliceAlive = true;
    }

    private void UpdateGame() throws Exception {
        boolean isFind = false;

        Scanner sc = new Scanner(System.in);
        int tempFloor;

        while (!isFind) {
            System.out.print("도둑이 숨은 층을 조사하여 체포 하십시오. ( 1 ~ 100층 )");
            tempFloor = sc.nextInt();
            isFind = tempFloor == floor;
            if (isFind) {
                ConsoleText.printPoliceWithBaton();
                ConsoleText.playAnimation();
                System.out.println("도둑을 발견했다!!\n기절시켜서 감옥에 다시 데려다 놔야 한다 !! 저놈 잡아랏 !! ");
                break;
            } else {
                System.out.println(tempFloor > floor ? "down" : " up");
            }
        }
//        while (isPoliceAlive) {  }


    }


}
