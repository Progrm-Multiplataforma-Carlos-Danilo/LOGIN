package com.api.repository;

import com.api.entity.User;
import java.util.List;

public interface UserRepository {
    User salvar(User user);

    User findByUsername(String username);

    User atualizar(User user);

    void deletar(String id);

    List<User> listar();
}