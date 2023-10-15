package com.example.Repository;

import com.example.Model.AuthenticationToken;
import com.example.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken , Integer> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);
    AuthenticationToken findFirstByUser(User user);
}
