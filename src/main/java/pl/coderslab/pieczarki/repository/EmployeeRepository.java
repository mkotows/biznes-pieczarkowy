package pl.coderslab.pieczarki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.pieczarki.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
