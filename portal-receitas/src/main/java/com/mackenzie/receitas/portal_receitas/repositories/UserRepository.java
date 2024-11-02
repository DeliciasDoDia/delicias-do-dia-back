package com.mackenzie.receitas.portal_receitas.repositories;

import com.mackenzie.receitas.portal_receitas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
