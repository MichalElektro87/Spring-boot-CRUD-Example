package emploee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
public class Employee {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@NotNull
private long id;
@NotBlank
private String firstName;
@NotBlank
private String lastName;
@NotBlank
private String adress;
@NotNull
private int age;


}
