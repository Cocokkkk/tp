package seedu.easylog.commands.orderscommands;

import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyNumberException;
import seedu.easylog.exceptions.InvalidNumberException;
import seedu.easylog.model.OrderManager;

public class OrdersPriceCommand extends OrdersCommand {

    /**
     * Get the total price of a single order from the list of orders.
     */
    public void execute(String ordersArg, OrderManager orderManager)
            throws EmptyNumberException, InvalidNumberException {
        if (ordersArg.trim().equals("")) {
            throw new EmptyNumberException();
        }
        int index = Integer.parseInt(ordersArg) - Constants.ARRAY_OFFSET;
        int size = orderManager.getSize();
        if ((index < 0) || (index >= size)) {
            throw new InvalidNumberException();
        }
        ui.showOrderTotalPrice(orderManager.getOrder(index));
    }
}


