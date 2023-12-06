package br.com.pedrodev.junit5mockitoapirest.Controllers;

import br.com.pedrodev.junit5mockitoapirest.dtos.UserDTO;
import br.com.pedrodev.junit5mockitoapirest.models.User;
import br.com.pedrodev.junit5mockitoapirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        var findbyIdUser= userService.findById(id);
        return new ResponseEntity<UserDTO>(findbyIdUser,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> findAllUser = userService.findAll();
        return  new ResponseEntity<>(findAllUser, HttpStatus.OK);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        var created = userService.createUser(user);
        return  new ResponseEntity<UserDTO>(created,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.delete(id);
        return  new ResponseEntity<>("Deleted From Database",HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user){
        var update = userService.UpdateUser(user);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }


}
