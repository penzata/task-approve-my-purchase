package handlers;

import common.Type;


/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver {
    @Override
    public void approve(int id, double cost, Type type) {
        if (canApprove(cost, type)) {
            System.out.printf("Vice President approved purchase (%s) with id %d that costs %.2f.%n%n", type, id, cost);
        } else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than Vice President.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected double getPurchaseLimit(Type type) {
        return switch (type) {
            case CONSUMABLES -> 700;
            case CLERICAL -> 1500;
            case GADGETS -> 2000;
            case GAMING -> 4500;
            case PC -> 6500;
        };
    }

}