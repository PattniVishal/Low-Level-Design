package service.payment;

import model.Expense;
import model.User;

import java.util.Map;
import java.util.Set;

public class EqualSharePaymentStrategy implements IPaymentStrategy{
    private Double totalAmount;

    public EqualSharePaymentStrategy(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public void amountPaid(Expense expense) {
        Set<User> participants = expense.getParticipants();
        Map<User, Double> amountPaid = expense.getAmountPaid();
        Double equalShare = totalAmount / participants.size();
        for (User participant:
                participants) {
            amountPaid.put(participant, equalShare);
        }
    }
}
