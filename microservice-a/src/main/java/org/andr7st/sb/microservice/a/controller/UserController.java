package org.andr7st.sb.microservice.a.controller;

import org.andr7st.sb.microservice.a.models.entity.UserEntity;
import org.andr7st.sb.microservice.a.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserEntity> list() {
        return service.list();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<?> userById(@PathVariable Long id) {
        Optional<UserEntity> userEntityOptional = service.byId(id);
        if(userEntityOptional.isPresent()) {
            // return ResponseEntity.ok().body(userEntityOptional.get()); // opción correcta
            return ResponseEntity.ok(userEntityOptional.get()); // alternativa
        }
        return ResponseEntity.notFound().build(); // 404
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@RequestBody UserEntity user) {
        return service.save(user);
    }

    // Alternativa de la anterior, hace exactamente lo mismo
    @PostMapping("/response")
    public ResponseEntity<?> createUserResponse(@RequestBody UserEntity user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody UserEntity user, @PathVariable Long id) {
        Optional<UserEntity>  op = service.byId(id);
        if (op.isPresent()) {
            UserEntity userEntityDb = op.get();
            userEntityDb.setName(user.getName());
            userEntityDb.setEmail(user.getEmail());
            userEntityDb.setPassword(user.getPassword());
            return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(userEntityDb));
        }
        return ResponseEntity.notFound().build(); // 404
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<UserEntity> o = service.byId(id);
        if(o.isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build(); // 404
    }
}
