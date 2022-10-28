package handlers;

import common.Type;

/**
 * //TODO - Implement approval implementation for President level
 */
public class President extends Approver{
    @Override
    public void approve(int id, double cost, Type type) {
        if (canApprove(cost, type)) {
            System.out.printf("President approved purchase (%s) with id %d that costs %.2f.%n%n", type, id, cost);
        } else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than President.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected int getPurchaseLimit(Type type) {
        return switch (type) {
            case CONSUMABLES -> 1000;
            case CLERICAL -> 2000;
            case GADGETS -> 3000;
            case GAMING -> 5000;
            case PC -> 8000;
        };
    }

}