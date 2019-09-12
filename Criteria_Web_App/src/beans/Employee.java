package beans;

public class Employee {

	private int eid;
	private String name,email;
	private double salary;
	
	public Employee(int eid, String name, String email, double salary) {
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEid() {
		return eid;
	}
	public double getSalary() {
		return salary;
	}
	
	
}
