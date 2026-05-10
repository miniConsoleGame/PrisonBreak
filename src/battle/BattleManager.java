package battle;
import character.Police;
import character.Thief;
import weapon.Gun;
import weapon.Shield;
import weapon.Sword;
import weapon.Weapon;

import java.util.Scanner;

public class BattleManager {
    Scanner sc = new Scanner(System.in);
    Police police = new Police();
    Thief thief = new Thief();

    Weapon[] weapon = new Weapon[3];
    {
        weapon[0] =  new Gun();
        weapon[1] = new Shield();
        weapon[2] = new Sword();
    }

    int seletedWeapon;
    int dice;

    public BattleManager() {
    }

    public void startBattle(Police police, Thief thief){
        this.police = police;
        this.thief = thief;
        int countHPPotion = 3;

        while(true){

            if(isDead()){
                break;
            };

            attack(selectWeapon()-1, rolledDice());

            if(police.getHP() <= 100){
                    String isPortionUsed = getPortion();

                    if(isPortionUsed.equals("P")){
                        System.out.println("\"물약 사용\" 선택");

                        if(countHPPotion <= 0) {
                            System.out.println("● 사용 가능한 물약을 모두 사용하였습니다. 남은 물약 갯수 : "+countHPPotion);
                        }else{
                            police.setHP(police.getHP() + 50);
                            countHPPotion--;
                            System.out.println("● 물약이 사용 됐습니다. 남은 물약 갯수 : "+countHPPotion+", 경찰의 HP : "+police.getHP()+", 도둑의 HP: "+thief.getHP());
                        }

                    }else if(isPortionUsed.equals("A")){
                        System.out.println("\"계속 공격\" 선택");
                        attack(selectWeapon()-1, rolledDice());

                    }

            }
        }

    }

    public boolean isDead(){

        if(police.getHP()<=0){
            System.out.print("! 경찰 HP 0 이하. 아쉽게도 도둑이 탈출하였습니다.(ㅜ.ㅜ) 게임이 종료 됩니다...");
            return true;
        }
        if (thief.getHP()<=0){
            System.out.print("! 도둑 HP 0 이하. 도둑은 체포하고 감옥에 보냈습니다.(^0^) 게임이 종료 됩니다...");
            return true;
        }
        return false;
    }

    public int selectWeapon(){

        boolean isSeleted = false;
        int seletedWeapon = 0;

        while(!isSeleted)
            {
            System.out.println("● 보유한 무기");
            for(int i=0; i<weapon.length; i++){
                System.out.println("+무기 "+(i+1)+"번. "+weapon[i].toString());
            }
            System.out.print("☞ 사용할 무기의 번호를 입력 해주세요. : ");
            seletedWeapon = sc.nextInt();

            if((seletedWeapon) > weapon.length){
                System.out.println("보유한 무기가 아닙니다. 다시 골라주세요!");
                isSeleted = false;
            }
            else{
                isSeleted = true;
            }
        }

        return seletedWeapon;
    }

    public int rolledDice(){

        System.out.println("● 랜덤 숫자 뽑기! \n0 ⇒ 도둑의 공격력(100 - 각 무기의 방어력) 만큼 경찰의 HP 감소" +
                "\n1 ⇒ 데미지 만큼 도둑의 HP 감소 ");
        int dice = (int)(Math.random() * 2);
        System.out.println("나온 숫자 : "+dice);

        return dice;
    }

    public void attack(int seletedWeapon, int dice){
        switch (dice){
            case 0 :
                if(seletedWeapon == 0){
                    police.setHP( police.getHP() - (100 - weapon[0].getDefense()) );
                }else if(seletedWeapon == 1){
                    police.setHP( police.getHP() - (100 - weapon[1].getDefense()) );
                }else if(seletedWeapon == 2){
                    police.setHP( police.getHP() - (100 - weapon[2].getDefense()) );
                }
                break;
            case 1 :
                if(seletedWeapon == 0){
                    thief.setHP( thief.getHP() - weapon[0].getDamage() );
                }else if(seletedWeapon == 1){
                    thief.setHP( thief.getHP() - weapon[1].getDamage() );
                }else if(seletedWeapon == 2){
                    thief.setHP( thief.getHP() - weapon[2].getDamage() );
                }
                break;
        }
        System.out.println("● 경찰의 HP: "+police.getHP()+", 도둑의 HP: "+thief.getHP());

    }

    public String getPortion(){
        boolean optionSeleted = false;
        String option = "";
        while(!optionSeleted){
            System.out.print("☞ 물약 사용(P),계속 공격(A)? (P/A) 입력 : ");
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


}
