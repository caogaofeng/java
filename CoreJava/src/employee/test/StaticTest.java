package employee.test;

public class StaticTest {

	public static void main(String[] args) {
		Employee_Static[] staff = new Employee_Static[3];
		
		staff[0] = new Employee_Static("Tom", 40000);
		staff[1] = new Employee_Static("Dick", 60000);
		staff[2] = new Employee_Static("Harry", 65000);
		
		for(Employee_Static e : staff){
			e.setId();
			System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
		}
		
		int n = Employee_Static.getNextId(); // calls static method
		System.out.println("Next vavilable id=" + n);
		

	}
}

class Employee_Static {
	private static int nextId = 1;
	
	private String name;
	private double salary;
	private int id;
	
	public Employee_Static(String n, double s){
		name = n;
		salary = s;
		id = 0;
	}

	public void setId(){
		id = nextId; // set id to next available id
		nextId++;
	}

	public static int getNextId() {
		return nextId;  // returns static field
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public int getId() {
		return id;
	}
	
	public static void main(String[] args){ // unit test
		Employee_Static e = new Employee_Static(" Harry", 50000);
		System.out.println(e.getName() + " " + e.getSalary());
	}
}
