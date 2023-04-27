package com.bibf.api.employeebackend.repository;

import com.bibf.api.employeebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
