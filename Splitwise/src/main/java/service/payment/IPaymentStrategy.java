package service.payment;

import model.Expense;

public interface IPaymentStrategy {
    public void amountPaid(Expense expense);
}
