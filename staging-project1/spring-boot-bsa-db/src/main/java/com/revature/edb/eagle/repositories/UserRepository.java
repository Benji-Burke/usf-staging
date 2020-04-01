package com.revature.edb.eagle.repositories;

import com.revature.edb.eagle.dtos.Credentials;
import com.revature.edb.eagle.entities.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Integer> {
    AppUser findAppUserByUsernameAndPassword(String username, String password);
}
