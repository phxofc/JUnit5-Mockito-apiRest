package br.com.pedrodev.junit5mockitoapirest.service;

import br.com.pedrodev.junit5mockitoapirest.dtos.UserDTO;
import br.com.pedrodev.junit5mockitoapirest.models.User;
import br.com.pedrodev.junit5mockitoapirest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO findById(Long id){
        User searchId = userRepository.findById(id).get();

        UserDTO dto = new UserDTO(searchId);

        return dto;

    }
}
