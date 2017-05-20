package userDao;

import java.util.List;

import coderslab.entity.Solution;



public interface SolutionDao {

	
	 Solution insert(Solution solution);

	List<Solution> loadAllByExerciseId() ;
	
	
	
	
}
