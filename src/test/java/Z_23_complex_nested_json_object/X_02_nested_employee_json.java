package Z_23_complex_nested_json_object;

import Z_22_create_nestedd_json_object.X_03_employee_address;

public class X_02_nested_employee_json {
	

	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private X_03_employee_address address;
	
	
	public void setAddress(X_03_employee_address emp1Address) {
		this.address = emp1Address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public X_03_employee_address getAddress() {
		return address;
	}
	 
	

}
