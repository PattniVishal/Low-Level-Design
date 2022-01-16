package controller;

import model.Expense;
import model.User;
import service.split.ISplitStrategy;

import java.util.Map;
import java.util.Set;

public class ExpenseController {
    public void createExpense(String description,
                              Double amountSpent,
                              User admin,
                              Set<User> participants,
                              ISplitStrategy splitStrategy){
        Expense newExpense = new Expense(description, amountSpent, participants);
        splitStrategy.calculateAmountOwed(newExpense);
        System.out.println("Expense Created !!");
    }
}
