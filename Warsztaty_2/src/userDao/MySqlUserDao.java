package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import coderslab.entity.User;

public class MySqlUserDao implements UserDao {

	private static final String INSERT_USER_QUERY = "INSERT INTO user2(name, surname , email , password) VALUES(?,?,?,?)";
	private static final String FIND_ALL_USERS = "SELECT * FROM user2";
	private static final String SEE_ALL_USERS_WITH_ID = "SELECT name , id FROM user2";
	private static final String ADD_NEW_USER = "INSERT INTO user2(name, surname , email , password) VALUES(?,?,?,?)";
	private static final String EDIT_USER_WITH_ID = "UPDATE user2 SET id = ? , name = ?,  surname = ? , email = ? , password= ? WHERE id = 3";
	private static final String DELETE_USER_WITH_ID = "DELETE FROM user2 WHERE id = ?";
	
	
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
	public List<User> seeAllUsers() {
		try (Connection connection = createConnection();
			 PreparedStatement statment3 = connection.prepareStatement(SEE_ALL_USERS_WITH_ID);
			   ResultSet resultSet3 = statment3.getResultSet()) {

			
			statment3.executeUpdate();

			while (resultSet3.next()) {
				String name = resultSet3.getString("name");
				int id = resultSet3.getInt("id");

				System.out.println("Imię użytkownika " + name + "Id użytkownika: " + id);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return seeAllUsers();
	}
	

	@Override
	public void menu() {
		Scanner scr = new Scanner(System.in);
		String add = "add";
		String edit = "edit";
		String delete = "delete";
		String quit = "quit";
		String name ; 
		String surname; 
		String email ; 
		String password ;
		int id ; 
		
		try (Connection connection = createConnection();
				PreparedStatement statment4 = connection.prepareStatement(ADD_NEW_USER);
				PreparedStatement statement5 = connection.prepareStatement(EDIT_USER_WITH_ID);
				//zmienic query edit na wszystkie by zmieniał a nie tylko z id 3
				ResultSet resultSet = statment4.getResultSet()) {
		
	
				
			while(true) {
				
				System.out.println("Wybierz jedną z opcji: ");
				System.out.println("add");
				System.out.println("edit");
				System.out.println("delete");
				System.out.println("quit");
				String input = scr.nextLine();
				
			if(input.equals(add)){
				System.out.println("Podaj swoje imię: ");
				name = scr.nextLine();
				System.out.println("Podaj swoje nazwisko: ");
				surname = scr.nextLine();
				System.out.println("Podaj swój email: ");
				email = scr.nextLine();
				System.out.println("Podaj swoje hasło: ");
				password = scr.nextLine();
				
				statment4.setString(1, name);
				statment4.setString(2, surname);
				statment4.setString(3, email);
				statment4.setString(4, password);
				
				
				statment4.executeQuery();
				
				while (resultSet.next()) {
				System.out.println("Twoje imię " + name + "nazwisko:  " + surname +
						"email: " + email + "hasło: " + password);
				continue; 
				
			}
			} else if(input.equals(edit)){
				System.out.println("Wpisz nowe id");
				id = scr.nextInt();
				scr.nextLine();
				System.out.println("Podaj swoje imię: ");
				name = scr.nextLine();
				System.out.println("Podaj swoje nazwisko: ");
				surname = scr.nextLine();
				System.out.println("Podaj swój email: ");
				email = scr.nextLine();
				System.out.println("Podaj swoje hasło: ");
				password = scr.nextLine();
			
				
				
				statement5.executeUpdate();
				System.out.println("Dane się zaktualizowały");
				continue;
				
			} else if (input.equals(delete)) {
				System.out.println("Którego użytkownika usunąć?");
				id = scr.nextInt();
				
				statement5.setInt(1, id);
				
				statement5.executeUpdate();
				
			} else if(input.equals(quit)){
				System.out.println("Wychodzisz z programu");
				break;
			}
			}
			
			
			
		
		} catch (SQLException e ) {
				throw new RuntimeException();
			}
			
		
	}

	@Override
	public List<User> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> loadById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void  delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void  saveToDB() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}

