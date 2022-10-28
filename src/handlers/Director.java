package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code.
 */
public class Director extends Approver {

    @Override
    public void approve(int id, double cost, Type type) {
        if (canApprove(cost, type)) {
            System.out.printf("Director approved purchase (%s) with id %d that costs %.2f.%n%n", type, id, cost);
        } else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than Director.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected int getPurchaseLimit(Type type) {
        return switch (type) {
            case CONSUMABLES -> 500;
            case CLERICAL -> 1000;
            case GADGETS -> 1500;
            case GAMING ->  3000;
            case PC -> 6000;
        };
    }

}