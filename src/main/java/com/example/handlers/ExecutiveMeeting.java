package com.example.handlers;

import com.example.common.MessageApproval;
import com.example.common.Purchase;
import java.util.Random;


/**
 * Used as a fallback in approval chain.
 * Should not contain any additional logic.
 * If abstract methods are changed, be free to edit signatures.
 */
public class ExecutiveMeeting extends Approver {
    private static final String NAME = "Executive Meeting";
    private static final Random rand = new Random();

    private ExecutiveMeeting() {
    }

    private static class ExecutiveMeetingHelper {
        private static final ExecutiveMeeting INSTANCE = new ExecutiveMeeting();
    }

    public static ExecutiveMeeting getInstance() {
        return ExecutiveMeetingHelper.INSTANCE;
    }

    @Override
    public void approve(Purchase purchase) {
        MessageApproval.startMeeting(NAME, purchase);
        if (canApprove(purchase)) {
            System.out.println("Purchase approved at the meeting.\n");
        } else {
            System.out.println("Purchase not approved at the meeting. Try next month.\n");
        }
    }

    @Override
    protected double getPurchaseLimit(Purchase purchase) {
        double surplus = rand.nextDouble() * 2000;

        return switch (purchase.type()) {
            case CONSUMABLES, CLERICAL, GADGETS -> 2000 + surplus;
            case GAMING, PC -> 6500 + surplus;
        };
    }
}