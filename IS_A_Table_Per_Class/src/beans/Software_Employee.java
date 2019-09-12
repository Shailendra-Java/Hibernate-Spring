package beans;

public class Software_Employee extends Employee {

	private String tool;
	public Software_Employee() {
	}
	public Software_Employee(int id, int salary, String name, String email, String tool) {
		super(id, salary, name, email);
		this.tool = tool;
	}
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
	}
	
	
}
