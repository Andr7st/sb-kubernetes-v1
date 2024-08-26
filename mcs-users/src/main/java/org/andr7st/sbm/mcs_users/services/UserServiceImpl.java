package org.andr7st.sbm.mcs_users.services;

import org.andr7st.sbm.mcs_users.models.entities.UserEntity;
import org.andr7st.sbm.mcs_users.repositories.UserRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryI repository;

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> list() {
        return (List<UserEntity>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> byId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
