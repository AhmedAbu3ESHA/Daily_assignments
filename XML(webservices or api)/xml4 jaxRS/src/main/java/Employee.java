import java.util.Objects;

public class Employee {
	private int code;
	private String name;
	private int salary;
	public Employee(int code, String nameString, int salary) {
		super();
		this.code = code;
		this.name = nameString;
		this.salary = salary;
	}
	public Employee(){
		
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNameString() {
		return name;
	}
	public void setNameString(String nameString) {
		this.name = nameString;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
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
	
	
	

}
