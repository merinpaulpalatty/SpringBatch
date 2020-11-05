/*
 *  29-Oct-2020
 *  Copyright (c) 2020 Muthoot Group. All Rights Reserved.
 */
package com.ust.springBatch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class User.
 */
@Entity
public class User {

    /** The id. */
    @Id
    private int id;

    /** The name. */
    private String name;

    /** The dept . */
    private String dept;

    /** The salary. */
    private int salary;

    /** The time. */
    private Date time;

    /**
     * Instantiates a new user.
     */
    public User() {

    }

    /**
     * Instantiates a new user User.
     *
     * @param id     the id
     * @param name   the name
     * @param dept   the dept
     * @param salary the salary
     * @param time the time
     */
    public User(int id, String name, String dept, int salary, Date time) {
        super();
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.time = time;
    }

    /**
     * Gets the dept ID.
     *
     * @return the dept ID
     */
    public String getDept() {
        return dept;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the salary.
     *
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Gets the time.
     *
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * Sets the dept ID.
     *
     * @param dept the new dept
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the salary.
     *
     * @param salary the new salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Sets the time.
     *
     * @param time the new time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
    }

}
