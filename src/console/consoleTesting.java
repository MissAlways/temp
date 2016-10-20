package console;

import java.util.List;
import java.util.Scanner;

import bean.Item;
import bean.Player;
import db.ItemDao;
import db.PlayerDao;

/**
 * 
 * @author MissAlways
 *
 */
public class consoleTesting {
	private static String decoLine = "--------------------------------------";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			handleArguments(scan);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		} finally {
			scan.close();
			System.out.println("Cya later");
		}
	}

	private static void handleArguments(Scanner scan) {
		int id;
		System.out.print("Select option " + "\n0. quit." + "\n1. print all players" + "\n2. print player by id"
				+ "\n3. print all items" + "\n4. print item by id" + "\nYour choice: ");
		int choose = scan.nextInt();
		scan.nextLine();

		switch (choose) {
		case 0:
			System.out.println("Bye!");
			return;
		case 1:
			printAllPlayers();
			break;
		case 2:
			System.out.print("Id: ");
			id = scan.nextInt();
			scan.nextLine();
			printPlayerById(id);
			break;
		case 3:
			printAllItems();
			break;
		case 4:
			System.out.print("Id: ");
			id = scan.nextInt();
			scan.nextLine();
			printItemById(id);
		default:
			System.out.println("Wrong number");
			break;
		}
		handleArguments(scan);
	}

	private static void printItemById(int itemId) {
		ItemDao itemDao = new ItemDao();
		Item item = itemDao.getItem(itemId);

		System.out.println(item.toString());

	}

	private static void printAllItems() {
		ItemDao itemDao = new ItemDao();
		List<Item> itemList = itemDao.getAllItems();

		if (itemList != null) {
			// for(int i = 0; i < itemList.size(); i++){
			for (Item item : itemList) {
				System.out.println(item.toString());
				System.out.println(decoLine);
			}
		}

	}

	private static void printPlayerById(int playerId) {
		PlayerDao playerDao = new PlayerDao();
		Player player = playerDao.getPlayer(playerId);

		System.out.println(player.toString());
	}

	public static void printAllPlayers() {
		PlayerDao playerDao = new PlayerDao();
		List<Player> playerList = playerDao.getAllPlayers();

		if (playerList != null) {
			for (Player player : playerList) {
				System.out.println(player.toString());
				System.out.println(decoLine);
			}
		} else {
			System.out.println("Playerlist empty");
		}
	}
}
