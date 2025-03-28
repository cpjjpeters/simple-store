package store.controller;

import store.persistence.EmployeeJpaEntity;
import store.persistence.EmployeeJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/employees")
public class EmpController {
    @Autowired
    EmployeeJpaRepository employeeJpaRepository;

    @GetMapping(value = "/{id}")
    public EmployeeJpaEntity getEmployeeById(@PathVariable(value = "id") Long id) {
        log.debug("getEmployeeById {}", id);
        return employeeJpaRepository.findById(id).orElse(null);
    }
}
