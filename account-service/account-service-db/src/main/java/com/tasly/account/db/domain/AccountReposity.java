package com.tasly.account.db.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dulei on 18/1/8.
 */
public interface AccountReposity extends JpaRepository<Account,Long> {

}
