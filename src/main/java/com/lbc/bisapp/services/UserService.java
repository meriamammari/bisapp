package com.lbc.bisapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lbc.bisapp.entities.User;
import com.lbc.bisapp.iservice.IUserService;
import com.lbc.bisapp.repositories.userRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final userRepository userRepository;

    @Override
    public User createUser(User toPersist) {
        return userRepository.save(toPersist);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User toUpdate) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(toUpdate.getName());
            existingUser.setAge(toUpdate.getAge());
            existingUser.setEmail(toUpdate.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersByDepartment(String departmentName) {
        return userRepository.findAll().stream()
                .filter(user -> user.getDepartment() != null && departmentName.equals(user.getDepartment().getName()))
                .toList();
    }
}
