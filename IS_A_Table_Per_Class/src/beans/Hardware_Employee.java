package beans;

public class Hardware_Employee extends Employee {

	private int working_hours;
	public Hardware_Employee() {
	}
	public Hardware_Employee(int id, int salary, String name, String email, int working_hours) {
		super(id, salary, name, email);
		this.working_hours = working_hours;
	}
	public int getWorking_hours() {
		return working_hours;
	}
	public void setWorking_hours(int working_hours) {
		this.working_hours = working_hours;
	}
	
}
