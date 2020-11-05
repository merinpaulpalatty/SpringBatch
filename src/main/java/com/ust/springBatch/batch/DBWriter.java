
/*
 *  29-Oct-2020
 *  Copyright (c) 2020 Muthoot Group. All Rights Reserved.
 */

package com.ust.springBatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.springBatch.model.User;
import com.ust.springBatch.repository.UserRepository;

/**
 * The Class DBWriter.
 */
@Component
public class DBWriter implements ItemWriter<User> {

    /** The user repository. */
    @Autowired
    private UserRepository userRepository;

    /**
     * Write.
     *
     * @param users the users
     * @throws Exception the exception
     */
    @Override
    public void write(List<? extends User> users) throws Exception {
        System.out.println("item saved for Users" + users);
        userRepository.saveAll(users);
    }

}
