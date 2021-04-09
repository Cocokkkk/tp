package seedu.easylog.common;

import java.util.Scanner;

public class Constants {
    public static final int ARRAY_OFFSET = 1;
    public static final int PRICING_SCALE = 2;
    public static final int MINIMUM_ITEM_PRICE = 0;
    public static final int MAXIMUM_ITEM_PRICE = 1000000000;
    public static final int MINIMUM_ITEM_STOCK = 1;
    public static final int MAXIMUM_ITEM_STOCK = 1000000000;
    public static final Scanner SCANNER = new Scanner(System.in);

    // Commands constants
    public static final String COMMAND_HELP = "help";
    public static final String COMMAND_EXIT = "exit";
    public static final String COMMAND_ITEMS = "items";
    public static final String COMMAND_ORDERS = "orders";
    public static final String COMMAND_ADD = "add";
    public static final String COMMAND_DELETE = "delete";
    public static final String COMMAND_LIST = "list";
    public static final String COMMAND_CLEAR = "clear";
    public static final String COMMAND_UPDATE = "update";
    public static final String COMMAND_PRICE = "price";
    public static final String COMMAND_DONE = "done";
    public static final String COMMAND_FIND = "find";
    public static final String COMMAND_STATISTICS = "stats";

    public static final String COMMAND_RECEIPT_COUNTER = "ReceiptCounter";
    public static final String ITEM_NAME_AND_PRICE_SEPARATOR = ", S$";
    public static final String ITEM_PRICE_AND_STOCK_SEPARATOR = ", ";
    public static final String TOTAL_PRICE_FORMAT = "Total Price : S$";
    public static final String GIVE_UP_DELETE_SIGNAL = "quit";
    public static final int ITEM_NAME_LENGTH_LIMIT = 30;
    public static final int CUSTOMER_NAME_LENGTH_LIMIT = 30;
}
