package org.andr7st.sb.microservice.a.services;

import org.andr7st.sb.microservice.a.models.entity.UserEntity;
import org.andr7st.sb.microservice.a.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

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
    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
