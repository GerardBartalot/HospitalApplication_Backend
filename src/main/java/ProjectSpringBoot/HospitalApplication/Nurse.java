package ProjectSpringBoot.HospitalApplication;

public class Nurse {
		
	private String name;
	private String username;
	private String password;

	public Nurse(String nombre, String username, String password) {
	        
	    this.name = nombre;
	    this.username = username;
	    this.password = password;
	
	}

	public String getNombre() {
	    return name;
	}

	public void setNombre(String nombre) {
	    this.name = name;
	}

	public String getUsername() {
	    return username;
	}

	public void setUsername(String username) {
	    this.username = username;
	}

	public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
	}
	
}