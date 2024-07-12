package org.andr7st.sb.microservice.a.repositories;

import org.andr7st.sb.microservice.a.models.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

// No es necesario anotar con @Repository, ya que implicitamente lo es
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
