package handlers;

import common.Purchase;

public abstract class Approver {

    protected Approver next;

    /**
     * If needed, be free to change signature of abstract methods.
     */
    public abstract void approve(Purchase purchase);
    protected boolean canApprove(Purchase purchase) {
        return purchase.cost() <= this.getPurchaseLimit(purchase);
    }
    protected abstract double getPurchaseLimit(Purchase purchase);
    /**
     * Method used for registering next approver level.
     * DO NOT CHANGE IT.
     */
    public Approver registerNext(Approver next) {
        this.next = next;
        return next;
    }

}