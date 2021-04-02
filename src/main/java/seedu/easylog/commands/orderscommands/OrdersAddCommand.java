package seedu.easylog.commands.orderscommands;

import seedu.easylog.commands.itemscommands.ItemsListCommand;
import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyItemListException;
import seedu.easylog.exceptions.EmptyNameException;
import seedu.easylog.exceptions.OrderEmptyException;
import seedu.easylog.exceptions.RepeatedOrderException;

import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;

/**
 * Adds orders to the system.
 */
public class OrdersAddCommand extends OrdersCommand {

    public void execute(String customerName, ItemManager itemManager, OrderManager orderManager)
            throws EmptyNameException, EmptyItemListException {
        if (customerName.trim().equals("")) {
            throw new EmptyNameException();
        }
        if (itemManager.getItemList().isEmpty()) {
            throw new EmptyItemListException();
        }
        if (orderManager.checkRepeatOrder(customerName)) {
            repeatedOrdersAdd(customerName, itemManager, orderManager);
        } else {
            ItemsListCommand itemsListCommand = new ItemsListCommand();
            itemsListCommand.execute(itemManager); // to show available items and item stock
            ui.showAddItemsToOrder();
            String addItemsToOrderInput = ui.askForUserInput();
            Order order = ordersParser.processItemsAddedToOrder(customerName, addItemsToOrderInput, itemManager);
            orderManager.addOrder(order);
            assert orderManager.getLatestOrderAdded().equals(order);
            ui.showOrderAdded(order);
        }
    }

    /**
     * Adds an order which already exists.
     * The user will be prompted to enter the item under the existing customer name.
     *
     * @param customerName a boolean flag which indicate if the item exist in the item list
     * @param itemManager  the arrayList of all item descriptions in the system
     * @param orderManager the description of an item
     */
    public void repeatedOrdersAdd(String customerName, ItemManager itemManager,
                                  OrderManager orderManager) {
        ItemsListCommand itemsListCommand = new ItemsListCommand();
        itemsListCommand.execute(itemManager);
        ui.showAddItemsToOrder();
        String addItemsToOrderInput = ui.askForUserInput();
        Order order = ordersParser.processItemsAddedToExistingOrder(customerName, addItemsToOrderInput,
                itemManager, orderManager);
        orderManager.addOrder(order);
        ui.showOrderAdded(order);
    }
}



