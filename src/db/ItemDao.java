package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Item;


/**
 * 
 * @author MissAlways
 *
 */
public class ItemDao extends DataAccessObject{
	public List<Item> getAllItems() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		List<Item> itemList = new ArrayList<Item>();

		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			String sql = "SELECT itemId, name, incase, incaseAmount, cost FROM ITEM;";

			preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getInt("itemId"));
				item.setName(rs.getString("name"));
				item.setIncase(rs.getString("incase"));
				item.setIncaseAmount(rs.getInt("incaseAmount"));
				item.setCost(rs.getDouble("cost"));
				itemList.add(item);
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
		return itemList;
	}
}
