package com.maksim.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    public static final String DB_NAME = "TestGame";

    private String URL = "jdbc:mariadb://localhost:3306/DungeonRun";

    private String USER = "root";
    private String password = "";

    Connection connection;

    public void open () {
        try {
            connection = DriverManager.getConnection(URL, USER, password);
            System.out.println("Database connected");

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String createTablePlayer () {
        String sql = "CREATE TABLE player (PlayerID INT NOT NULL AUTO_INCREMENT, Name VARCHAR(100), Health INT, Strength INT, Agility INT, Intelligence INT, Exp INT, Level INT, enemies_defeated INT, primary KEY(PlayerID))";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

            return "Something went wrong";

        }
        return "Table created";
    }

    public int createPlayer (Player p1) {

        int incrementID = 0;
        String sql = "INSERT INTO player (name, health, strength, agility, intelligence, exp, level, enemies_defeated ) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {


            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, p1.getName());
            preparedStatement.setInt(2, p1.getHealth());
            preparedStatement.setInt(3, p1.getStrength());
            preparedStatement.setInt(4, p1.getAgility());
            preparedStatement.setInt(5, p1.getIntelligence());
            preparedStatement.setInt(6, p1.getExp());
            preparedStatement.setInt(7, p1.getLevel());
            preparedStatement.setInt(8, p1.getEnemiesDefeated());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                incrementID = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return incrementID;
    }

    public int createMonster (Monster newMonster) {

        int incrementID = 0;
        String sql = "INSERT INTO monster (name) values (?)";

        try {


            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newMonster.getName());
            //preparedStatement.setInt(2, newPlayer.getHealth());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                incrementID = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return incrementID;
    }

    public int createMonster2 (Monster newMonster) {

        int incrementID = 0;
        String sql = "INSERT INTO monster2 (name, health) values (?, ?)";

        try {


            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newMonster.getName());
            preparedStatement.setInt(2, newMonster.getHealth());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                incrementID = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return incrementID;
    }

    public int createMonster3 (Monster m1) {

        int incrementID = 0;
        String sql = "INSERT INTO monster3 (name, health) values (?, ?)";

        try {


            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, m1.getName());
            preparedStatement.setInt(2, m1.getHealth());
            //preparedStatement.setString(3, m1.getName());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                incrementID = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return incrementID;
    }

    public String createTableMonster() {
        String sql = "CREATE TABLE monster (monsterID INT NOT NULL AUTO_INCREMENT, name VARCHAR(100), primary KEY(monsterID))";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

            return "Something went wrong";

        }
        return "Table created";
    }

    public String createAnotherMonsterTable () {
        String sql = "CREATE TABLE monster2 (monsterID INT NOT NULL AUTO_INCREMENT, type VARCHAR(100), health int, primary KEY(monsterID))";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

            return "Something went wrong";

        }
        return "Table created";
    }

    public String createMonsterTable3 () {
        String sql = "CREATE TABLE monster3 (monsterID INT NOT NULL AUTO_INCREMENT, name VARCHAR(100), health int, primary KEY(monsterID))";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

            return "Something went wrong";

        }
        return "Table created";
    }

    public int updateCategory(String name, int id) {

        String sql = "UPDATE categories set CategoryName = ?  where CategoryID = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int updateEnemiesDefeated (Player p1) {

        String sql = "UPDATE player set enemies_defeated = ?  where Name = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p1.getEnemiesDefeated());
            preparedStatement.setString(2, p1.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int updateExp (Player p1) {

        String sql = "UPDATE player set exp = ?  where Name = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p1.getExp());
            preparedStatement.setString(2, p1.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int updateLevel (Player p1) {

        String sql = "UPDATE player set level = ?  where Name = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p1.getLevel());
            preparedStatement.setString(2, p1.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int updateHealth (Player p1) {

        String sql = "UPDATE player set health = ?  where Name = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p1.getHealth());
            preparedStatement.setString(2, p1.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int updateStrength (Player p1) {

        String sql = "UPDATE player set strength = ?  where Name = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p1.getStrength());
            preparedStatement.setString(2, p1.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int updateIntelligence (Player p1) {

        String sql = "UPDATE player set intelligence = ?  where Name = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p1.getIntelligence());
            preparedStatement.setString(2, p1.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int updateAgility (Player p1) {

        String sql = "UPDATE player set agility = ?  where Name = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p1.getAgility());
            preparedStatement.setString(2, p1.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }


    public String getPlayerWithId(int id) {

        String sql = "SELECT * from player where PlayerID = ?";
        String playerName;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                playerName = rs.getString("name");
                return playerName;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }

    public List<String> getPlayer(int id) {

        String sql = "SELECT * from player where playerID = ?";
        String playerName;
        String playerHealth;
        String playerID;
        String playerStrength;
        String playerAgility;
        String playerIntelligence;
        String playerExp;
        String playerLevel;
        String enemies_defeated;

        List<String> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                playerID = "PlayerID: " + rs.getString("playerid");
                playerName = "Name: " + rs.getString("name");
                playerHealth = "Health: " + rs.getString("health");
                playerStrength = "Strength: " + rs.getString("strength");
                playerAgility = "Agility: " + rs.getString("agility");
                playerIntelligence = "Intelligence: " + rs.getString("intelligence");
                playerExp = "Exp: " + rs.getString("exp");
                playerLevel = "Level: " + rs.getString("level");
                enemies_defeated = "Enemies defeated: " + rs.getString("enemies_defeated");

                list.add(playerID);
                list.add(playerName);
                list.add(playerHealth);
                list.add(playerStrength);
                list.add(playerAgility);
                list.add(playerIntelligence);
                list.add(playerExp);
                list.add(playerLevel);
                list.add(enemies_defeated);
                return list;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }

    public Object getPlayerIDCount() {

        String sql = "select count(playerId) pid from player";

        int pid;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                pid = rs.getInt("pid");
                
                return pid;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }


    public int updatePlayerHealth(int health, int id) {

        String sql = "UPDATE player set health = ? where PlayerID = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, health);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public void closeConnection() {

        try {
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}