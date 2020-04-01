package com.revature.edb.eagle.services;

import com.revature.edb.eagle.entities.Eagle;
import com.revature.edb.eagle.exceptions.ResourceNotFoundException;
import com.revature.edb.eagle.repositories.EagleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EagleService {

    private EagleRepository eagleRepository;

    @Autowired
    public EagleService(EagleRepository repo){
        super();
        this.eagleRepository = repo;
    }

    @Transactional(readOnly = true)
    public Eagle getEagleById(int id) throws ResourceNotFoundException{
        return eagleRepository.findById(id);
    }

    @Transactional
    public Eagle update(Eagle updatedEag){
        return eagleRepository.save(updatedEag);
    }

    @Transactional
    public Eagle addEagle(Eagle newEagle) {
        return eagleRepository.save(newEagle);
    }

    @Transactional(readOnly = true)
    public Eagle findByFirstName(String name) throws ResourceNotFoundException{
        return eagleRepository.findByFirstName(name);
    }

    @Transactional(readOnly = true)
    public List<Eagle> getAll() throws ResourceNotFoundException {
        Iterable<Eagle> e = eagleRepository.findAll();
        List<Eagle> list = getListFromIterator(e);
        return list;
    }

    public static<T>List<T> getListFromIterator(Iterable<T> iterable)
    {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}
