package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import coderslab.entity.User;

public class MySqlUserDao implements UserDao {

	private static final String INSERT_USER_QUERY = "INSERT INTO user2(name, surname , email , password) VALUES(?,?,?,?)";
	private static final String FIND_ALL_USERS = "SELECT * FROM user2";
	

	private final String jdbcUrel;
	private final String password;
	private final String user;

	public MySqlUserDao(String jdbcUrel, String password, String user) {
		this.jdbcUrel = jdbcUrel;
		this.password = password;
		this.user = user;
	}

	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrel, password, user);
	}

	@Override
	public User insert(User user) {
		try (Connection connection = createConnection();
				PreparedStatement statment = connection.prepareStatement(INSERT_USER_QUERY,
						PreparedStatement.RETURN_GENERATED_KEYS)) {
			statment.setString(1, user.getName());
			statment.setString(2, user.getSurname());
			statment.setString(4, user.getEmail());
			statment.setString(3, user.getPassword());

			int result = statment.executeUpdate();
			if (result != 1) {
				throw new RuntimeException("Execute update return : " + result);
			}
			try (ResultSet generatedKeys = statment.getGeneratedKeys()) {
				if (generatedKeys.first()) {
					user.setId(generatedKeys.getInt(1));
					return user;
				} else {
					throw new RuntimeException("Generated key was not found");
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public List<User> findAll() {
		try (Connection connection = createConnection();
				PreparedStatement statment2 = connection.prepareStatement(FIND_ALL_USERS);
				ResultSet resultSet = statment2.getResultSet()) {

			statment2.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");

				System.out.println("To jest Twoje imie: " + name + "To jest Twoje nazwisko: " + surname
						+ "To jest Twój emial: " + email + "To jest Twoje haso: " + password);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return findAll();
	}

	@Override
	public void seeAllUsers() {
		try (Connection connection = createConnection();
				PreparedStatement statment3 = connection.prepareStatement(s);
				ResultSet resultSet3 = statment3.getResultSet()) {

			statment2.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");

				System.out.println("To jest Twoje imie: " + name + "To jest Twoje nazwisko: " + surname
						+ "To jest Twój emial: " + email + "To jest Twoje haso: " + password);
			}
		
	}
	
	
	
}

// ZACZĄĆ OD OBIEKTU KTÓRY BĘDZIE REPREZENTOWAŁ SOLUTION
// LOCAL DATE TIME , USER MOŻE BYĆ JAKO OBEIKT ,
