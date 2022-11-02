package handlers;

import common.MessageApproval;
import common.Purchase;

/**
 * //TODO - Implement approval implementation for President level
 */
public class President extends Approver{
    private static final String NAME = "President";
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
            case CONSUMABLES -> 1000;
            case CLERICAL -> 2000;
            case GADGETS -> 3000;
            case GAMING -> 5000;
            case PC -> 8000;
        };
    }

}