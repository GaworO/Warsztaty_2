package userDao;

import coderslab.entity.Exercise;
import coderslab.entity.Solution;
import coderslab.entity.User;


public class MainApp {

	public static void main(String[] args) {
		UserDao userDao = new MySqlUserDao("jdbc:mysql://localhost:3306/Warsztaty", "root", "coderslab");
		User user = new User();
	
		
		ExerciseDao exerciseDao = new MySqlExerciseDao("jdbc:mysql://localhost:3306/Warsztaty", "root", "coderslab");
		Exercise exercise = new Exercise();
		
		SolutionDao solutionDao = new MySqlSolution("jdbc:mysql://localhost:3306/Warsztaty", "root", "coderslab");
		Solution solution = new Solution();
		
	
		
		
		
		//SOLUTION
	
		
//		solution.setId(3);
//		solution.setCreated("2012-02-26 09:34:00");
//		solution.setUpadated("2015-03-24 08:35:00");
//		solution.setDescription("Ala ma kota");
//		solution.setExercise_id(2);
//		solution.setUser_id(3);
//		
//		solutionDao.insert(solution);
//		
//		solution.loadAllByExerciseId();
//		
//		
//		solutionDao.insert(solution);
//		
//		
//		System.out.println(solution);
	
		
		
		//EXERCISE 
		
//		exercise.setId(1);
//		exercise.setDescription("Ala");
//		exercise.setTitle("Bla bla");
//		
//
//		exerciseDao.insert(exercise);
//		System.out.println(exercise);
//		exerciseDao.loadAllByUserId();
		
		
		
		//USER 
		
		System.out.println("To są wszyscy użytkownicy: ");
		
	//	userDao.seeAllUsers();
		
		System.out.println("Menu: ");
		userDao.menu();
		
		
		
		
//		user.setId(4);
//		user.setName("Basia");
//		user.setSurname("Kozacka");
//		user.setEmail("Ania@email.com");
//		user.setPassword("dziesiec");		
//		
//		
//		userDao.insert(user);
//		System.out.println(user);
//				
//		userDao.findAll();
		
	
		
	}

}
