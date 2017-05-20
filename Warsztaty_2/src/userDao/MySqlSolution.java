package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import coderslab.entity.Solution;


public class MySqlSolution implements SolutionDao {

	private static final String INSERT_USER_QUERY = "INSERT INTO soluton(id,created,upadated, description,exercise_id ,user_id) VALUES(?,?,?,?,?,?)";
	private static final String ALL_BY_EXERCISE_ID = "SELECT exercise_id FROM soluton WHERE exercise_id = 3 order by upadated DESC;";

	private final String jdbcUrel;
	private final String password;
	private final String user;

	public MySqlSolution(String jdbcUrel, String password, String user) {
		this.jdbcUrel = jdbcUrel;
		this.password = password;
		this.user = user;
	}

	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrel, password, user);
	}


	
		@Override
		public Solution insert(Solution solution) {
		
		try (Connection connection = createConnection();
				PreparedStatement statment = connection.prepareStatement(INSERT_USER_QUERY,
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			statment.setInt(1, solution.getId());
			statment.setString(2, solution.getCreated());
			statment.setString(3, solution.getUpadated());
			statment.setString(4, solution.getDescription());
			statment.setInt(5, solution.getExercise_id());
			statment.setInt(6, solution.getUser_id());
			
			
	    	int result = statment.executeUpdate();
			if (result != 1) {
				throw new RuntimeException("Execute update return : " + result);
			}
	        try(ResultSet generatedKeys = statment.getGeneratedKeys()){
                if(generatedKeys.first()){
                    solution.setId(generatedKeys.getInt(1));
                    return solution;
                }else{
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (SQLException e) {
           throw new RuntimeException(e);
        
   }
		}

	@Override
	public List<Solution> loadAllByExerciseId() {
		try (Connection connection = createConnection();
		PreparedStatement statment = connection.prepareStatement(ALL_BY_EXERCISE_ID)){
			
		ResultSet resultSet2 = statment.getResultSet();
		
		statment.executeQuery();
		
		while(resultSet2.next()){
			String description = resultSet2.getString("description");
			System.out.println(description);
			
		}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return loadAllByExerciseId();
	
	

}
}

	








