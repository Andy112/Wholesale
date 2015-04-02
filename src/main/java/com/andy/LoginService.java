package com.andy;

import com.andy.model.Account;
import com.andy.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Andy on 29/03/2015.
 */

@Service
@Transactional(readOnly = true)
public class LoginService implements UserDetailsService {


    @Autowired
    AccountRepository accountRepository;

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;

    }


    public List<String> getRoles(Integer role) {

        List<String> roles= new ArrayList<String>();

        if (role.intValue() == 1)
        {
            roles.add("ROLE_CUSTOMER");

        }
        else if (role.intValue() == 2){
            roles.add("ROLE_EMPLOYEE");
        }

        return  roles;
    }



    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
        try{
            Account account = accountRepository.findByUsername(username);
            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNotLocked = true;

            return  new User(account.getUsername(), account.getPassword(),
                    enabled, accountNonExpired, credentialsNonExpired, accountNotLocked,
                    getAuthorities(account.getRole().getId().intValue()));

        }catch (Exception e){
            throw  new RuntimeException(e);
        }




    }



    public Collection<? extends GrantedAuthority> getAuthorities(Integer role){
        List<GrantedAuthority> authorityList = getGrantedAuthorities(getRoles(role));
        return authorityList;
    }

    @Override
    public  boolean equals (Object o){
        if (this == o) return true;
        if (!(o instanceof  LoginService)) return false;
        LoginService that = (LoginService) o;
        if (accountRepository != null ? accountRepository.equals(that.accountRepository): that.accountRepository != null)
            return false;

        return true;
    }


    @Override
    public int hashCode() {return accountRepository != null ? accountRepository.hashCode() : 0;}
}
