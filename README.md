<p align="center">
<h2 ><p align="center">
  👮🦹<br/><<경찰과 도둑>>
</h2>
</p>
    <p align="center"><b>🚨위잉-- 🚨위잉-- 🚨위잉--</b><p> 
<p align="center"><b>죄수번호 206번이 탈출 하였다!!!!!!!!!!! 건물을 뒤져서 도둑을 찾아내라.</b><p>
<br>
</p>    

## 프로젝트 설명
### 경찰과 도둑: 빌딩 추격전 게임
#### 1단계: 도둑의 은신처 찾기 (Up & Down)
- 목표: 1층부터 100층 사이에 숨어있는 도둑의 층수를 맞추어야 합니다.
- 기회: 총 10번의 입력 기회가 주어집니다.
- 진행 방식 : Scanner를 통해 예상하는 층수를 입력합니다.
   - 도둑이 있는 층보다 낮으면 Up, 높으면 Down 힌트를 제공합니다.
   - 10번 안에 맞추지 못하면 도둑 검거에 실패합니다.
#### 2단계: 도둑과의 결투
도둑을 발견하면 기절시켜 감옥으로 보내기 위한 전투가 시작됩니다.
##### 진행 규칙
1. 승리 조건: 경찰 또는 도둑 중 한 명의 HP가 0이 될 때까지 싸움을 진행합니다.
2. 무기 선택: 매 턴마다 네가지 무기 중 하나를 선택할 수 있습니다.
- 🔫총 : 데미지 40 / 방어력 50
- 🛡️방패 : 데미지 30 / 방어력 70
- 🗡️칼 : 데미지 70 / 방어력 10
- ⚡ 테이저건 : 데미지 55 / 방어력 25
4. 전투 판정: 무기 선택 후 확률(랜덤 숫자 0 또는 1)에 따라 공격 성패가 결정됩니다.
   - 숫자 1: 데미지 만큼 도둑의 HP 감소
   - 숫자 0: 도둑의 공격력(100 - 각 무기의 방어력) 만큼 경찰의 HP 감소
5.  회복 물약 시스템
- 경찰의 HP가 100 이하로 떨어지면 물약 사용 여부를 묻는 창이 뜹니다.
- 물약 사용 시 HP 50이 즉시 회복됩니다.
- 게임 중 사용할 수 있는 물약의 총 횟수는 3회입니다.

#### 최종 결과
- 도둑 HP 0: 검거 성공! 도둑 감옥행
- 경찰 HP 0: 검거 실패... 도둑 탈출

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
- 캐릭터 설계, 무기 시스템 구현
- 전투 시스템 구현
### 클래스
```
BattleManager (전투 시스템 클래스)

Character (캐릭터 클래스)
 ├── Police
 └── Thief

Weapon (무기 클래스)
 ├── Gun
 ├── Shield
 ├── Sword
 └── Teaser
```
### 메소드
- startBattle : 경찰이 도둑을 발견했을때 시작하는 전투 시스템
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
