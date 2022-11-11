package com.example.handlers;

import com.example.common.MessageApproval;
import com.example.common.Purchase;

/**
 * //TODO - If needed, validate logic and if possible optimize code
 */
public class Manager extends Approver {
    private static final String NAME = "Manager";

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
            case CONSUMABLES -> 300;
            case CLERICAL -> 500;
            case GADGETS -> 1000;
            case GAMING -> 2000;
            case PC -> 5000;
        };
    }

}