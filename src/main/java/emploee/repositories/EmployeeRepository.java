package emploee.repositories;

import org.springframework.data.repository.CrudRepository;

import emploee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
