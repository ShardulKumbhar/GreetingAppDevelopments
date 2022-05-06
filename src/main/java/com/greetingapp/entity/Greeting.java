package com.greetingapp.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Creating a Table name as GREETING
 * and having ID and message
 */
@Entity
@Getter
@Table(name = "GREETING")

public class Greeting {
    /*
    Condition ID should me not null
    Should auto increment
     */
    @Id
    @Column(name = "id", nullable = false)
    private final long id;
    private final String message;

    /**
     * Created a constructor to pass message
     *
     * @param id
     * @param message
     */
    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    /**
     * Pass the message in Greeting Table with id and message/name
     */
    public Greeting() {
        id = 0;
        message = "";
    }
}
