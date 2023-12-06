package br.com.pedrodev.junit5mockitoapirest.Controllers;

import br.com.pedrodev.junit5mockitoapirest.dtos.UserDTO;
import br.com.pedrodev.junit5mockitoapirest.exceptions.CustomExceptionHandler;
import br.com.pedrodev.junit5mockitoapirest.models.User;
import br.com.pedrodev.junit5mockitoapirest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable @Valid Long id){
        var findbyIdUser= userService.findById(id);
        return new ResponseEntity<UserDTO>(findbyIdUser,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> findAllUser = userService.findAll();
        return  new ResponseEntity<>(findAllUser, HttpStatus.OK);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid User user){
        try {
            var created = userService.createUser(user);
            return  new ResponseEntity<UserDTO>(created,HttpStatus.CREATED);
        }catch (DataIntegrityViolationException e){
        throw  new DataIntegrityViolationException("");
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable  @Valid Long id){

        try {
            userService.delete(id);
            return  new ResponseEntity<>("Deleted From Database",HttpStatus.OK);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException(e);
        }

    }

    @PutMapping(value = "/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody @Valid User user){
        var update = userService.UpdateUser(user);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }


}
