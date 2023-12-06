package br.com.pedrodev.junit5mockitoapirest.service;

import br.com.pedrodev.junit5mockitoapirest.dtos.UserDTO;
import br.com.pedrodev.junit5mockitoapirest.models.User;
import br.com.pedrodev.junit5mockitoapirest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserDTO findById(Long id){
        Optional<User> result = userRepository.findById(id);
        UserDTO dto = new UserDTO(result);
        return dto;

    }

    public List<UserDTO> findAll(){
        List<User> result = userRepository.findAll();
        var dto = result.stream().map(x -> new UserDTO(x)).toList();
        return dto;
    }

    public UserDTO createUser(User user){
        User exists = userRepository.findByName(user.getName());
        if (exists != null) {
          //  throw new Error("User already exists!");
        }
        User createdUser = userRepository.save(user);
        UserDTO dto = new UserDTO(createdUser);
        return dto;
    }

    public void delete(Long id){
        User exists = userRepository.findById(id).get();
        if (exists == null) {
            throw new Error("User not exists!");
        }
        userRepository.deleteById(id);

    }

    public UserDTO UpdateUser(User user){
        User exists = userRepository.findById(user.getId()).get();
        if (exists == null) {
            throw new Error("User not exists!");
        }
        User updateUser = userRepository.save(user);
        UserDTO dto = new UserDTO(updateUser);
        return dto;
    }


}
