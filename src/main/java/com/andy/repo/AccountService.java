package com.andy.repo;

import com.andy.model.Employee;
import org.springframework.stereotype.Service;



@Service
public interface AccountService {


    public void updateEmployee(Long id, Employee employee);
}
