package employee.test;

import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee_Test[] staff = new Employee_Test[3];
		staff[0] = new Employee_Test("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee_Test("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee_Test("Tony Tester", 40000, 1990, 3, 15);

		for (Employee_Test e : staff) {
			e.raiseSalary(5);
		}

		for (Employee_Test e : staff) {
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
		}
	}

}

class Employee_Test {


	private String name;
	private double salary;
	private Date hireDay;

	public Employee_Test(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		// GregorianCalendar uses 0 for January
		hireDay = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
}
