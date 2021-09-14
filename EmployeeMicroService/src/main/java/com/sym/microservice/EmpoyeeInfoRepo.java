package com.sym.microservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpoyeeInfoRepo extends JpaRepository<EmployeeDTO, Integer> {
	

}
