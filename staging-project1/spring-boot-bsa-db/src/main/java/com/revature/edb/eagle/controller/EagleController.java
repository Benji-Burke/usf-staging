package com.revature.edb.eagle.controller;

import com.revature.edb.eagle.dtos.EagleCreds;
import com.revature.edb.eagle.entities.Eagle;
import com.revature.edb.eagle.services.EagleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController

@RequestMapping("/eagle")
public class EagleController {

    private EagleService eagleService;

    @Autowired
    public EagleController(EagleService eagleService){
        this.eagleService = eagleService;
    }

    @GetMapping
    public Eagle getEagleById(@PathVariable @RequestBody int id){
        return eagleService.getEagleById(id);
    }


    @GetMapping(value = "/groups/{ids}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Eagle> getEableById(@PathVariable @RequestBody Set<Integer>ids) {
        Set<Eagle> eagles = new HashSet<>();
        for (int s : ids) {
        eagles.add(eagleService.getEagleById(s));
    }
        return eagles;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Eagle addNewEagle(@RequestBody @Valid Eagle eagle){
        return eagleService.update(eagle);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Eagle updateEagle(@RequestBody @Valid Eagle eagle) {
        return eagleService.update(eagle);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Eagle updateAll(@RequestBody @Valid EagleCreds employee) {
        Eagle eagle = new Eagle();
        eagle.setId(eagle.getId());
        eagle.setFirstName(eagle.getFirstName());
        eagle.setLastName(eagle.getLastName());
        eagle.setEmail(eagle.getEmail());
        eagle.setRank(eagle.getRank());
        return eagleService.addEagle(eagle);
    }

//    @GetMapping (value = "/getAllById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Eagle> getAllById (@RequestBody List<Integer> ids){
//        List<Eagle> eagles = new ArrayList<>();
//        for (int s : ids) {
//            eagles.add(eagleService.getEagleById(s));
//        }
//        return eagles;
//    }

//    @GetMapping(value = "/getbyid", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Eagle getById(@RequestBody @Valid EagleCreds eagle) {
//        int id = eagle.getId();
//
//        return eagleService.getEagleById(id);
//    }

    @GetMapping (value = "/getallbyid", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Eagle> getAllById (@RequestBody List<Integer> ids){
        List<Eagle> employees = new ArrayList<>();
        for (int s : ids) {
            employees.add(eagleService.getEagleById(s));
        }
        return employees;
    }

    @GetMapping(value="/id/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Eagle getUserById(@PathVariable int id) {
        return eagleService.findEagleById(id);
    }

    @PostMapping(value = "/getbyfirstname", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Eagle getBtFirstName(@RequestBody @Valid EagleCreds eagle) {
        String fname = eagle.getFirstName();

        return eagleService.findByFirstName(fname);
    }

    @GetMapping("/eagles")
    public List<Eagle> getAllEagles() {
        return eagleService.getAll();
    }



}
