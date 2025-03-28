package store.persistence;

import store.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeJpaPersistenceService implements EmployeePersistenceFacade {
//    @Autowired
    private final EmployeeJpaDaoMapper employeeJpaDaoMapper;
    private final   EmployeeJpaRepository employeeJpaRepository;

    public EmployeeJpaPersistenceService(EmployeeJpaDaoMapper employeeJpaDaoMapper, EmployeeJpaRepository employeeJpaRepository) {
        this.employeeJpaDaoMapper = employeeJpaDaoMapper;
        this.employeeJpaRepository = employeeJpaRepository;
    }


    @Override
    public Employee save(Employee employee) {
        log.debug("Employee  = {}", employee.getName());
        EmployeeJpaEntity InterEmployeeJpaEntity = employeeJpaDaoMapper.modelToJpaEntity(employee);
        log.debug("Employee JPA = {}", InterEmployeeJpaEntity.getName());
        EmployeeJpaEntity employeeJpaEntity = this.employeeJpaRepository.save(InterEmployeeJpaEntity);
        log.debug("Employee JPA = {}", employeeJpaEntity.getName());
        return this.employeeJpaDaoMapper.jpaEntityToModel(employeeJpaEntity);
    }

    @Override
    public List<Employee> findAll() {

        return this.employeeJpaRepository.findAll()
                .stream()
                .map(employeeJpaEntity -> this.employeeJpaDaoMapper.jpaEntityToModel(employeeJpaEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Employee> findById(Long id) {

        return this.employeeJpaRepository.findById(id)
                .flatMap(employeeJpaEntity -> Optional.of(this.employeeJpaDaoMapper.jpaEntityToModel(employeeJpaEntity)));
    }

    public void deleteAll() {
        this.employeeJpaRepository.deleteAll();
    }

    @Override
    public void delete(Employee employee) {
        this.employeeJpaRepository.delete(this.employeeJpaDaoMapper.modelToJpaEntity(employee));
    }

    @Override
    public void deleteById(Long id) {
        this.employeeJpaRepository.deleteById(id);
    }

    @Override
    public Employee update(Employee employee) {

        return this.employeeJpaDaoMapper.jpaEntityToModel(this.employeeJpaRepository.save(this.employeeJpaDaoMapper.modelToJpaEntity(employee)));
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return this.employeeJpaDaoMapper.jpaEntityToModel(this.employeeJpaRepository.getOne(id));
    }
//
//    @Override
//    public Employee findByEmployeeId(long theId) {
//        return this.employeeJpaDaoMapper.jpaEntityToModel(this.employeeJpaRepository.findByEmployeeId(theId));
//    }
}
