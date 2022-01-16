package model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Group extends DBObject {
    String groupName;
    User admin;
    Set<User> members;
    Set<Expense> expenses;

    public Group(String groupName, User admin) {
        this.groupName = groupName;
        this.admin = admin;
    }

    public void addMember(User newUser){
        this.members.add(newUser);
    }

    public void removeUser(User user){
        this.members.remove(user);
    }
}
