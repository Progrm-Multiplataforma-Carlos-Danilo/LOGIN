package com.api.controller;

import com.api.controller.adapter.UserControllerAdapter;
import com.api.controller.dto.request.UserRequest;
import com.api.controller.dto.response.UserResponse;


import com.api.entity.User;
import com.api.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login/v1/user")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/salvar")
    public UserResponse salvar(@RequestBody UserRequest request) {
        User save = repository.salvar(UserControllerAdapter.cast(request));
        return new UserResponse(
                save.id(),
                save.username(),
                save.email(),
                save.password(),
                save.roles());
    }
    @PutMapping("/atualizar")
    public UserResponse atualizar(@RequestBody UserRequest request) {
        User user = UserControllerAdapter.castUpdate(request);
        User userAtualizado = repository.atualizar(user);
        return new UserResponse(
                userAtualizado.id(),
                userAtualizado.username(),
                userAtualizado.email(),
                userAtualizado.password(),
                userAtualizado.roles());
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id) {
        repository.deletar(id);
        return "User deletado com sucesso";
    }

    @GetMapping("/listar")
    public List<UserResponse> listar() {
        return repository.listar().stream()
                .map(user -> new UserResponse(
                        user.id(),
                        user.username(),
                        user.email(),
                        user.password(),
                        user.roles()
                ))
                .collect(Collectors.toList());
    }
}
