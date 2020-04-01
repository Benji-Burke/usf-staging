package com.revature.edb.eagle.controller;

import com.revature.edb.eagle.dtos.Credentials;
import com.revature.edb.eagle.entities.AppUser;
import com.revature.edb.eagle.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class AppUserController {

    private UserService userService;

    @Autowired
    public AppUserController(UserService userService){ this.userService = userService;
    }

    @GetMapping
    public AppUser getAppUserById(@PathVariable @RequestBody int id){ return userService.findUserById(id); }



    @GetMapping(value = "/groups/{ids}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<AppUser> getAppUserById(@PathVariable @RequestBody Set<Integer>ids) {
        Set<AppUser> users = new HashSet<>();
        for (int s : ids) {
            users.add(userService.findUserById(s));
        }
        return users;
    }

    @PostMapping(value = "/users/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUser addNewUser(@RequestBody @Valid AppUser user){
        return userService.update(user);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUser updatedUser(@RequestBody @Valid AppUser user) {
        return userService.update(user);
    }

//    @PostMapping(value = "/users/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public AppUser updateAll(@RequestBody @Valid Credentials creds) {
//        AppUser user = new AppUser();
//        user.setId(user.getId());
//        user.set(user.getFirstName());
//        eagle.setLastName(eagle.getLastName());
//        eagle.setEmail(eagle.getEmail());
//        eagle.setRank(eagle.getRank());
//        return eagleService.addEagle(eagle);
//    }



    @GetMapping(value = "users", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<AppUser> getAllUsers(HttpServletRequest req) {
        return (List<AppUser>) userService.getAllUsers();
    }

    @PostMapping(value="/auth", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public AppUser authenticate(@RequestBody Credentials creds) {
        return userService.authenticate(creds.getUsername(), creds.getPassword());
    }

    @GetMapping("/test")
    public @ResponseBody String test() {
        return "appUserController loaded";
    }

//    @PostMapping(value = "/getbyfirstname", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public AppUser getBtFirstName(@RequestBody @Valid Credentials credentials) {
//        String fname = credentials.getUsername();
//
//        return userService.
//    }


}
