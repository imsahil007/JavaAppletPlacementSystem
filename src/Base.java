import java.io.Serializable;

public class Base implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id,pswd,name,salary,qualification;
	
	public Base(String id, String pswd, String name, String salary, String qualification) {
		this.id = id;
		this.pswd = pswd;
		this.name = name;
		this.salary= salary;
		this.qualification = qualification;
	}
	
	public String getId() {
		return id;
	}
	public String getPswd() {
		return pswd;
	}
	public String getName() {
		return name;
	}
	public String getSalary() {
		return salary;
	}
	public String getQualification() {
		return qualification;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	
	
}
