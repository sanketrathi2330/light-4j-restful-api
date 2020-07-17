package com.swift.fusers.repository;

import com.swift.fusers.model.User;

import java.util.List;

/**
 * <p>Copyright (c) 2020 Blue Yonder Group, Inc.
 * All Rights Reserved
 *
 * @author Sanket Rathi.
 */
public interface IUserRepository {
    public User getUser (int id);

    public List<User> getAllUsers();

    public void addUser (User user);

    public void deleteUser (int id);

    public void deleteAllUsers() ;

    public void updateUser (User user, int id);
}
