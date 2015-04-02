package com.andy.repo;



import com.andy.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {


    List<Account> findByRole_Id(Long roleId);

    Account findByUsername(String email);

}