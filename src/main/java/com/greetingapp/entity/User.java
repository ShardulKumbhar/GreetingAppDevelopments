package com.greetingapp.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created Entity class to use in this format
 */
@Getter
@Setter
public class User {

    /**
     * name and lastname
     */
    String firstName;
    String lastName;

    @Override
    public String toString() {
        String str = (firstName != null) ? firstName + " " : "";
        str += (lastName != null) ? lastName : "";
        return str.trim();
    }
}