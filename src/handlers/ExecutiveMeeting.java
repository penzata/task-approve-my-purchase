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
        System.out.println("Purchase with id " + id + " that costs " + cost + " requires an approval of executive meeting.");
        if (canApprove(id, cost, type)) {
            System.out.println("Purchase approved.\n");
        } else {
            System.out.println("Purchase not approved. Try next month.\n");
        }
    }

    @Override
    protected boolean canApprove(int id, double cost, Type type) {
        Type typeToConsider = Type.values()[new Random().nextInt(Type.values().length)];
        System.out.println("type to consider at meeting: " + typeToConsider);
        double amountOfMoneyToSpent = (int) (Math.random() * cost * 2);
        System.out.println("money at meeting: " + amountOfMoneyToSpent);

        return (typeToConsider == type && amountOfMoneyToSpent >= cost);
    }
}
