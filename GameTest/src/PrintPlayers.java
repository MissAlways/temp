
import bean.Player;
import db.PlayerDao;
import java.util.List;

/**
 *
 * @author MissAlways
 */
public class PrintPlayers {

    public static void main(String[] args) throws InterruptedException {
        printAllPlayers();
    }

    public static void printAllPlayers() {
        PlayerDao playerDao;
        playerDao = new PlayerDao();
        List<Player> playerList = playerDao.getAllPlayers();

        Player player = new Player();
        if (playerList != null) {
            for (int i = 0; i < playerList.size(); i++) {
                player = playerList.get(i);

                System.out.println("Player " + i);
                System.out.println("Name: " + player.getName());
                System.out.println("MovingSpeed: " + player.getMovingSpeed());
                System.out.println("HP: " + player.getHealthMax());
                System.out.println("LVL: " + player.getLvl());
                System.out.println("--------------------------------------");
            }
        }
        else{
            System.out.println("Playerlist empty");
        }
    }
}
