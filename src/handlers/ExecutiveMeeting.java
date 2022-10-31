package handlers;

import common.Type;
import java.util.Random;


/**
 * Used as a fallback in approval chain.
 * Should not contain any additional logic.
 * If abstract methods are changed, be free to edit signatures.
 */
public class ExecutiveMeeting extends Approver {
    private static final Random rand = new Random();

    private ExecutiveMeeting() {
    }

    private static class MeetingHelper {
        private static final ExecutiveMeeting INSTANCE = new ExecutiveMeeting();
    }

    public static ExecutiveMeeting getInstance() {
        return MeetingHelper.INSTANCE;
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
    protected double getPurchaseLimit(Type type) {
        double surplus = rand.nextDouble() * 2000;

        return switch (type) {
            case CONSUMABLES, CLERICAL, GADGETS -> 2000 + surplus;
            case GAMING, PC -> 6500 + surplus;
        };
    }
}