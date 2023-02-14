package emploee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Entity
public class Employee {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@NotNull
private long id;
@NotBlank(message = "Please provide first name")
private String firstName;
@NotBlank(message = "Please provide last name")
private String lastName;
@NotBlank(message = "Please provide adress")
private String adress;
@NotNull
private int age;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
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
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}


}
