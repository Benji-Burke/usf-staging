package com.revature.bsa.controllers;


import com.revature.bsa.dtos.Credentials;
import com.revature.bsa.entities.Eagle;
import com.revature.bsa.services.EagleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/eagles")
public class EagleController {

    private EagleService eagleService;


    @Autowired
    public EagleController(EagleService userService){
        this.eagleService = eagleService;
    }

    @GetMapping(value="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Eagle getEagleById(@PathVariable @RequestBody int id){
        return eagleService.getEagleById(id);
    }

    @GetMapping(value = "/group/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Eagle> getEagleById(@PathVariable @RequestBody Set<Integer> ids){
        Set<Eagle> eagles = new HashSet<>();
        for (int s : ids){
            eagles.add(eagleService.getEagleById(s));
        }
        return eagles;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Eagle addNewEmployee(@RequestBody @Valid Eagle eagle) {
        return eagleService.addEagle(eagle);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Eagle updateEagle(@RequestBody @Valid Eagle eagle){
        return eagleService.update(eagle);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Eagle updateAll(@RequestBody @Valid Credentials credentials){
        Eagle eag = new Eagle();
        eag.setId(eag.getId());
    }

}
