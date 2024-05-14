package Z_25_lecture_Ignore_fields_from_pojo_class;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value= {"fullName","gender"})


public class Employee_PoJo_class {
 
		private String firstName;
		private String lastName;
		private String gender;
		private int age;
		
		//read while serialization but not while deseralization
		@JsonProperty(access=JsonProperty.Access.READ_ONLY)
		private double salary;
		private boolean isMarried;

		@JsonIgnore
		private String fullName;
		
		
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
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
		public boolean isMarried() {
			return isMarried;
		}
		public void setMarried(boolean isMarried) {
			this.isMarried = isMarried;
		}
		
}
