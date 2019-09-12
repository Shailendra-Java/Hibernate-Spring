package beans;

public class Admin extends Employee {

	private String branchName;
	public Admin() {
	}
	public Admin(int id, int salary, String name, String email, String branchName) {
		super(id, salary, name, email);
		this.branchName = branchName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
}
