package emploee.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/add")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		populateEmployeeDatabese();
		return "addEmployeePage";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editEmployee (@PathVariable long id, Model model) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Invalid user id: " + id));
		model.addAttribute("employee", employee);		
		return "editEmployeePage";
	}
	
	@PostMapping("/edit/{id}")
	public String saveEditedEmployee (@PathVariable long id, @Valid Employee employee) {
		employeeRepo.save(employee);		
		return "redirect:/";
	}
	

	@GetMapping("/delete/{id}")
	public String deleteEmployee (@PathVariable long id, Model model) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Invalid user id: " + id));
		employeeRepo.delete(employee);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/getEmployees")
	public String getEmployees(Model model) {
		
		Iterable<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute(employeeList);
		
		
		return "getEmployeesPage";
		
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
