package seedu.easylog.commands.orderscommands;

import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyOrderListException;
import seedu.easylog.exceptions.EmptyOrderIndexException;
import seedu.easylog.exceptions.InvalidNumberException;
import seedu.easylog.exceptions.WrongOrdersDeleteCommandException;
import seedu.easylog.model.OrderManager;
import seedu.easylog.model.Item;

public class OrdersDeleteCommand extends OrdersCommand {
    /**
     * Deletes a single order from the list of orders.
     */
    public void execute(String ordersArg, OrderManager orderManager)
            throws EmptyOrderIndexException, InvalidNumberException, EmptyOrderListException,
            WrongOrdersDeleteCommandException {
        if (!ordersArg.isEmpty()) {
            throw new WrongOrdersDeleteCommandException();
        }
        int ordersListSize = orderManager.getSize();
        if (ordersListSize == 0) {
            throw new EmptyOrderListException();
        }
        boolean stopAskingForOrderIndex = false;
        String orderIndexInString = " ";
        while (!stopAskingForOrderIndex && !orderIndexInString.equals(Constants.GIVE_UP_DELETE_SIGNAL)) {
            ui.askForOrderIndex();
            OrdersListCommand ordersListCommand = new OrdersListCommand();
            ordersListCommand.execute(orderManager);

            orderIndexInString = ui.askForUserInput();

            try {
                if (orderIndexInString.equals(Constants.GIVE_UP_DELETE_SIGNAL)) {
                    ui.showMessageLine();
                    break;
                }
                if (orderIndexInString.equals("")) {
                    throw new EmptyOrderIndexException();
                }
                int index = Integer.parseInt(orderIndexInString) - Constants.ARRAY_OFFSET;
                int size = orderManager.getSize();
                if ((index < 0) || (index >= size)) {
                    throw new InvalidNumberException();
                }
                if (!orderManager.getOrder(index).getStatus()) {
                    // return item stock to inventory if order is not complete.
                    int itemStockIndex = 0;
                    for (Item item : orderManager.getItemsInOrder(index)) {
                        int itemCurrentStock = item.getItemStock();
                        int itemsStockInOrder = orderManager.getOrder(index).getStockCounts().get(itemStockIndex);
                        int itemUpdateStock = itemCurrentStock + itemsStockInOrder;
                        item.setItemStock(itemUpdateStock);
                        ++itemStockIndex;
                    }
                    ui.showOrderDeleted(orderManager.getOrder(index));
                    orderManager.deleteOrder(index);
                    stopAskingForOrderIndex = true;
                }
            } catch (EmptyOrderIndexException e) {
                ui.showEmptyOrderIndexToDelete();
            } catch (InvalidNumberException e) {
                ui.showInvalidOrderIndexToDelete();
            } catch (NumberFormatException e) {
                ui.showNonIntegerOrderIndexToDelete();
            }
        }
        int size = orderManager.getSize();
        assert orderManager.getSize() == size - 1 : "After a valid deletion, the size decreases by 1";
        if (size > 1) {
            assert orderManager.getOrder(orderManager.getSize() - 1) == orderManager.getOrder(size - 2) :
                    "After a valid deletion, the second last order becomes the last order";
        }
    }
}

