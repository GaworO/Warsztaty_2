package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import coderslab.entity.User;

public class MySqlUserDao implements UserDao {

	private static final String FIND_ALL_USERS = "SELECT * FROM user";
	private static final String INSERT_USER_QUERY = "INSERT INTO user(name, surname , email , password) VALUES(?,?,?,?)";
	private static final String TAKE_EMAIL = " SELECT email FROM user "; 
	private static final String TAKE_NAME = "SELECT name FROM user";
	private static final String TAKE_SURNAME = "SELECT surname FROM user";
	private static final String TAKE_PASSWORD = "SELECT password FROM user";
	
	
	
	
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
	        try(ResultSet generatedKeys = statment.getGeneratedKeys()){
                if(generatedKeys.first()){
                    user.setId(generatedKeys.getInt(1));
                    return user;
                }else{
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
// zmienia wszystko prócz ID 
	
    @Override
    public List<User> findAll() {
   
   	  return null;
    
}
}



// ZACZĄĆ OD OBIEKTU KTÓRY BĘDZIE REPREZENTOWAŁ SOLUTION 
// LOCAL DATE TIME , USER MOŻE BYĆ JAKO  OBEIKT , 



