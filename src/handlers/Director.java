package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code.
 */
public class Director extends Approver {

    @Override
    public void approve(int id, double cost, Type type) {
        if (canApprove(id, cost, type)) {
            System.out.printf("Director approved purchase (%s) with id %d that costs %.2f.\n\n", type, id, cost);
        } else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than Director.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected boolean canApprove(int id, double cost, Type type) {
        switch (type) {
            case CONSUMABLES -> {
                return cost <= 500;
            }
            case CLERICAL -> {
                return cost <= 1000;
            }
            case GADGETS -> {
                return cost <= 1500;
            }
            case GAMING -> {
                return cost <= 3000;
            }
            case PC -> {
                return cost <= 6000;
            }
        }
        return false;
    }

}

