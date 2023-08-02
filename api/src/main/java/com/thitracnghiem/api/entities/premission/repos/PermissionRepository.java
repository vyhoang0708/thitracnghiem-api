package com.thitracnghiem.api.entities.premission.repos;

import com.thitracnghiem.api.entities.premission.entities.Permission;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {
}
