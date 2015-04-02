package com.andy.repo;

import com.andy.model.Account;
import com.andy.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Andy on 30/03/2015.
 */

public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public void updateEmployee(Long id, Employee employee) {


        Account updatedAccount = accountRepository.findOne(id);

        employee.setEmployeeId(updatedAccount.getId());
        employee.setFirstName(updatedAccount.getEmployee().getFirstName());
        employee.setLastName(updatedAccount.getEmployee().getLastName());
        employee.setLocation(updatedAccount.getEmployee().getLocation());


        employee.update(employee.getFirstName(), employee.getLastName(), employee.getLocation());

        accountRepository.save(employee.getAccount());
    }
}
