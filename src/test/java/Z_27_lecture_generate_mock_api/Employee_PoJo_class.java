package Z_27_lecture_generate_mock_api;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

 

 
public class Employee_PoJo_class {
 
		private String firstName;
		private String lastName;
		private String gender;
		private int age;
		
		 
		private double salary;
		private boolean married;

		private String[] hobbies;
		
		private Map<String,String> familyMembers;
		 
		 
		 
		
		
		public String[] getHobbies() {
			return hobbies;
		}
		public void setHobbies(String[] hobbies) {
			this.hobbies = hobbies;
		}
		public Map<String, String> getFamilyMembers() {
			return familyMembers;
		}
		public void setFamilyMembers(Map<String, String> familyMembers) {
			this.familyMembers = familyMembers;
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
		public boolean getmarried() {
			return getmarried();
		}
		public void setMarried(boolean married) {
			this.married = married;
		}
		
}
