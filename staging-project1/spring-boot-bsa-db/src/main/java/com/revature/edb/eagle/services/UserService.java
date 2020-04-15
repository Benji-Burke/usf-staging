package com.revature.edb.eagle.services;

import com.revature.edb.eagle.entities.AppUser;
import com.revature.edb.eagle.entities.Role;
import com.revature.edb.eagle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserService {

//    private UserRepository userRepository;
//
//   @Autowired
//    public UserService(UserRepository repo) {
//       super();
//       this.userRepository = repo;
//   }
//
//   @Transactional
//   public AppUser getAppUserById(int id) throws ResourceNotFoundException{
//       return userRepository.findById(id);
//   }
//
//
//
//   @Transactional
//   public Iterable<AppUser> getAllUsers(){
//       return userRepository.findAll();
//   }
//
//    @Transactional
//    public AppUser update(AppUser updatedUser){
//        return userRepository.save(updatedUser);
//    }
//
//
//
////    @Transactional(readOnly = true)
////    public AppUser authenticate(String username, String password){
////       AppUser retrievedUser = userRepository.findAppUserByUsernameAndPassword(username, password);
////       return retrievedUser;
////    }
//
//    @Transactional(readOnly=true)
//    public AppUser authenticate(Credentials creds) {
//
//        if (creds == null || creds.getUsername() == null || creds.getPassword() == null
//                || creds.getUsername().equals("") || creds.getPassword().equals(""))
//        {
//            throw new BadRequestException("Invalid credentials object provided!");
//        }
//
//        AppUser retrievedUser = userRepository.findAppUserByUsernameAndPassword(creds);
//
//        if (retrievedUser == null) {
//            throw new AuthenticationException();
//        }
//
//        return retrievedUser;
//
//    }

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository repo) {
        super();
        this.userRepo = repo;
    }

    @Transactional(readOnly=true)
    public Iterable<AppUser> getAllUsers() {
        return userRepo.findAll();
    }

    @Transactional(readOnly=true)
    public AppUser findUserById(int id) {
        return userRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional(readOnly=true)
    public AppUser authenticate(String username, String password) {
        AppUser retrievedUser = userRepo.findAppUserByUsernameAndPassword(username, password);
        return retrievedUser;
    }

    @Transactional
    public AppUser register(AppUser newUser) {
        newUser.setRole(Role.BASIC_USER);
        return userRepo.save(newUser);
    }

    public AppUser update(AppUser user) {
        return userRepo.save(user);
    }
}
