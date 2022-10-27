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
        int numberOfPurchasesForMonth = (int) (Math.random() * 20) + 1;

        for (int i = 1; i <= numberOfPurchasesForMonth; i++) {
            //8000 for most prized item
            int randomCost = (int) (Math.random() * 8000 + 1);
            Type randomType = Type.values()[new Random().nextInt(Type.values().length)];
            manager.approve(i, randomCost, randomType);
        }
    }
}
