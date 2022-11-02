package handlers;

import common.MessageApproval;
import common.Purchase;

/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver {
    private static final String NAME = "Vice President";
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
            case CONSUMABLES -> 700;
            case CLERICAL -> 1500;
            case GADGETS -> 2000;
            case GAMING -> 4500;
            case PC -> 6500;
        };
    }

}