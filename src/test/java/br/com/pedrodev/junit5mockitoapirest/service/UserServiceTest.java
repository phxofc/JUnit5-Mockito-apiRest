package br.com.pedrodev.junit5mockitoapirest.service;

import br.com.pedrodev.junit5mockitoapirest.dtos.UserDTO;
import br.com.pedrodev.junit5mockitoapirest.models.User;
import br.com.pedrodev.junit5mockitoapirest.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    public static final long ID = 1L;
    public static final String NAME = "pedro";
    public static final String EMAIL = "phdfrocha99@gmail.com";
    public static final String PASSWORD = "123";

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User user;

    private UserDTO userDTO;

    private  Optional<User> optionalUser;
    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        StartUser();

    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {

        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(optionalUser);
        UserDTO response = userService.findById(ID);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(UserDTO.class,response.getClass());
        Assertions.assertEquals(ID, response.getId());
        Assertions.assertEquals(NAME, response.getName());
        Assertions.assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenFindAllThenReturnAnListOfUsers() {
        Mockito.when(userRepository.findAll()).thenReturn(List.of(user));
        List<UserDTO> response = userService.findAll();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1,response.size());
        Assertions.assertEquals(UserDTO.class, response.get(0).getClass());
        Assertions.assertEquals(ID, response.get(0).getId());
        Assertions.assertEquals(NAME, response.get(0).getName());
        Assertions.assertEquals(EMAIL, response.get(0).getEmail());
        Assertions.assertEquals(PASSWORD, response.get(0).getPassword());
    }

    @Test
    void createUser() {
    }

    @Test
    void delete() {
    }

    @Test
    void updateUser() {
    }

    private void StartUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}