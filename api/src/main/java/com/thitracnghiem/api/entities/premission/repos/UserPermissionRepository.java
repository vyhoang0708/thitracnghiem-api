package com.thitracnghiem.api.entities.premission.repos;

import com.thitracnghiem.api.entities.premission.entities.UserPermission;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserPermissionRepository extends CrudRepository<UserPermission, Long>, JpaSpecificationExecutor<UserPermission> {
}
