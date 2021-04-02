package seedu.easylog.parser;

import seedu.easylog.commands.orderscommands.OrdersAddCommand;
import seedu.easylog.commands.orderscommands.OrdersClearCommand;
import seedu.easylog.commands.orderscommands.OrdersDeleteCommand;
import seedu.easylog.commands.orderscommands.OrdersListCommand;
import seedu.easylog.commands.orderscommands.OrdersPriceCommand;
import seedu.easylog.commands.orderscommands.OrdersDoneCommand;
import seedu.easylog.commands.orderscommands.OrdersFindCommand;
import seedu.easylog.common.Constants;

import seedu.easylog.exceptions.EmptyNameException;
import seedu.easylog.exceptions.EmptyItemListException;
import seedu.easylog.exceptions.EmptyInformationException;
import seedu.easylog.exceptions.InvalidItemStockException;
import seedu.easylog.exceptions.EmptyNumberException;
import seedu.easylog.exceptions.InvalidNumberException;
import seedu.easylog.exceptions.OrderListAlreadyClearedException;
import seedu.easylog.exceptions.OrderNotFoundException;


import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;

import java.util.ArrayList;

/**
 * Process orders commands input.
 */
public class OrdersParser extends Parser {

    public static void processOrdersInput(String ordersInput, ItemManager itemManager, OrderManager orderManager) {
        String[] splitOrdersArg = splitCommandWordAndArgs(ordersInput);
        String ordersType = splitOrdersArg[0];
        String ordersArg = splitOrdersArg[1];
        switch (ordersType) {
        case (Constants.COMMAND_ADD):
            try {
                new OrdersAddCommand().execute(ordersArg, itemManager, orderManager);
            } catch (EmptyNameException e) {
                ui.showOrderEmptyCustomerName();
            } catch (EmptyItemListException e) {
                ui.showEmptyItemList();
            }
            break;
        case (Constants.COMMAND_DELETE):
            try {
                new OrdersDeleteCommand().execute(ordersArg, orderManager);
            } catch (EmptyInformationException e) {
                ui.showOrderEmptyInformation();
            } catch (InvalidNumberException e) {
                ui.showInvalidOrderNumber();
            } catch (NumberFormatException e) {
                ui.showNonIntegerOrderNumber();
            } catch (OrderNotFoundException e) {
                ui.showOrderNotFound();
            }
            break;
        case (Constants.COMMAND_LIST):
            new OrdersListCommand().execute(orderManager);
            break;
        case (Constants.COMMAND_CLEAR):
            try {
                new OrdersClearCommand().execute(orderManager);
            } catch (OrderListAlreadyClearedException e) {
                ui.showAlreadyClearedOrderList();
            }
            break;
        case (Constants.COMMAND_PRICE):
            try {
                new OrdersPriceCommand().execute(ordersArg, orderManager);
            } catch (EmptyNumberException e) {
                ui.showOrderEmptyNumber();
            } catch (InvalidNumberException e) {
                ui.showInvalidOrderNumber();
            } catch (NumberFormatException e) {
                ui.showNonIntegerOrderNumber();
            }
            break;
        case (Constants.COMMAND_DONE):
            try {
                new OrdersDoneCommand().execute(ordersArg, orderManager);
            } catch (EmptyNumberException e) {
                ui.showOrderEmptyNumber();
            } catch (InvalidNumberException e) {
                ui.showInvalidOrderNumber();
            } catch (NumberFormatException e) {
                ui.showNonIntegerOrderNumber();
            }
            break;
        case (Constants.COMMAND_FIND):
            try {
                new OrdersFindCommand().execute(ordersArg, orderManager);
            } catch (EmptyNameException e) {
                ui.showOrderEmptyCustomerName();
            } catch (OrderNotFoundException e) {
                ui.showOrderNotFound();
            }
            break;
        default:
            ui.showOrdersHelp();
        }
    }

