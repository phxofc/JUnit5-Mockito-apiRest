package br.com.pedrodev.junit5mockitoapirest.repositories;

import br.com.pedrodev.junit5mockitoapirest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByName(String name);

}
