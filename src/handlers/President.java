package handlers;

import common.Type;

/**
 * //TODO - Implement approval implementation for President level
 */
public class President extends Approver{
    @Override
    public void approve(int id, double cost, Type type) {
        if (canApprove(id, cost, type)) {
            System.out.printf("President approved purchase (%s) with id %d that costs %.2f.\n\n", type, id, cost);
        } else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than President.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected boolean canApprove(int id, double cost, Type type) {
        switch (type) {
            case CONSUMABLES -> {
                return cost < 1000;
            }

            case CLERICAL -> {
                return cost < 2000;
            }

            case GADGETS -> {
                return cost < 3000;
            }

            case GAMING -> {
                return cost < 5000;
            }

            case PC -> {
                return cost < 8000;
            }
        }
        return false;
    }
}
