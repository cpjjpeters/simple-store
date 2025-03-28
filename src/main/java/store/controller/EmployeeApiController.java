package store.controller;

import store.model.Employee;
import store.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/* carlpeters created on 23/12/2024 inside the package - ipeters.resttemplate_demo.controller */
@Slf4j
@RestController
@RequestMapping("/simple-crud/app-api/employees")
public class EmployeeApiController {
    
    private final EmployeeService employeeService;
    
    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/all")
    public List<Employee> findAll() {
        log.debug("findAll");
        return employeeService.findAllEmployees();
    }
//
//    @GetMapping
//    public List<Employee> findDefault() {
//        log.debug("findDefault");
//        return employeeService.findAll();
//    }

    @GetMapping(value = "/{id}")
//    public Employee findById(@PathVariable(value = "id") Long id) {//} throws ResourceNotFoundException {
    public ResponseEntity<Optional<Employee>> findById(@PathVariable(value = "id") Long id) {//} throws ResourceNotFoundException {
        log.debug("findById");
        Optional<Employee> employee = employeeService.findById(id);
        return ResponseEntity.ok().body(employee);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/create")
//    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
    public Employee createEmployee(@RequestBody Employee employee){
        log.debug("create new Employee");
        return employeeService.save(employee);
//        return ResponseEntity.ok().body(employeeService.save(employee));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody Employee updateEmployee) {
        log.debug("update");
        Employee employee = employeeService.fintById(id);
        employee.setId(updateEmployee.getId());
        employee.setName(updateEmployee.getName());
        employee.setAddress(updateEmployee.getAddress());
        final Employee updatedEmployee =  employeeService.update(employee);
        return ResponseEntity.ok().body(updatedEmployee);
    }

//    @DeleteMapping(value = "/delete/{id}")
//    public Map<String, Boolean> deleteById(@PathVariable("id") Long id) {
//
//        Employee employee = employeeService.findById(id);
//        log.debug("deleteById {} for {}", id, employee.getName());
//        employeeService.delete(employee);
////        employeeService.deleteById(id);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

    @DeleteMapping({"{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id){
        log.debug("delete with just an id: {}", id);
        employeeService.deleteById(id);
    }
}
