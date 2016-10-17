package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import db.PlayerDao;
import java.util.List;
import bean.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MissAlways
 */
public class PlayerDao extends DataAccessObject{
    
    public List<Player> getAllPlayers(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        List<Player> playerList = new ArrayList<Player>();
        
        try {
           
            connection = getConnection();
            connection.setAutoCommit(false);
            String sql = "SELECT playerId, name, movingSpeed, helthMax, lvl FROM player;";
            
            preparedStatement = connection.prepareStatement(sql);
             
            rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Player player = new Player();
                player.setPlayerId(rs.getInt("playerId"));
                player.setName(rs.getString("name"));
                player.setMovingSpeed(rs.getInt("movingSpeed"));
                player.setHealthMax(rs.getInt("helthMax"));
                player.setLvl(rs.getInt("lvl"));
                System.out.println(player.toString());
                playerList.add(player);
            }
            
            connection.commit();
        } catch (Exception ex) {
            try{
                connection.rollback();
            }catch(SQLException e){
                ex.printStackTrace();
            }
            throw new RuntimeException(ex);
        } finally{
            close(preparedStatement, connection);
        }
        return playerList;
    }
}
