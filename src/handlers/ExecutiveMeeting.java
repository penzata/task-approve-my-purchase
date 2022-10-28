package handlers;

import common.Type;
import java.util.Random;

/**
 * Used as a fallback in approval chain.
 * Should not contain any additional logic.
 * If abstract methods are changed, be free to edit signatures.
 */
public class ExecutiveMeeting extends Approver {
    private static final ExecutiveMeeting INSTANCE = new ExecutiveMeeting();

    public static ExecutiveMeeting getInstance() {
        return INSTANCE;
    }

    @Override
    public void approve(int id, double cost, Type type) {
        System.out.printf("Purchase (%s) with id %d that costs %.2f requires an approval of executive meeting.\n", type, id, cost);
        if (canApprove(cost, type)) {
            System.out.println("Purchase approved at the meeting.\n");
        } else {
            System.out.println("Purchase not approved at the meeting. Try next month.\n");
        }
    }

    @Override
    protected boolean canApprove(double cost, Type type) {
        Type typeToConsider = Type.values()[new Random().nextInt(Type.values().length)];
        double amountOfMoneyGotToSpent = Math.random() * (cost * 2);

        return (typeToConsider == type && amountOfMoneyGotToSpent >= cost);
    }
}
