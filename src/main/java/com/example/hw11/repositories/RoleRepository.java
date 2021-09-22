package com.example.hw11.repositories;

import com.example.hw11.entities.Role;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dao")
public interface RoleRepository extends CrudRepository<Role, Long> {
}
