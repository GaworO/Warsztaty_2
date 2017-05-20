package coderslab.entity;

public class Solution {
	
	protected int id ; 
	protected String created ;
	protected String upadated; 
	protected String description ; 
	protected int exercise_id ;
	protected int user_id;
	
	




	public Solution(int id, String created, String upadated, String description, int exercise_id, int user_id) {
		this.id = id;
		this.created = created;
		this.upadated = upadated;
		this.description = description;
		this.exercise_id = exercise_id;
		this.user_id = user_id;
	}





	public Solution() {
		
	}
	
	
	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getCreated() {
		return created;
	}





	public void setCreated(String created) {
		this.created = created;
	}





	public String getUpadated() {
		return upadated;
	}





	public void setUpadated(String upadated) {
		this.upadated = upadated;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public int getExercise_id() {
		return exercise_id;
	}





	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}





	public int getUser_id() {
		return user_id;
	}





	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}





	@Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ",created ='" +created + '\'' +
                ",updated ='" + upadated + '\'' +
                ", description='" + description + '\'' +
                ",exercise_id ='" +exercise_id + '\'' +
                 ",user_id ='" +user_id + '\'' +
                '}';
}





	public void loadAllByExerciseId() {
		
	}
	
	
	
}
