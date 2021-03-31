package seedu.easylog.model;

import seedu.easylog.common.Constants;
import seedu.easylog.common.Messages;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Manage order list manipulation commands.
 */
public class OrderManager {

    protected ArrayList<Order> orderList;

    private static final ArrayList<Order> FOUND_LIST = new ArrayList<>();

    public OrderManager() {
        this.orderList = new ArrayList<>();
    }

    /**
     * Adds an order to the order list.
     *
     * @param order name of order to be added
     */
    public void addOrder(Order order) {
        orderList.add(order);
    }

    /**
     * Deletes an order from this list of orders.
     *
     * @param index the number of the order to be deleted.
     */
    public void deleteOrder(int index) {
        orderList.remove(index);
    }

    /**
     * Deletes an order from item list by name.
     *
     * @param name the name of the customer's order to be deleted
     */
    public void deleteOrderByname(String name) {
        for (int i = 0; i < orderList.size(); i++) {
            if (name.equals(orderList.get(i).customerName)) {
                orderList.remove(i);
                break;
            }
        }
    }

    /**
     * Changes relevant string to order type.
     *
     * @param name the name of string to be changed
     * @return string in order type if in the order list, null otherwise
     */
    public Order changeOrderFormat(String name) {
        for (int i = 0; i < orderList.size(); i++) {
            if (name.equals(orderList.get(i).customerName)) {
                return orderList.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the item list under a specific order.
     *
     * @param index the number of this order
     * @return a item list
     */
    public Order getOrder(int index) {
        return orderList.get(index);
    }

    /**
     * Gets the number of orders in the system.
     *
     * @return the size of order list
     */
    public int getSize() {
        return orderList.size();
    }

    /**
     * Gets the list of orders.
     *
     * @return the list of orders
     */
    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    /**
     * Gets the customer's name specified by the index
     * of the order given.
     *
     * @param index index of the order given
     * @return customer's name specified by the index of the order given
     */
    public String getCustomerName(int index) {
        return getOrder(index).getCustomerName();
    }

    /**
     * Gets the customer's items specified by the index
     * of the order given.
     *
     * @param index index of the order given
     * @return customer's items specified by the index of the order given
     */
    public ArrayList<Item> getItemsInOrder(int index) {
        return getOrder(index).getItemsInOrder();
    }

    /**
     * Gets the stocks of customer's items specified by the index
     * of the order given.
     *
     * @param index index of the order given
     * @return the stocks of customer's items specified by the index of the order given
     */
    public ArrayList<Integer> getItemsStockInOrder(int index) {
        return getOrder(index).getStockCounts();
    }

    /**
     * Clears all orders in the system.
     */
    public void clearOrderList() {
        orderList.clear();
    }

    /**
     * Get latest order added to the order list.
     *
     * @return Latest order added to the order list.
     */
    public Order getLatestOrderAdded() {
        int index = getSize() - Constants.ARRAY_OFFSET;
        return getOrder(index);
    }


    /**
     * Prints the order for each order name.
     *
     * @param order the order to be printed
     * @return the print out order of the selected order
     */
    public String getIndividualOrderPrintFormat(Order order) {
        String customerName = order.getCustomerName();
        String customersItemList = "";
        int itemAndStockIndex = 0;
        for (Item item : order.getItemsInOrder()) {
            customersItemList += Messages.MESSAGE_INDENTATION + (itemAndStockIndex + 1) + ". "
                    + item.getItemName() + Constants.ITEM_NAME_AND_PRICE_SEPARATOR
                    + item.getItemPrice() + Constants.ITEM_PRICE_AND_STOCK_SEPARATOR
                    + order.getStockCounts().get(itemAndStockIndex) + "\n";
            ++itemAndStockIndex;
        }
        BigDecimal totalPrice = order.getOrderTotalPrice(order.getItemsInOrder());
        return customerName + "\n" + customersItemList + Messages.MESSAGE_INDENTATION + Constants.TOTAL_PRICE_FORMAT
                + totalPrice + "\n" + Messages.MESSAGE_LINE;
    }

    /**
     * Gets the format of the printed order list.
     *
     * @return the formatted order list
     */
    public String getOrderListPrintFormat() {
        String rawOrderListOutput = "";
        for (Order order : orderList) {
            String individualOrderOutput = getIndividualOrderPrintFormat(order);
            rawOrderListOutput += individualOrderOutput;
        }
        return rawOrderListOutput;
    }

    /**
     * Finds relevant orders by customer's name.
     *
     * @param name name to be searched
     */
    public void findOrder(String name) {
        for (int i = 0; i < getSize(); i++) {
            if (getCustomerName(i).contains(name)) {
                FOUND_LIST.add(getOrder(i));
            }
        }
    }

    /**
     * Finds the index of the order by customer's name.
     *
     * @param name name to be searched
     * @return findIndex index of the found order
     */
    public int findOrderIndex(String name) {
        int findIndex = -1;
        for (int i = 0; i < getSize(); i++) {
            if (getCustomerName(i).contains(name)) {
                findIndex = i;
                break;
            }
        }
        return findIndex;
    }

    /**
     * Gets the list of orders in String format to be printed as output to the user.
     *
     * @return String format for the list of relevant orders to be printed
     */
    public String getFoundOrderListPrintFormat() {
        String rawFoundOrderListOutput = "";
        for (Order order : FOUND_LIST) {
            String individualOrderOutput = getIndividualOrderPrintFormat(order);
            rawFoundOrderListOutput += individualOrderOutput;
        }
        return rawFoundOrderListOutput;
    }

    /**
     * Checks if any relevant orders found.
     *
     * @return the presence of valid order in foundList
     */
    public boolean foundOrderEmpty() {
        if (FOUND_LIST.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Clears the existing orders in foundList.
     */
    public void clearFoundList() {
        FOUND_LIST.clear();
    }

    /**
     * Checks whether the input customer name exists or not.
     *
     * @param orderName customer name to be added
     * @return false if this is not a repetitive customer name
     */
    public boolean checkRepeatOrder(String orderName) {
        for (Order order : orderList) {
            if (orderName.equals(order.customerName)) {
                return true;
            }
        }
        return false;
    }
}
