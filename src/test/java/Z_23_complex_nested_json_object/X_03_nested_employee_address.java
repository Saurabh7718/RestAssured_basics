package Z_23_complex_nested_json_object;

public class X_03_nested_employee_address {
	
	private String street;
	private String city;
	private String state;
	private int pincode;

	//imp
	// pojo class mein ek default constructor hota hai hamne explixitly constructor add nhi kkiya hai kyun ki java compiler automatially ek constructor 
//	add kar deta hai jab explicitky add nhi kiya tab
	
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
}
