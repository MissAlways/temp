package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import bean.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MissAlways
 */
public class PlayerDao extends DataAccessObject {

	public List<Player> getAllPlayers() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		List<Player> playerList = new ArrayList<Player>();

		try {

			connection = getConnection();
			connection.setAutoCommit(false);
			String sql = "SELECT playerId, name, healthCurrent, hunger, happiness, money FROM PLAYER;";

			preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Player player = new Player();
				player.setPlayerId(rs.getInt("playerId"));
				player.setName(rs.getString("name"));
				player.setHealth(rs.getInt("healthCurrent"));
				player.setHunger(rs.getInt("hunger"));
				player.setHappiness(rs.getInt("happiness"));
				player.setMoney(rs.getDouble("money"));
				playerList.add(player);
			}

			connection.commit();
		} catch (Exception ex) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				ex.printStackTrace();
			}
			throw new RuntimeException(ex);
		} finally {
			close(preparedStatement, connection);
		}
		return playerList;
	}

	public Player getPlayer(int playerId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Player player = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			String sql = "SELECT playerId, name, healthCurrent, hunger, happiness, money FROM PLAYER WHERE playerId=?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, playerId);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				player = new Player();
				player.setPlayerId(rs.getInt("playerId"));
				player.setName(rs.getString("name"));
				player.setHealth(rs.getInt("healthCurrent"));
				player.setHunger(rs.getInt("hunger"));
				player.setHappiness(rs.getInt("happiness"));
				player.setMoney(rs.getDouble("money"));
			}

			connection.commit();
		} catch (Exception ex) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				ex.printStackTrace();
			}
			throw new RuntimeException(ex);
		} finally {
			close(preparedStatement, connection);
		}

		return player;
	}

}
