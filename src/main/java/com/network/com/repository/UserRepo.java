package com.network.com.repository;



import com.network.com.entity.User;
import com.network.com.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User>  findFirstByEmail(String Email);

    User findByRole(UserRole userRole);
}