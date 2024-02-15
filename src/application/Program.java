package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter Worker Data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		//instanciou um novo objeto do tipo worker, dados desse objeto são o nome digitado, uma instancia de workerlevel digitado, valor de um salario base digitado, 
		//associado a esse objeto está o objeto do tipo departamento com o nome digitado
		//level tipo enumerado correspondente a string digitada
		//departamento é um objeto do tipo departamento, composição de objetos
		
		
		System.out.print("How many contracts to this worker?");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next()); //correlçao add trhows declaration
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours); //instanciando o contrato
			worker.addContract(contract);//associando o contrato com o trabalhador e é adicionado a lista de contratos	
		}
		
		
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2)); //recorta o string gerando um substring com os 2 digitos e converte o substring para inteiro
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName()); //objeto worker, acessa os objetos associados departamento e o nome
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
			
		sc.close();
		
		
	} 	
}