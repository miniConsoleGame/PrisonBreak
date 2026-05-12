package battle;
import character.Police;
import character.Thief;
import weapon.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import game.ConsoleText;

public class BattleManager {
    Scanner sc = new Scanner(System.in);
    Police police = new Police();
    Thief thief = new Thief();
    static boolean isPoliceAlive;

    Weapon[] weapon = new Weapon[4];
    {
        weapon[0] = new Gun();
        weapon[1] = new Shield();
        weapon[2] = new Sword();
        weapon[3] = new Taser();
    }

    int seletedWeapon;
    int dice;

    public BattleManager() {
    }

    public void startBattle(Police police, Thief thief){
        this.police = police;
        this.thief = thief;
        isPoliceAlive= true;
        int countHPPotion = 3;

        System.out.print("\n[ \uD83C\uDFAF 타겟 포착 ]\n" +
                "도둑을 발견했습니다! 감옥으로 돌려보내려면 제압이 필요합니다.");
        System.out.print("\n" +
                "┌─── \uD83D\uDD0D 무기 선택 가이드 ──────────────────┐\n" +
                "│ 각 무기는 [공격력]과 [방어력]이 다릅니다.    │\n" +
                "│ 공격력이 높으면 도둑을 빨리 기절시킬 수 있고  │\n" +
                "│ 방어력이 높으면 도둑의 기습으로부터 안전합니다.│\n" +
                "└────────────────────────────────────────┘\n");

        while(true){
            // 1. 공격 수행 (무기 선택 -> 주사위 -> 대미지 계산)
            attack(selectWeapon()-1, rolledDice());
            // 2. 누군가 죽었는지 즉시 확인
            if(isDead()){
                break;
            };
            // 3. 공격 후 경찰 체력이 100 이하이고 물약이 남아있다면 물어보기
            if(police.getHP() <= 100){
                    String choice = getPortion();

                    if(choice.equals("P")){
                        System.out.println("\"물약 사용\" 선택");
                        if(countHPPotion <= 0) {
                            System.out.println("● 사용 가능한 물약을 모두 사용하였습니다. 남은 물약 갯수 : "+countHPPotion);
                        }else{
                            police.setHP(police.getHP() + 50);
                            countHPPotion--;
                            System.out.println("● 물약을 사용 하였습니다. 경찰의 HP가 50 회복 됩니다. \n● 남은 물약 갯수 : "+countHPPotion+", 경찰의 HP : "+police.getHP()+", 도둑의 HP: "+thief.getHP());
                        }

                    }else if(choice.equals("A")){
                        System.out.println("\"계속 공격\" 선택");
                    }
            }
        }
    }

    public boolean isDead(){

        if(police.getHP()<=0){
            ConsoleText.printThiefRunaway();
            isPoliceAlive = false;
            return true;
        }
        if (thief.getHP()<=0){
            ConsoleText.printPolice();
            return true;
        }
        return false;
    }

    public int selectWeapon(){

        boolean isSeleted = false;
        int seletedWeapon = 0;

        while(!isSeleted){
            try{
                    System.out.println("\n● 보유한 무기 리스트");
                    for (int i = 0; i < weapon.length; i++) {
                        System.out.println("+"+(i + 1) + "번. " + weapon[i].toString());
                    }
                    System.out.print("☞ 사용할 무기의 번호를 입력 해주세요. : ");
                    seletedWeapon = sc.nextInt();

                    if ((seletedWeapon) > weapon.length) {
                        System.out.println("보유한 무기가 아닙니다. 다시 골라주세요!");
                        isSeleted = false;
                    } else {
                        isSeleted = true;
                        System.out.println("\n[ 무기 선택 완료: "+weapon[seletedWeapon-1].getName()+" ] -------------------------" );
                    }
                }
            catch(InputMismatchException e){
                System.out.println("잘못된 입력입니다. 숫자(번호)만 입력해주세요!");
                sc.nextLine();
            }
        }

        return seletedWeapon;
    }

    public int rolledDice(){
        int dice = (int)(Math.random() * 2);
        System.out.println("\n\uD83C\uDFB2 상황 발생! 주사위를 던집니다... [ 결과: "+dice+" ]");
        switch (dice){
            case 0 :
                System.out.println("⚠\uFE0F [경찰 피습!] 도둑이 빈틈을 노려 공격했습니다!\n" +
                        "  - 경찰 피해 발생: (100 - 무기의 방어력) 만큼 '경찰'의 HP 감소\n");
                break;
            case 1 :
                System.out.println("\uD83C\uDFAF [경찰 피격!] 경찰이 도둑을 명중시켰습니다!\n" +
                        "  - 도둑에게 입힌 피해: (무기의 공격력) 만큼 '도둑'의 HP 감소\n");
                break;
        }

        return dice;
    }

    public void attack(int seletedWeapon, int dice){
        switch (dice){
            case 0 :
                police.setHP( police.getHP() - (100 - weapon[seletedWeapon].getDefense()) );
                break;
            case 1 :
                thief.setHP( thief.getHP() - weapon[seletedWeapon].getDamage() );
                break;
        }
        System.out.println("================ 위태로운 대치 상황 ================\n" +
                "\n" +
                "   [ \uD83D\uDC6E POLICE ]           [ \uD83E\uDDB9 THIEF ]   \n" +
                "    HP : "+police.getHP()+"                HP : "+thief.getHP()+"   \n" +
                "\n" +
                "--------------------------------------------------");
        if(police.getHP()>thief.getHP()){
            System.out.println("\uD83D\uDCE2 승리의 기운이 느껴집니다! 도둑이 겁에 질려 휘청거립니다!");
        }else{
            System.out.println("⚠\uFE0F 경찰의 체력이 도둑보다 낮습니다! 주의하세요!");
        }
    }

    public String getPortion(){
        boolean optionSeleted = false;
        String option = "";
        while(!optionSeleted){
            System.out.print("\n\uD83C\uDD98 [ 긴급 상황 발생 ] --------------------------\n" +
                    "경찰의 호흡이 거칠어지고 상처가 깊습니다! \n" +
                    "선택의 기로:\n" +
                    " [ P ] \uD83E\uDDEA 물약 사용 : 일단 후퇴하여 상처를 치료한다.\n" +
                    " [ A ] \uD83D\uDDE1\uFE0F 강습 지속 : 위험을 무릅쓰고 끝까지 추격한다.\n" +
                    "----------------------------------------------\n" +
                    "\uD83D\uDC49 전략적 결정을 내리십시오 (P/A) : ");
            option = sc.next();

            if( !(option.equals("P") || option.equals("A")) ){
                System.out.println("● (P/A) 중에 선택해주세요!");
                optionSeleted = false;
            }else{
                optionSeleted = true;
            }
        }
        return option;
    }

    public static Boolean IsPoliceAlive(){
        return isPoliceAlive;
    }


}
