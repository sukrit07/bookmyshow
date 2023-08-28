package com.sukrit.bookmyshow.repository;

import com.sukrit.bookmyshow.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Override
    Optional<Users> findById(Long userId);

}
