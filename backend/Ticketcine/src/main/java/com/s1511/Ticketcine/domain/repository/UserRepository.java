package com.s1511.Ticketcine.domain.repository;
import com.s1511.Ticketcine.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, String> {
    Optional<User> findByIdAndActive(String id, Boolean active);
    Optional<User> findByEmailAndActive(String email, Boolean active);
    Optional<User> findByEmail(String email); //Necesario para corroborar previo a crear.
}
