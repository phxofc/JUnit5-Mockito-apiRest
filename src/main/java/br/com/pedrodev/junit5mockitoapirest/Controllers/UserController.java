package br.com.pedrodev.junit5mockitoapirest.Controllers;

import br.com.pedrodev.junit5mockitoapirest.dtos.UserDTO;
import br.com.pedrodev.junit5mockitoapirest.models.User;
import br.com.pedrodev.junit5mockitoapirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        var findbyIdUser= userService.findById(id);
        return new ResponseEntity<UserDTO>(findbyIdUser,HttpStatus.OK);
    }

}
