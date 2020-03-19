package com.c2p.h2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.c2p.h2.domain.EmployeeEntity;

@Repository("repository")
public interface EmployeeRepository  extends JpaRepository<EmployeeEntity, Long> {
 
}
