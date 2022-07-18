package com.accenture.codewhisperers.poc.services;

import com.accenture.codewhisperers.poc.models.Employee;
import com.accenture.codewhisperers.poc.repositories.POCRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class POCImpl implements POCImplInt {
  @Autowired
  private POCRepo pocRepo;
  @Override
  public List<Employee> getAllEmployees() {
    return pocRepo.findAll();
  }
//  @Override
//  public List<Employee> getEmployeeByFirst_name(String first_name) {
//    return pocRepo.findByFirst_name(first_name);
//  }

  public Employee updateEmployee(Employee employee) {
    Employee employeeToUpdate;
    Optional<Employee> dbPerson = Optional.ofNullable(pocRepo.findByEid(employee.getEid()));
    if (dbPerson.isPresent()) {
      employeeToUpdate = dbPerson.get();
    }
    else {
      throw new IllegalArgumentException("Employee doesn't exists");
    }
    employeeToUpdate.setEid(employee.getEid());
    employeeToUpdate.setFirst_name(employee.getFirst_name());
    employeeToUpdate.setSecond_name(employee.getSecond_name());
    employeeToUpdate.setId(employee.getId());
    return pocRepo.save(employeeToUpdate);
  }
  @Transactional
  public boolean removeByEid(String eid) {

    int isDeletedFromDB = pocRepo.deleteByEid(eid);

    return (isDeletedFromDB == 1);
  }
}
