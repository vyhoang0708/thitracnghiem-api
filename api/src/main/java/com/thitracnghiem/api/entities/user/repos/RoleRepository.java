package com.thitracnghiem.api.entities.user.repos;

import com.thitracnghiem.api.entities.user.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
    Role findByName(String name);
    Role findById(long id);
}
