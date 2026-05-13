<p align="center">
<h2 ><p align="center">
  👮🦹<br/><<경찰과 도둑>>
</h2>
</p>
<p align="center"><b>죄수번호 206번이 탈출 하였다!!!!!!!!!!! 건물을 뒤져서 도둑을 찾아내라.</b><p>
<br>
</p>    

## 프로젝트 설명
- 
## 주요 기능
- 
## 팀원A - 신예은
### 주요 기능
- 게임 시작, 초기화, 종료처리 로직 구현
- 콘솔 텍스트 클래스 구현
### 클래스
- ConsoleText
- main
### 메소드
- start
- initGame
- UpdateGame
## 팀원B - 정해원
### 주요 기능
- 캐릭터 설계, 무기 시스템 구현, 전투 시스템 구현
### 클래스
#### 전투 시스템 클래스
- BattleManager
#### 캐릭터 클래스
- Character 부모 클래스
- Police / Thief 클래스
#### 무기 클래스
- Weapon 부모 클래스
- Gun / Shield / Sword / Teaser 클래스
### 메소드
- startBattle : 도둑을 발견했을때 시작하는 전투 시스템
```
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

``` 
- isDead() : 누군가 죽었는지 즉시 확인
- selectWeapon() : 무기 선택
- rolledDice() : 주사위 선택
- attack() : 공격 수행 (무기 선택 -> 주사위 -> 대미지 계산)
- getPortion() : HP가 100이하일때 계속 물약 사용 or 계속 공격 선택

## 실행 방법
- 
