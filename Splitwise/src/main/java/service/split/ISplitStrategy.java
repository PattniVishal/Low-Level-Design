package service.split;

import model.Expense;

public interface ISplitStrategy {
    public void calculateAmountOwed(Expense expense);
}
