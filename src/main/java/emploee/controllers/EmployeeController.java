package emploee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import emploee.Employee;
import emploee.repositories.EmployeeRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeRepository employeeRepo;
	
	public EmployeeController(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	@ModelAttribute("employee")
	public Employee employee() {
		return new Employee();
	}
	
	@GetMapping("/add")
	public String addEmployee(Model model) {
		populateEmployeeDatabese();
		return "addEmployeePage";
		
	}
	
	@PostMapping("/add")
	public String processAddingEmployee(@Valid Employee employee, Errors errors) {
		
		if (errors.hasErrors()) {
			return "addEmployeePage";
		}
		else {
			employeeRepo.save(employee);
			return "redirect:/";
		}
	}
	
	public void populateEmployeeDatabese() {
		/*for (int i = 1; i <= 100; i++) {
			Employee emp = new Employee();
			emp.setFirstName("firstName" + i);
			emp.setLastName("lastName" + i);
			emp.setAdress("adressName" + i);
			emp.setAge(i);
			employeeRepo.save(emp);
		}*/
	}

}
