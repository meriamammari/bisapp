package com.lbc.bisapp.iservice;

import java.util.List;

import com.lbc.bisapp.entities.User;
public interface IUserService {
    User createUser(User toPersist);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User toUpdate);
    void deleteUser(Long id);
    List<User> getUsersByDepartment(String departmentName);
}
