package store.persistence;

import store.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeePersistenceFacade {

        Employee save(Employee employee);

        List<Employee> findAll();

        Optional<Employee> findById(Long id);
        void delete(Employee employee);

        void deleteById(Long id);

        Employee update(Employee employee);

        Employee getEmployeeById(Long id);

//        Employee findByEmployeeId(long theId);
}
