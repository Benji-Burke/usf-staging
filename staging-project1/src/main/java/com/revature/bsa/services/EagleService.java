package com.revature.bsa.services;

import com.revature.bsa.entities.Eagle;
import com.revature.bsa.exceptions.ResourceNotFoundException;
import com.revature.bsa.repositories.EagleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EagleService {

    private EagleRepository eagleRepo;

    @Autowired
    public EagleService(EagleRepository repo){
        super();
        this.eagleRepo = repo;
    }

    @Transactional(readOnly = true)
    public Eagle getEagleById(int id) throws ResourceNotFoundException {
        return eagleRepo.findById(id);
    }

    @Transactional
    public Eagle update(Eagle updatedEag) {
        return eagleRepo.save(updatedEag);
    }

    @Transactional
    public Eagle addEagle(Eagle newEagle){
        return eagleRepo.save(newEagle);
    }

    @Transactional(readOnly = true)
    public Eagle findByEagleName(String name) throws ResourceNotFoundException{
        return eagleRepo.findByFirstName(name);
    }

    @Transactional(readOnly = true)
    public List<Eagle> getAll() throws ResourceNotFoundException{
        Iterable<Eagle> e = eagleRepo.findAll();
        List<Eagle> list = getListFromIterator(e);
        return list;
    }

    public static <T> List<T> getListFromIterator(Iterable<T>iterable)
    {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}
