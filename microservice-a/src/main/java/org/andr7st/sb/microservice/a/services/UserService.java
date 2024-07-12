package org.andr7st.sb.microservice.a.services;

import org.andr7st.sb.microservice.a.models.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserEntity> list();

    // Optional es una clase que envuelve el objeto y evitar los nullPointerException
    Optional<UserEntity> byId(Long id);

    UserEntity save(UserEntity user);

    void delete(Long id);

}
