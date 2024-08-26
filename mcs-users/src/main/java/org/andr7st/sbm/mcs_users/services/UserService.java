package org.andr7st.sbm.mcs_users.services;

import org.andr7st.sbm.mcs_users.models.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserEntity> list();

    Optional<UserEntity> byId(Long id);

    UserEntity save(UserEntity usersEntity);

    void delete(Long id);
}
