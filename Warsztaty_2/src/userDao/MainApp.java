package userDao;

import coderslab.entity.User;


public class MainApp {

	public static void main(String[] args) {
		UserDao userDao = new MySqlUserDao("jdbc:mysql://localhost:3306/Warsztaty", "root", "coderslab");
		User user = new User();
		
		user.setId(2);
//		user.setName("Kasia");
//		user.setSurname("Tro lo lo");
//		user.setEmail("someOneLike@email.com");
//		user.setPassword("raz");
//		
//		
//		userDao.insert(user);
//		System.out.println(user);
		userDao.findAll();
	}

}
