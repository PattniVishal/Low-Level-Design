package service.split;

import model.Expense;
import model.User;

import java.util.Map;
import java.util.Set;

public class EqualSplitStrategy implements ISplitStrategy {
    private Map<Long, Double> percentage;

    public EqualSplitStrategy(Map<Long, Double> percentage) {
        this.percentage = percentage;
    }

    @Override
    public void calculateAmountOwed(Expense expense) {
        Double amountSpent = expense.getAmountSpent();
        Map<User, Double> amountOwed = expense.getAmountOwed();
        Set<User> participants = expense.getParticipants();
        for (User participant:
             participants) {
            Double percentageShare = percentage.get(participant.getId());
            Double amount = amountSpent * percentageShare / 100;    // FORMULA
            amountOwed.put(participant, amount);
        }
    }
}
