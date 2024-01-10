package com.leonardokazu.crudbasico.repositories;

import com.leonardokazu.crudbasico.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
