package com.amrni.sport.shop.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amrni.sport.shop.model.User;

public interface UserJpa extends JpaRepository<User, Integer> {

    User findByOpenid(String openId);

}

