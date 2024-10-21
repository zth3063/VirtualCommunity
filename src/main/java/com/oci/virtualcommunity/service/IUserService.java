package com.oci.virtualcommunity.service;


import com.oci.virtualcommunity.entity.User;

public interface IUserService {
    public User add(User user);
    public User update(User user);
    public User select(Integer userId);
    public void delete(Integer userId);
}
