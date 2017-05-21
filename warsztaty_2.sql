create database Warsztaty;
use Warsztaty;
CREATE table user2(id bigint primary key AUTO_INCREMENT, name VARCHAR(255), 
surname varchar(300), email varchar(255) Unique , password VARCHAR(245));

SELECT * FROM Warsztaty;

use Warsztaty; 

/*Stworzenie tabeli solution */
CREATE	TABLE soluton(
		solution_id INT NOT NULL AUTO_INCREMENT, 
		id BIGINT , created datetime , upadated datetime,
        description TEXT(200) , exercise_id INT , user_id BIGINT,
       	PRIMARY	KEY(solution_id),
		FOREIGN	KEY(id)
		REFERENCES user2(id));


/*Stworzenie tabeli exercise */


CREATE TABLE exercise(exercise_id INT NOT NULL AUTO_INCREMENT, id BIGINT,  title VARCHAR(255) , description TEXT(200), 
						PRIMARY KEY(exercise_id),
                        FOREIGN KEY(id)
                        REFERENCES soluton(id));
                        
                        
  /* WYBRANIE WSZYSTKICH ROZWIĄZAŃ Z ID JAKIMŚ ROSNĄCO */
  
  SELECT description FROM soluton WHERE exercise_id = 2 order by upadated ASC;
                        
            
/* UPDATE USER */

UPDATE user2 SET id = 4, name = 'ania',  surname = 'asa' , email = 'lol' , password=123 WHERE id <> 0;


/*DELETE USER */


DELETE FROM user2 WHERE id = 3 ;                         
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        