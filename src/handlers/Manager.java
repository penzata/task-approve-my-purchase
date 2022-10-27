package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code
 */
public class Manager extends Approver {
    @Override
    public void approve(int id, double cost, Type type) {
        if (canApprove(id, cost, type)) {
            System.out.printf("Manager approved purchase (%s) with id %d that costs %.2f.\n\n", type, id, cost);
        } else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than Manager.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected boolean canApprove(int id, double cost, Type type) {
        switch (type) {
            case CONSUMABLES -> {
                return cost <= 300;
            }
            case CLERICAL -> {
                return cost <= 500;
            }
            case GADGETS -> {
                return cost <= 1000;
            }
            case GAMING -> {
                return cost <= 2000;
            }
            case PC -> {
                return cost <= 5000;
            }
            default -> {return false;}
        }
    }

}
