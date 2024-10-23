package com.oci.virtualcommunity.repository;

import com.oci.virtualcommunity.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("select u from User u where u.userName=?1")
    public User selectByName(String str);
}
