package game;

import battle.BattleManager;
import character.Police;
import character.Thief;

import java.util.Random;
import java.util.Scanner;

public class Main {


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

    }

    private void UpdateGame() throws Exception {
        boolean isFind = false;

        Scanner sc = new Scanner(System.in);
        int tempFloor;

        while (!isFind) {

            System.out.print("도둑이 숨은 층을 조사하여 체포 하십시오. ( 1 ~ 100층 )");
            tempFloor = sc.nextInt();
            if(tempFloor > 100 || tempFloor < 1)
            {
                System.out.println("1~100 사이의 숫자만 입력해주세요.");
                continue;
            }
            isFind = tempFloor == floor;
            if (isFind) {
                ConsoleText.printPoliceWithBaton();
                ConsoleText.playAnimation();
                System.out.println("도둑을 발견했다!!\n기절시켜서 감옥에 다시 데려다 놔야 한다 !! 저놈 잡아랏 !! ");

                Police police = new Police();
                Thief thief = new Thief();
                BattleManager battleManager = new BattleManager();
                battleManager.startBattle(police, thief);

                break;
            } else {
                System.out.println(tempFloor > floor ? "down" : " up");
            }
        }
        EndGame();

    }

    private void EndGame() {

        if(BattleManager.IsPoliceAlive()) {
            ConsoleText.printPoliceWithBaton();
            System.out.println("잡았다 이놈!");
        }
        else {
            ConsoleText.printThiefRunaway();
            System.out.println("아이쿠 ! 놓쳐버렸네 ! ");
        }
    }


}
