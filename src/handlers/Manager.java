package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code
 */
public class Manager extends Approver {
    @Override
    public void approve(int id, double cost, Type type) {
        if (canApprove(cost, type)) {
            System.out.printf("Manager approved purchase (%s) with id %d that costs %.2f.%n%n", type, id, cost);
        } else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than Manager.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected int getPurchaseLimit(Type type) {
        return switch (type) {
            case CONSUMABLES -> 300;
            case CLERICAL -> 500;
            case GADGETS -> 1000;
            case GAMING -> 2000;
            case PC -> 5000;
        };
    }

}