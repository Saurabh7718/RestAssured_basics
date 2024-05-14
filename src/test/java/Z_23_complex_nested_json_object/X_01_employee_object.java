package Z_23_complex_nested_json_object;

import java.util.List;

public class X_01_employee_object {
	/*
{
"companyName":"XYZ ltd",
"Street":" Africa park avenue",
"city":"R K puram dekhi",
"state":"new delhi",
"pin code":12008666",
"Bank Accounts":["HDFC","SBI","AXIS"],
employees":[
{
	"firstName":"suresh",
	"lastName":"mehra",
	"gender":"male",
	"age":28,
	"salary":1000000
	"Address":{
		"Street":"park avenue",
		"city":"vijaywada",
		"state":"andra pradesh",
		"pin code":531200
	}
	
},
{
	"firstName":"Amit",
	"lastName":"gupta",
	"gender":"male",
	"age":30,
	"salary":2000000
	"Address":{
		"Street":"plot 7",
		"city":"vijaywada",
		"state":"andra pradesh",
		"pin code":531200
	}
	
},
{
	"firstName":"Ashish",
	"lastName":"Das",
	"gender":"male",
	"age":32,
	"salary":3000000
	"Address":{
		"Street":"plot 8",
		"city":"dwarka",
		"state":"new delhi",
		"pin code":110086
	}
	
}
]
}
	*/

	private String companyName;
	private String Street;
	private String city;
	private String state;
	private String pincode;
	
	private List<String> bankAccount;
	
	private List<X_02_nested_employee_json> employeeList;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<String> getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(List<String> bankAccount) {
		this.bankAccount = bankAccount;
	}

	public List<X_02_nested_employee_json> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<X_02_nested_employee_json> employeeList) {
		this.employeeList = employeeList;
	}
	
	
	
	
}
