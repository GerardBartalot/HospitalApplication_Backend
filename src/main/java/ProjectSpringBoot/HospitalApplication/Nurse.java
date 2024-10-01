package ProjectSpringBoot.HospitalApplication;

public class Nurse {
	private String name;
    private int id;
    
    public Nurse(String name, int id) {
    	this.name = name;
    	this.id = id; 
    }

	public String getName() {
		return name;
	}

	public void setName(String nombre) {
		this.name = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
}

