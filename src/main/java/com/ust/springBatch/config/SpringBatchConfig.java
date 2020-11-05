
/*
 *  29-Oct-2020
 *  Copyright (c) 2020 Muthoot Group. All Rights Reserved.
 */

package com.ust.springBatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.ust.springBatch.model.User;

/**
 * The Class SpringBatchConfig.
 */
@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    /**
     * File item reader.
     *
     * @param resource the resource
     * @return the flat file item reader
     */
    @Bean
    public FlatFileItemReader<User> itemReader(@Value("${input}") Resource resource) {

        final FlatFileItemReader<User> reader = new FlatFileItemReader<>();
        reader.setResource(resource);
        reader.setName("CSV-Reader");
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());
        return reader;
    }

    /**
     * Job.
     *
     * @param jobBuilderFactory  the job builder factory
     * @param stepBuilderFactory the step builder factory
     * @param itemReader         the item reader
     * @param itemprocessor      the itemprocessor
     * @param itemWriter         the item writer
     * @return the job
     */
    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
            ItemReader<User> itemReader, ItemProcessor<User, User> itemprocessor, ItemWriter<User> itemWriter) {

        final Step step = stepBuilderFactory.get("ETL-file_Load").<User, User>chunk(100).reader(itemReader)
                .processor(itemprocessor).writer(itemWriter).build();

        return jobBuilderFactory.get("ETL_Load").incrementer(new RunIdIncrementer()).start(step).build();
    }

    /**
     * Line mapper.
     *
     * @return the line mapper
     */
    @Bean
    public LineMapper<User> lineMapper() {

        final DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper();
        final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "name", "dept", "salary");
        defaultLineMapper.setLineTokenizer(lineTokenizer);

        final BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(User.class);

        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }

}
