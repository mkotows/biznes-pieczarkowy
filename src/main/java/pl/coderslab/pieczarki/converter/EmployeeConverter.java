package pl.coderslab.pieczarki.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.pieczarki.model.Employee;
import pl.coderslab.pieczarki.repository.EmployeeRepository;

@Component
//@ConfigurationPropertiesBinding
public class EmployeeConverter implements Converter<String, Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee convert(String source) {

        Employee employee = employeeRepository.getOne(Long.parseLong(source));
        return employee;
    }
}




//@Component
////@ConfigurationPropertiesBinding
//public class EmployeeConverter implements Converter<String, Employee> {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public EmployeeConverter() {
//    }
//
//    @Override
//    public Employee convert(String source) {
//        Employee employee = employeeRepository.getOne(Long.parseLong(source));
//        return employee;
//    }
//}