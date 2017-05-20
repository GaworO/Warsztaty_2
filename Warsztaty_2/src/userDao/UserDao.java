package userDao;

import coderslab.entity.User;

import java.util.List;


public interface UserDao {

	User insert(User user);

	List<User> findAll();
}
