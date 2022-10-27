package handlers;

import common.Type;


/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver {
    @Override
    public void approve(int id, double cost, Type type) {
        if (canApprove(id, cost, type)) {
            System.out.printf("Vice President approved purchase (%s) with id %d that costs %.2f.\n\n", type, id, cost);
        } else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than Vice President.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected boolean canApprove(int id, double cost, Type type) {

        switch (type) {
            case CONSUMABLES -> {
                return cost <= 700;
            }

            case CLERICAL -> {
                return cost <= 1500;
            }

            case GADGETS -> {
                return cost <= 2000;
            }

            case GAMING -> {
                return cost <= 4500;
            }

            case PC -> {
                return cost <= 6500;
            }
        }
        return false;
    }

}
