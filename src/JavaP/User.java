package JavaP;

public class User {
	private int id;
	private String username;
	private String password;
	public int getId(){
		return id;
	}
	public String getName(){
		return username;
	}
	public String getPass(){
		return password;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setName(String name){
		this.username=name;
	}
	public void setPass(String pass){
		this.password=pass;
	}
}
