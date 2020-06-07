
public class Employer extends Base{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String job, vacancy;
	
	public Employer(String id, String pswd, String name, String job, String vacancy, String salary, String qualification)
	{
	
		super(id,pswd,name,salary,qualification);
		this.job = job;
		this.vacancy = vacancy;
	}
	public String getJob() {
		return job;
	}
	
	public String getVacancy() {
		return vacancy;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

}

