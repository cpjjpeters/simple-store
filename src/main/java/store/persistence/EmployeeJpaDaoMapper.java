package store.persistence;

import store.model.Employee;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")//(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface EmployeeJpaDaoMapper {
    EmployeeJpaEntity modelToJpaEntity(Employee employee);

    Employee jpaEntityToModel(EmployeeJpaEntity employeeJpaEntity);
}
