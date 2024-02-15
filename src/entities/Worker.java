package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker { //2 associações e vários contratos

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	//Associacoes - Composição de objetos
	private Department department;
	private List<HourContract> contracts = new ArrayList<>(); //como um trabalhador tem vários contratos, os N contratos estarão em uma lista
	//quando tiver uma composição tem muitos, neste caso a lista, a lista não deve inserida no construtor, apenas inicia a lista vazia
	
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	//public List<HourContract> getContracts() {return contracts;	}
	//não pode ser trocado a lista

	//public void setContracts(List<HourContract> contracts) {	this.contracts = contract	}
	//não pode utilizar pois a lista de contratos já está sendo instanciada e não pode ser trocada, pois no metodo está sendo atribuido outra lista
	
	//metodos
	public void addContract(HourContract contract) { //metodo
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) { //metodo
		contracts.remove(contract);
	}
			
	public double income(int year, int month) {  //metodo
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate()); //data do contrato como data do calendário
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH); //mes começa com zero, por isso deve somar 1
			if (year == c_year && month == c_month) { 
				sum += c.totalValue();
			}
		}
		return sum;}
		
}
