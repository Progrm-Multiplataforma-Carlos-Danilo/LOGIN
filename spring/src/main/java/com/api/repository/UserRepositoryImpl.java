package com.api.repository;



import com.api.entity.User;
import com.api.repository.adapter.UserRepositoryAdapter;
import com.api.repository.client.UserRepositoryWithMongodb;
import com.api.repository.orm.UserOrmMongo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final PasswordEncoder encoder;
    private final UserRepositoryWithMongodb repository;

    public UserRepositoryImpl(
            PasswordEncoder encoder,
            UserRepositoryWithMongodb repository) {
        this.encoder = encoder;
        this.repository = repository;
    }

    @Override
    public User salvar(User user) {
        try {
            UserOrmMongo orm = repository.save(UserRepositoryAdapter.cast(user, encoder));
            return UserRepositoryAdapter.cast(orm);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            Optional<UserOrmMongo> optional = repository.findByUsername(username);
            if (optional.isEmpty()) {
                throw new UsernameNotFoundException("Usuario não encontrado");
            }
            return UserRepositoryAdapter.cast(optional.get());
        } catch (UsernameNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public User atualizar(User user) {
        try {
            Optional<UserOrmMongo> optional = repository.findById(user.id());
            if (optional.isEmpty()) {
                throw new RuntimeException("Usuario não encontrado para atualizar");
            }
            UserOrmMongo orm = repository.save(UserRepositoryAdapter.cast(user, encoder));
            return UserRepositoryAdapter.cast(orm);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deletar(String id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<User> listar() {
        try {
            return repository.findAll().stream()
                    .map(UserRepositoryAdapter::cast)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}