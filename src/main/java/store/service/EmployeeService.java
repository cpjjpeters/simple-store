package store.service;

import store.model.Employee;
import store.persistence.EmployeePersistenceFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* carlpeters created on 22/12/2024 inside the package - ipeters.resttemplate_demo.service */
@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeePersistenceFacade employeePersistenceFacade;


    public List<Employee> findAllEmployees() {
        return this.employeePersistenceFacade.findAll();
    }

    public Employee save(Employee employee) {
        log.debug("save employee {}", employee);
        return this.employeePersistenceFacade.save(employee);
    }

    public Optional<Employee> findById(Long id) {
        log.debug("findById");
        return this.employeePersistenceFacade.findById(id);
    }

    public Employee fintById(Long id) {
        log.debug("findById");
        return this.employeePersistenceFacade.getEmployeeById(id);
    }
    public void deleteById(Long id) {
        log.debug("deleteById");
        this.employeePersistenceFacade.deleteById(id);
    }


    public Employee update(Employee employee) {
        log.debug("update");
        return this.employeePersistenceFacade.update(employee);
    }
    }
