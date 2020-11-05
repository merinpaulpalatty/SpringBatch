
/*
 *  29-Oct-2020
 *  Copyright (c) 2020 Muthoot Group. All Rights Reserved.
 */

package com.ust.springBatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.springBatch.model.User;

/**
 * The Interface UserRepository.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
