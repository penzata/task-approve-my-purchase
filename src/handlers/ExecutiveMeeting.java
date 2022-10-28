package handlers;

import common.Type;


/**
 * Used as a fallback in approval chain.
 * Should not contain any additional logic.
 * If abstract methods are changed, be free to edit signatures.
 */
public class ExecutiveMeeting extends Approver {
    private static final ExecutiveMeeting INSTANCE = new ExecutiveMeeting();

    private ExecutiveMeeting() {
    }

    public static ExecutiveMeeting getInstance() {
        return INSTANCE;
    }

    @Override
    public void approve(int id, double cost, Type type) {
        System.out.printf("Purchase (%s) with id %d that costs %.2f requires an approval of executive meeting.%n", type, id, cost);
        if (canApprove(cost, type)) {
            System.out.println("Purchase approved at the meeting.\n");
        } else {
            System.out.println("Purchase not approved at the meeting. Try next month.\n");
        }
    }

    @Override
    protected int getPurchaseLimit(Type type) {
        int surplus = (int) (Math.random() * 1000);

        return switch (type) {
            case CONSUMABLES, CLERICAL, GADGETS -> 3000 + surplus;
            case GAMING, PC -> 8000 + surplus;
        };
    }
}