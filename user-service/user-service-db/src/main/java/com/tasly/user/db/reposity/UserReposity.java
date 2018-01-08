package com.tasly.user.db.reposity;

import com.tasly.user.db.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dulei on 18/1/8.
 */
public interface UserReposity extends JpaRepository<User,Long> {

}
