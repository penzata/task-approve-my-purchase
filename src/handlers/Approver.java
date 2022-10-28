package handlers;

import common.Type;

public abstract class Approver {

    protected Approver next;

    /**
     * If needed, be free to change signature of abstract methods.
     */
    public abstract void approve(int id, double cost, Type type);
    protected boolean canApprove(double cost, Type type) {
        return cost <= this.getPurchaseLimit(type);
    }
    protected abstract int getPurchaseLimit(Type type);
    /**
     * Method used for registering next approver level.
     * DO NOT CHANGE IT.
     */
    public Approver registerNext(Approver next) {
        this.next = next;
        return next;
    }

}