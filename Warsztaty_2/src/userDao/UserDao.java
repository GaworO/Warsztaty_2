package userDao;

import coderslab.entity.User;

import java.util.List;


public interface UserDao {

	User insert(User user);

	List<User> findAll();
	
	List<User> seeAllUsers();
	List<User> loadAll();
	List<User >loadById();
	
	void menu();
	void delete();
	void saveToDB();
}
