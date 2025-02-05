package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserDetails,Integer> {
    public AppUserDetails findAppUserDetailsByNameAndPassword( String username, String password);
    public boolean existsAppUserDetailsByName(String username);
}