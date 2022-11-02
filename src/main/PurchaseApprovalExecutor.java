package main;

import common.Type;
import handlers.Approver;
import handlers.Manager;
import java.util.Random;

/**
 * Execution class of the application.
 * Be free to modify below line 14 (bellow comment line)
 */
public class PurchaseApprovalExecutor {
    private static final Random rand = new Random();

    private PurchaseApprovalExecutor() {
    }

    public static void execute() {
        Approver manager = new Manager();
        ApprovalChainGenerator.generate(manager);
        //Be free to modify method below this line
        int numberOfPurchasesForMonth = rand.nextInt(1, 24);

        for (int i = 1; i <= numberOfPurchasesForMonth; i++) {
            double randomCost = Math.random() * 8100;
            Type randomType = Type.values()[rand.nextInt(Type.values().length)];
            manager.approve(i, randomCost, randomType);
        }
    }
}