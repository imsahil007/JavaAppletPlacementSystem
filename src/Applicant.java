
public class Applicant extends Base{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uni, age;
	
	public Applicant(String id, String pswd, String name, String uni, String age, String salary, String qualification)
	{
	
		super(id,pswd,name,salary,qualification);
		this.uni = uni;
		this.age = age;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getUni() {
		return uni;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	public void setUni(String uni) {
		this.uni = uni;
	}

}

