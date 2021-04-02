package seedu.easylog.commands.orderscommands;

import seedu.easylog.exceptions.EmptyNameException;
import seedu.easylog.exceptions.OrderNotFoundException;
import seedu.easylog.model.OrderManager;

public class OrdersFindCommand extends OrdersCommand {
    /**
     * Prints relevant orders by customer's name.
     */
    public void execute(String customerName, OrderManager orderManager) 
        throws EmptyNameException, OrderNotFoundException {
        if (customerName.trim().equals("")) {
            throw new EmptyNameException();
        }
        orderManager.findOrder(customerName);
        if (orderManager.foundOrderEmpty()) {
            throw new OrderNotFoundException();
        }
        String rawOrderListOutput = orderManager.getFoundOrderListPrintFormat();
        ui.showFoundOrderList(rawOrderListOutput);
        orderManager.clearFoundList();
    }
}
