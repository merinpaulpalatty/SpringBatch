
/*
 *  29-Oct-2020
 *  Copyright (c) 2020 Muthoot Group. All Rights Reserved.
 */

package com.ust.springBatch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class LoadController.
 */
@RestController
@RequestMapping("/load")
public class LoadController {

    /** The job launcher. */
    @Autowired
    private JobLauncher jobLauncher;

    /** The job. */
    @Autowired
    private Job job;

    /**
     * Run.
     *
     * @return the batch status
     * @throws JobParametersInvalidException       the job parameters invalid
     *                                             exception
     * @throws JobExecutionAlreadyRunningException the job execution already running
     *                                             exception
     * @throws JobRestartException                 the job restart exception
     * @throws JobInstanceAlreadyCompleteException the job instance already complete
     *                                             exception
     */
    @GetMapping
    public BatchStatus run() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException {

        final Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        final JobParameters parameters = new JobParameters(maps);
        final JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("batch is runnig");
        while (jobExecution.isRunning()) {
            System.out.println(".......................");
        }

        System.out.println("status+++++++++++" + jobExecution.getStatus());
        return jobExecution.getStatus();

    }

}
