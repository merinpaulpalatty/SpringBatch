
/*
 *  29-Oct-2020
 *  Copyright (c) 2020 Muthoot Group. All Rights Reserved.
 */

package com.ust.springBatch.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.ust.springBatch.model.User;

/**
 * The Class Processor.
 */
@Component
public class Processor implements ItemProcessor<User, User> {

    /** The Constant DEPT_NAMES. */
    private static final Map<String, String> DEPT_NAMES = new HashMap<>();

    /**
     * Instantiates a new processor.
     */
    public Processor() {
        Processor.DEPT_NAMES.put("100", "Dev");
        Processor.DEPT_NAMES.put("200", "Tester");
        Processor.DEPT_NAMES.put("300", "Manager");
    }

    /**
     * Process.
     *
     * @param user the user
     * @return the user
     * @throws Exception the exception
     */
    @Override
    public User process(User user) throws Exception {

        final String deptCode = user.getDept();
        user.setDept(Processor.DEPT_NAMES.get(deptCode));
        user.setTime(new Date());
        System.out.println("While processing " + user);
        return user;
    }

}
