package perriAlessandro.ProjectU5w2CorporateDeviceManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perriAlessandro.ProjectU5w2CorporateDeviceManagement.entities.Device;
import perriAlessandro.ProjectU5w2CorporateDeviceManagement.entities.Employee;

import java.util.List;
import java.util.UUID;

public interface DevicesDAO extends JpaRepository<Device, UUID> {
    boolean existsByEmployee(Employee employee);

    List<Device> findByEmployee(Employee employee);
}
