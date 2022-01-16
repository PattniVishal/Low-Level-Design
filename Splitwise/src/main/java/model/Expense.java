package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class Expense extends DBObject {
    String description;
    Double amountSpent;
    Set<User> participants;
    Map<User, Double> amountPaid;
    Map<User, Double> amountOwed;

    public Expense(String description, Double amountSpent, Set<User> participants) {
        this.description = description;
        this.amountSpent = amountSpent;
        this.participants = participants;
        this.amountOwed = new HashMap<>();
        this.amountPaid = new HashMap<>();
    }
}
