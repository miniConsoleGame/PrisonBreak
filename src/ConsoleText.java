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
    
    긴급사태 긴급 사 ~ 태 ~
    죄수번호 206번이 탈출 하였다!!!!!!!!!!!
    죄수번호 206번이 탈출 하였다!!!!!!!!!!!!!!!!
    
    건물을 뒤져서 도둑을 찾아내라
    
    

################################################
""");

        System.out.print("도둑이 숨은 층을 조사하여 체포 하십시오. ( 1 ~ 100층 )");
        int floor = scanner.nextInt();

    }
}
