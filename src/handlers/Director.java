package handlers;

import common.MessageApproval;
import common.Purchase;

/**
 * //TODO - If needed, validate logic and if possible optimize code.
 */
public class Director extends Approver {
    private static final String NAME = "Director";

    @Override
    public void approve(Purchase purchase) {
        if (canApprove(purchase)) {
            MessageApproval.approved(NAME, purchase);
        } else {
            MessageApproval.notApproved(NAME, purchase);
            next.approve(purchase);
        }
    }

    @Override
    protected double getPurchaseLimit(Purchase purchase) {
        return switch (purchase.type()) {
            case CONSUMABLES -> 500;
            case CLERICAL -> 1000;
            case GADGETS -> 1500;
            case GAMING ->  3000;
            case PC -> 6000;
        };
    }

}