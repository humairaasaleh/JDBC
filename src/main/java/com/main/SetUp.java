package com.main;

//	IMPORTS

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//	SETUP

public class SetUp {

	public static final Logger LOGGER = LogManager.getLogger();

	private String jdbcConnectionURL;
	private String username;
	private String password;

	public SetUp(String username, String password) {
		jdbcConnectionURL = "jdbc:mysql://localhost:3306/animals";
		this.username = username;
		this.password = password;
	}

	public SetUp(String jdbcConnectionURL, String username, String password) {
		this.jdbcConnectionURL = jdbcConnectionURL;
		this.username = username;
		this.password = password;
	}

	// CONNECTION
	public void testConnection() {

		Connection conn = null;
		try {
			System.out.println("Im attempting connection");
			conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
			System.out.println("Ive connected");
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
//			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// CREATE STATEMENT
	public void create(Animals animals) {
//	    	Connection conn = null;
		try (Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement statement = conn.createStatement()) {
			statement.executeUpdate("INSERT INTO Animals(AnimalName, Colour) VALUES('" + animals.getAnimalname() + "','"
					+ animals.getColour() + "')");

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	// CREATE PREPARED STATEMENT
	public void createPrepared(Animals animal) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				PreparedStatement statement = conn
						.prepareStatement("INSERT INTO Animals(AnimalName, Colour) VALUES (?,?)")) {
			statement.setString(1, animal.getAnimalname());
			statement.setString(2, animal.getColour());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	// RESULT SET

	public Animals animalsFromResultSet(ResultSet resultSet) throws SQLException {
		int animalId = resultSet.getInt("AnimalID");
		String animalName = resultSet.getString("AnimalName");
		String colour = resultSet.getString("Colour");

		return new Animals(animalId, animalName, colour);
	}

	// READ BY ID STATEMENT

	public Animals readById(int animalId) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Animals WHERE AnimalId = " + animalId)) {
			resultSet.next();
			return animalsFromResultSet(resultSet);

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	// READ BY ID PREPARED STATEMENT

	public Animals readByIdPrepared(int animalId) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM Animals WHERE AnimalId=?")) {
			statement.setInt(1, animalId);
			ResultSet resultSet= statement.executeQuery();
			resultSet.next();
			return animalsFromResultSet(resultSet);
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	// READ ALL STATEMENT

	public List<Animals> readAll() {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Animals")) {

			List<Animals> animals = new ArrayList<>();
			while (resultSet.next()) {
				animals.add(animalsFromResultSet(resultSet));
			}
			return animals;

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	// READ LATEST STATEMENT
	public Animals readLatest() {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Animals ORDER BY AnimalId DESC LIMIT 1")) {
			resultSet.next();
			return animalsFromResultSet(resultSet);

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	// UPDATE STATEMENT

	public void update(Animals animals, int animalId) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement statement = conn.createStatement()) {
			statement.executeUpdate("UPDATE Animals SET AnimalName = '" + animals.getAnimalname() + "', Colour = '"
					+ animals.getColour() + "' WHERE AnimalId = " + animalId);
			System.out.println(readById(animalId));
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}

	}

	// UPDATE PREPARED STATEMENT
	public void updatePrepared(Animals animals) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				PreparedStatement statement = conn
						.prepareStatement("UPDATE Animals SET AnimalName=?, Colour=? WHERE AnimalID=? ")) {
			statement.setString(1, animals.getAnimalname());
			statement.setString(2, animals.getColour());
			statement.setInt(3, animals.getAnimalId());
			statement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	// DELETE STATEMENT
	public void delete(int animalId) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement statement = conn.createStatement()) {
			statement.executeUpdate("DELETE FROM animals WHERE AnimalID = " + animalId);

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	// DELETE PREPARED STATEMENT
	public void deletePrepared(int animalId) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				PreparedStatement statement = conn.prepareStatement("DELETE FROM animals WHERE AnimalID=?")) {
			statement.setInt(1, animalId);
			statement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
}
