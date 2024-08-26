package org.andr7st.sbm.mcs_users.repositories;

import org.andr7st.sbm.mcs_users.models.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryI extends CrudRepository<UserEntity, Long> {
}
