package userDao;

import java.util.List;

import coderslab.entity.Exercise;


public interface ExerciseDao {


	Exercise insert(Exercise exercise);

	List<Exercise> loadAllByUserId() ;




}
