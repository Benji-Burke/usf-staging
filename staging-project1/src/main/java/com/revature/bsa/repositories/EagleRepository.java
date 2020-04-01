package com.revature.bsa.repositories;

import com.revature.bsa.entities.Eagle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EagleRepository extends CrudRepository<Eagle, Integer> {
    Eagle findById(int id);
    Eagle findByFirstName(String name);
}
