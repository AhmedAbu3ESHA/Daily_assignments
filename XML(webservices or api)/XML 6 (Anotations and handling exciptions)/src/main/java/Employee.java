
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.json.bind.annotation.JsonbNumberFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@JsonbPropertyOrder({"code","name","salary","jobs"})
public class Employee {
	
	@NotBlank
	@NotNull
	@JsonbProperty("my-name")
	private String name;
	
	@Min(1000)
	@Max(10000)
	@JsonbNumberFormat("0000.00")
	int salary;
	
	private int code;
	
	@Size(min = 1)
	private ArrayList<Job> jobs=new ArrayList();
	
	public ArrayList<Job> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}

	public Employee(String name, int salary, int code, List<Job> jobs) {
		super();
		this.name = name;
		this.salary = salary;
		this.code = code;
		this.jobs.addAll(jobs);
	}

	public Employee() {
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return code == other.code;
	}

	public Employee(String name, int salary, int code) {
		super();
		this.name = name;
		this.salary = salary;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	

	public void addJob(Job job) {
		jobs.add(job);
	}
		

}
