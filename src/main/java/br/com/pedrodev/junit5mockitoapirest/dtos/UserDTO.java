package br.com.pedrodev.junit5mockitoapirest.dtos;


import br.com.pedrodev.junit5mockitoapirest.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;


    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();
    }


    public UserDTO(Optional<User> result) {

        id = result.get().getId();
        name = result.get().getName();
        email = result.get().getEmail();
        password = result.get().getPassword();

    }
}
