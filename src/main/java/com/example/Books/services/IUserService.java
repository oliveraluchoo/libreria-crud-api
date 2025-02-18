package com.example.Books.services;

import com.example.Books.entities.User;

public interface IUserService {
    public User getUserById(Long id);
    public User getUserByUsername(String username);
    public User saveUser(User givenUser);
}
