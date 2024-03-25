import java.util.List;
import java.util.Objects;

public class Employee {
	private String name;
	private int salary;
	private int code;
	
	
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
	

	
	

}
