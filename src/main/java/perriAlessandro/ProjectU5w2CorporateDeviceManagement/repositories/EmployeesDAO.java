package perriAlessandro.ProjectU5w2CorporateDeviceManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perriAlessandro.ProjectU5w2CorporateDeviceManagement.entities.Employee;

import java.util.Optional;
import java.util.UUID;

public interface EmployeesDAO extends JpaRepository<Employee, UUID> {
    boolean existsByEmail(String email);

    Optional<Employee> findByEmail(String email);
}
