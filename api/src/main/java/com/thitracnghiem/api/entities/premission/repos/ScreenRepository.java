package com.thitracnghiem.api.entities.premission.repos;

import com.thitracnghiem.api.entities.premission.entities.Screen;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ScreenRepository extends CrudRepository<Screen, Long>, JpaSpecificationExecutor<Screen> {
}
