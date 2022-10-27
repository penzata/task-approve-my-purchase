import common.Type;
import handlers.Approver;
import handlers.Manager;

import java.util.Random;

/**
 * Execution class of the application.
 * Be free to modify below line 14 (bellow comment line)
 */
public class PurchaseApprovalExecutor {

    public static void execute() {
        Approver manager = new Manager();
        ApprovalChainGenerator.generate(manager);
        //Be free to modify method below this line
        int randomNumberOfPurchases = (int) (Math.random() * 20) + 1;
        System.out.println(randomNumberOfPurchases);

        for (int i = 1; i <= randomNumberOfPurchases; i++) {
            int randomCost = (int) (Math.random() * 19000);
            System.out.println("generated cost of item: " + randomCost);
            Type randomType = Type.values()[new Random().nextInt(Type.values().length)];
            System.out.println("generated type of item: " + randomType);
            manager.approve(i, randomCost, randomType);
        }
    }
}
