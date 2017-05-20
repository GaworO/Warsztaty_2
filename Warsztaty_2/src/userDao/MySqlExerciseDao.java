package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.w3c.dom.ranges.RangeException;

import coderslab.entity.Exercise;

public class MySqlExerciseDao implements ExerciseDao {

	private static final String INSERT_EXERCISE_DATA = "INSERT INTO exercise(title,description) VALUES(?,?)";
	private static final String ALL_SOLUTIONS_ID = "SELECT description  FROM  exercise  WHERE exercise_id = 3";
	
	
	private final String jdbcUrel;
	private final String password;
	private final String user;

	public MySqlExerciseDao(String jdbcUrel, String password, String user) {
		this.jdbcUrel = jdbcUrel;
		this.password = password;
		this.user = user;
	}


	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrel, password, user);
	}

	
	@Override
	public Exercise insert(Exercise exercise) {
		try { Connection connection = createConnection();
		      PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EXERCISE_DATA,
		      PreparedStatement.RETURN_GENERATED_KEYS);
			 
		     
		      preparedStatement.setString(1, exercise.getTitle());
			  preparedStatement.setString(2,exercise.getDescription());
			 
			  int result = preparedStatement.executeUpdate();
			  if(result != 1) {
					throw new RuntimeException("Execute update return : " + result);
				}
		        try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()){
	                if(generatedKeys.first()){
	                    exercise.setId(generatedKeys.getInt(1));
	                    return exercise;
	                }else{
	                    throw new RuntimeException("Generated key was not found");
	                }
	            }
	        } catch (SQLException e) {
	           throw new RuntimeException(e);
	        }
	}
			  
			
	@Override
	public List<Exercise> loadAllByUserId() {
		
		try(Connection connection = createConnection();
	     PreparedStatement preparedStatement2 = connection.prepareStatement(ALL_SOLUTIONS_ID);
		  ResultSet resultSet = preparedStatement2.getResultSet()){
			
			 preparedStatement2.executeQuery();
			
			while(resultSet.next()){
	//NIE JESTEM PEWNA CZY TAK MA BYĆ ?			
				String description = resultSet.getString("description");
				System.out.println("This is your description: " + description );}	
//			
//			
//		  
		  } catch (SQLException e ) {
			  throw new RuntimeException(e);
		  }
		
		return loadAllByUserId() ;
		
	
	}
}
	
	
	
