import java.util.Random;

public class GameManager {
    private int floor;

    public GameManager(int number){
        floor = number;
    }


    public void setFloor(){
        System.out.println("GameManager");
        Random random = new Random();
        floor  = random.nextInt(0,99)+1;
        System.out.println(floor);
    }

    public int getFloor() {
        return floor;
    }
}
