package game;

import java.util.Scanner;

public class ConsoleText {


    public static void Intro(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
################################################

        [ SECURITY ALERT ]

        🚨 위잉-- 🚨 위잉--
    🚨 위잉-- 🚨 위잉-- 🚨 위잉--

    >>> PRISON BREAK DETECTED <<<
    >>> ALL UNITS DEPLOYED <<<
    
       공습경보-- 공습경보--
    죄수번호 206번이 탈출 하였다!!!!!!!!!!!
    죄수번호 206번이 탈출 하였다!!!!!!!!!!!!!!!!
    
    건물을 뒤져서 도둑을 찾아내라
    
    

################################################
""");



    }

    public static void printPolice() {

        System.out.println("""
              _______
             / _____ \\
            / /     \\ \\
           | |  O O  | |
           | |   ^   | |
           | |  ---  | |
            \\ \\_____ / /
             \\_______/
                | |
           ____/   \\____
          /  _  POLICE  _ \\
         /__/___________\\__\\
             /   | |   \\
            /____|_|____\\
               /  |  \\
              /___|___\\
        """);
    }
    public static void printPoliceWithBaton(){
        System.out.println("""
            _______
           /       \\
          /  -----  \\            //
         /  |  o o|  \\          //
         |  |   ^ |  |         //
         |  | --- |  |        //
         |   \\___/   |       //
          \\         /       //
           \\_______/       //
              ||          //
          ____||____     //
         /   POLICE \\   //
        /____________\\ //
            |  ||      //
            |  ||     //
            |  ||    //
           /   ||   //
          /____||__//__
               ||
              /  \\
             /____\\
""");
    }
    public static void printPoliceWithShield(){
        System.out.println("""
                    __________________
                   /\\\\               \\
            ______/  \\\\               \\
           /       \\  ||               \\
          /  -----  \\ ||                |
         /  |  o o|  \\||                |
         |  |   ^ |  |||    RIOT       |
         |  | --- |  |||    SHIELD     |
         |   \\___/   |||               |
          \\         / ||               |
           \\_______/  ||               |
              ||      ||               |
          ____||____  ||               |
         /   POLICE \\ ||              /
        /____________\\||             /
            |  ||      \\\\           /
            |  ||       \\\\_________/
            |  ||       
           /   ||   \\
          /____||____\\\\
               ||
              /  \\
             /____\\
""");

    }
    public static void printThiefRunaway(){
        System.out.println("""
              \\o/
               |
              / \\
          ___/___\\___
         /   THIEF   /
        /___________/
             $$$
            $$$$$

        THIEF RUNNING AWAY >>>>>>>>
""");
    }
    public static void playAnimation() throws Exception
    {
        String[] frames = {
                """
                  \\o/
                   |
                  / \\
             THIEF RUNNING  >
                """,
                """
                   o/
                  /|
                  / \\
             THIEF RUNNING  >>
                """,
                """
                  \\o
                   |\\
                  / \\
             THIEF RUNNING  >>>
                """
        };

        for (int i = 0; i < 10; i++) {
            for (String frame : frames) {
                clearConsole();
                System.out.println(frame);
                Thread.sleep(30);
            }
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