    /**
     * Processes the items added to the order.
     *
     * @param customerName         the name of order
     * @param addItemsToOrderInput the item added to the order
     * @param itemManager          item manager
     * @return the items added to order
     */
    public Order processItemsAddedToOrder(String customerName, String addItemsToOrderInput, ItemManager itemManager) {
        ArrayList<Item> itemsAddedToOrder = new ArrayList<>();
        ArrayList<Integer> itemsStockAddedToOrder = new ArrayList<>();
        while (!addItemsToOrderInput.equals("stop") || itemsAddedToOrder.isEmpty()) {
            String[] splitInput = addItemsToOrderInput.split(" ");
            try {
                int itemIndex = Integer.parseInt(splitInput[0]) - Constants.ARRAY_OFFSET;
                int stockAdded = Integer.parseInt(splitInput[1]);
                Item itemToBeAddedToOrder = itemManager.getItem(itemIndex);
                int currentItemStock = itemToBeAddedToOrder.getItemStock();

                itemManager.incrementItemSales(itemToBeAddedToOrder, stockAdded);

                if (stockAdded < 0 || stockAdded > currentItemStock) {
                    throw new InvalidItemStockException();
                }
                int updatedItemStock = currentItemStock - stockAdded;
                itemToBeAddedToOrder.setItemStock(updatedItemStock);
                itemsAddedToOrder.add(itemManager.getItem(itemIndex));
                itemsStockAddedToOrder.add(stockAdded);
                ui.showItemAndStockAddedToOrder(itemToBeAddedToOrder.getItemName(), stockAdded);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                ui.showInvalidWhileAddingItemToOrder();
            } catch (IndexOutOfBoundsException e) {
                ui.showItemNotFoundWhenAddingToOrder(splitInput[0]);
            } catch (InvalidItemStockException e) {
                ui.showNotEnoughStock();
            }
            ui.showAddItemsToOrder();
            addItemsToOrderInput = ui.askForUserInput();
        }
        return new Order(customerName, itemsAddedToOrder, itemsStockAddedToOrder);
    }

    /**
     * Processes the items added to the order which already exists.
     *
     * @param customerName         the customer name of order
     * @param addItemsToOrderInput the item added to the order
     * @param itemManager          item manager
     * @param orderManager         order manager
     * @return the items added to the order which already exists
     */
    public Order processItemsAddedToExistingOrder(String customerName, String addItemsToOrderInput,
                                                  ItemManager itemManager, OrderManager orderManager) {
        int orderIndex;
        orderIndex = orderManager.findOrderIndex(customerName);
        ArrayList<Item> itemsAddedToExistingOrder;
        ArrayList<Integer> itemsStockAddedToExistingOrder;
        itemsAddedToExistingOrder = orderManager.getItemsInOrder(orderIndex);
        itemsStockAddedToExistingOrder = orderManager.getItemsStockInOrder(orderIndex);
        orderManager.deleteOrder(orderIndex);
        while (!addItemsToOrderInput.equals("stop") || itemsAddedToExistingOrder.isEmpty()) {
            String[] splitInput = addItemsToOrderInput.split(" ");
            try {
                int itemIndex = Integer.parseInt(splitInput[0]) - Constants.ARRAY_OFFSET;
                int stockAdded = Integer.parseInt(splitInput[1]);
                Item itemToBeAddedToOrder = itemManager.getItem(itemIndex);
                int currentItemStock = itemToBeAddedToOrder.getItemStock();

                itemManager.incrementItemSales(itemToBeAddedToOrder, stockAdded);

                if (stockAdded < 0 || stockAdded > currentItemStock) {
                    throw new InvalidItemStockException();
                }
                int updatedItemStock = currentItemStock - stockAdded;
                itemToBeAddedToOrder.setItemStock(updatedItemStock);
                itemsAddedToExistingOrder.add(itemManager.getItem(itemIndex));
                itemsStockAddedToExistingOrder.add(stockAdded);
                ui.showItemAndStockAddedToOrder(itemToBeAddedToOrder.getItemName(), stockAdded);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                ui.showInvalidWhileAddingItemToOrder();
            } catch (IndexOutOfBoundsException e) {

                ui.showItemNotFoundWhenAddingToOrder(splitInput[0]);
            } catch (InvalidItemStockException e) {
                ui.showNotEnoughStock();
            }
            ui.showAddItemsToOrder();
            addItemsToOrderInput = ui.askForUserInput();
        }
        return new Order(customerName, itemsAddedToExistingOrder, itemsStockAddedToExistingOrder);
    }
}
