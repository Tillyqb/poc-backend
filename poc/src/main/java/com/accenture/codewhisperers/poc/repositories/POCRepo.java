package com.accenture.codewhisperers.poc.repositories;


import com.accenture.codewhisperers.poc.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface POCRepo extends MongoRepository<Employee, String> {

  List<Employee> findByFirst_name(String first_name);
  List<Employee> findAll();

  int deleteByEid(String eid);

  Employee findByEid(String eid);
}
