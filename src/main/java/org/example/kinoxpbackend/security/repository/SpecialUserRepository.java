package org.example.kinoxpbackend.security.repository;

import org.example.kinoxpbackend.security.entity.SpecialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialUserRepository extends JpaRepository<SpecialUser, String> {
}
