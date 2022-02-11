package com.example.homeowner2.userrepo;

import com.example.homeowner2.domain.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Tells Spring this is a Repository 'Bean'

public interface UserRepo extends JpaRepository <User2, Long> {

    @Query(value="SELECT * FROM user WHERE first_name = ?1", nativeQuery = true)
    Optional<List<User2>> findByFirstName(String firstName);

}
