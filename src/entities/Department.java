package entities;

public class Department {
	
	private String name;
	
	public Department() { //construtor vazio
	}

	public Department(String name) { //construtor com argumentos
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
