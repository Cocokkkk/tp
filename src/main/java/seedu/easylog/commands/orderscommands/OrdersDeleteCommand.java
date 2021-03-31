package seedu.easylog.commands.orderscommands;

import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyNumberException;
import seedu.easylog.exceptions.InvalidNumberException;
import seedu.easylog.exceptions.ItemNotFoundException;
import seedu.easylog.exceptions.OrderNotFoundException;
import seedu.easylog.model.OrderManager;
import seedu.easylog.model.Item;

public class OrdersDeleteCommand extends OrdersCommand {
    /**
     * Deletes a single order from the list of orders.
     */
    public void execute(String ordersArg, OrderManager orderManager)
            throws EmptyNumberException, InvalidNumberException, OrderNotFoundException {
        if (ordersArg.equals("")) {
            throw new EmptyNumberException();
        }
        try {
            int index = Integer.parseInt(ordersArg) - Constants.ARRAY_OFFSET;
            int size = orderManager.getSize();
            if ((index < 0) || (index >= size)) {
                throw new InvalidNumberException();
            }
            if (!orderManager.getOrder(index).getStatus()) { // return item stock to inventory if order is not complete.
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
            }
        } catch (NumberFormatException e) {
            if (orderManager.changeOrderFormat(ordersArg) == null) {
                throw new OrderNotFoundException();
            }
            if (!orderManager.getOrder(orderManager.findOrderIndex(ordersArg)).getStatus()) {
                // return item stock to inventory if order is not complete.
                int itemStockIndex = 0;
                for (Item item : orderManager.getItemsInOrder(orderManager.findOrderIndex(ordersArg))) {
                    int itemCurrentStock = item.getItemStock();
                    int itemsStockInOrder = orderManager.getOrder(orderManager.findOrderIndex(ordersArg))
                            .getStockCounts().get(itemStockIndex);
                    int itemUpdateStock = itemCurrentStock + itemsStockInOrder;
                    item.setItemStock(itemUpdateStock);
                    ++itemStockIndex;
                }
                ui.showOrderDeleted(orderManager.changeOrderFormat(ordersArg));
                orderManager.deleteOrderByname(ordersArg);
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

