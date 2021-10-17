package com.eniso.regimi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eniso.regimi.models.ERole;
import com.eniso.regimi.models.Role;



public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
