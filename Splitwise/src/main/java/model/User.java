package model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User extends DBObject {
    private String name;
    private String phoneNumber;
    private String password;
    private Set<Expense> expenses;
    private Set<Group> groups;

    public User(String name, String phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        expenses = new HashSet<>();
        groups = new HashSet<>();
    }
}
