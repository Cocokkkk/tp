package seedu.easylog.common;

public class Messages {

    public static final String MESSAGE_LOGO = "                       _                 \n"
            + "                      | |                \n"
            + "   ___  __ _ ___ _   _| |     ___   __ _ \n"
            + "  / _ \\/ _` / __| | | | |    / _ \\ / _` |\n"
            + " |  __/ (_| \\__ \\ |_| | |___| (_) | (_| |\n"
            + "  \\___|\\__,_|___/\\__, |______\\___/ \\__, |\n"
            + "                  __/ |             __/ |\n"
            + "                 |___/             |___/ \n";
    public static final String MESSAGE_LINE = "____________________________________________________________\n";
    public static final String MESSAGE_LIST_ITEMS = MESSAGE_LINE
            + "Here is the list of items.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_FOUNDLIST_ITEMS = MESSAGE_LINE
            + "Here is the list of relevant items found.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_LIST_ORDERS = MESSAGE_LINE
            + "Here is the list of orders.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_FOUND_LIST_ORDERS = MESSAGE_LINE
            + "Here is the list of relevant orders found.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ADD_ITEMS_TO_ORDER = "Input the item to be added to this order.\n"
            + "Input format: <item_index> <item_quantity>\n"
            + "Type <stop> to stop adding items to order,"
            + " else continue entering items in the same format.\n"
            + "Do note that you need at least 1 item in the order for <stop> to work.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_ALL_COMMANDS = MESSAGE_LINE
            + "General Options:\n"
            + "  1. items                          Show items-related commands\n"
            + "  2. items add <item_name>          Add an item\n"
            + "  3. items list                     List all items\n"
            + "  4.1 items delete <item_index>     Delete an item\n"
            + "  4.2 items delete <item_name>      Delete an item\n"
            + "  5. items clear                    Empty all items\n"
            + "  6. items find <item_name>         Find an item\n"
            + "  7. items update                   Update the detail of an item\n"
            + "  8. items stats                    Discover the most popular item(s)\n"
            + "  9. orders                         Show orders-related commands\n"
            + "  10. orders add <order_name>       Add an order\n"
            + "  11. orders list                   List all orders\n"
            + "  12.1 orders delete <order_index>  Delete an order\n"
            + "  12.2 orders delete <order_name>   Delete an order\n"
            + "  13. orders clear                  Empty all orders\n"
            + "  14. orders price <order_index>    Check the total price of an order\n"
            + "  15. orders done <order_index>     Update the status of an order\n"
            + "  16. orders find <order_name>      Find an order\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_GREETING = MESSAGE_LOGO
            + MESSAGE_LINE
            + "Hello! I'm easyLog!\n"
            + "What can I do for you? Enter help to view commands.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_GOODBYE = MESSAGE_LINE
            + "Bye. Thanks for using easyLog!\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_COMMAND = MESSAGE_LINE
            + "OOPS!!! I'm sorry! I don't know what that means.\n"
            + "Please input again! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_NAME = MESSAGE_LINE
            + "OOPS!!! The item name is missing!\n"
            + "Please complete the item information! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ORDER_CUSTOMER_NAME = MESSAGE_LINE
            + "OOPS!!! The customer name is missing!\n"
            + "Please complete the order information! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ORDER_NUMBER = MESSAGE_LINE
            + "OOPS!!! The order number is missing!\n"
            + "Please complete the order information! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ORDER_INFORMATION = MESSAGE_LINE
            + "OOPS!!! The order information is missing!\n"
            + "Please complete the order index or customer name! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_ITEM_NUMBER = MESSAGE_LINE
            + "OOPS!!! The item number is invalid!\n"
            + "Please input the item information again! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_ORDER_NUMBER = MESSAGE_LINE
            + "OOPS!!! The order number is invalid!\n"
            + "Please input the order information again! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_NUMBER = MESSAGE_LINE
            + "OOPS!!! The item number is missing!\n"
            + "Please complete the item information! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_ORDERS_RELATED_COMMANDS = MESSAGE_LINE
            + "Orders-Related Options:\n"
            + "  1. orders add <order_name>        Add an order\n"
            + "  2. orders list                    List all orders\n"
            + "  3. orders delete <order_index>    Delete an order\n"
            + "  4. orders clear                   Empty all orders\n"
            + "  5. orders price <order_index>     Check the total price of an order\n"
            + "  6. orders done <order_index>      Update the status of an order\n"
            + "  7. orders find <order_name>       Find an order\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_ITEMS_COMMANDS = MESSAGE_LINE
            + "Items-Related Options:\n"
            + "  1. items add <item_name>          Add an item\n"
            + "  2. items list                     List all items\n"
            + "  3.1 items delete <item_index>     Delete an item\n"
            + "  3.2 items delete <item_name>      Delete an item\n"
            + "  4. items clear                    Empty all items\n"
            + "  5. items find <item_name>         Find an item\n"
            + "  6. items update                   Update the detail of an item\n"
            + "  7. items stats                    Discover the most popular item(s)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ALREADY_CLEARED_ITEM_LIST = MESSAGE_LINE
            + "OOPS!!! There is no single item which can be cleared right now!\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ALREADY_CLEARED_ORDER_LIST = MESSAGE_LINE
            + "OOPS!!! There is no single order which can be cleared right now!\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_CLEAR_ITEM_LIST = MESSAGE_LINE
            + "Done! I just cleared all items for you.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_CLEAR_ORDER_LIST = MESSAGE_LINE
            + "Done! I just cleared all orders for you.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_LIST = MESSAGE_LINE
            + "There is no item in the system at the moment.\n"
            + "Please add items to the system first.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ORDER_LIST = MESSAGE_LINE
            + "There is no order at the moment.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ADD_ITEM_FIRST = MESSAGE_LINE
            + "Please add items to the system first.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INDENTATION = "    ";
    public static final String MESSAGE_NON_INTEGER_ORDER_NUMBER = MESSAGE_LINE
            + "OOPS!!! The input order information "
            + "is not an integer number!\n"
            + "Please input the order information again! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NON_INTEGER_ITEM_NUMBER = MESSAGE_LINE
            + "OOPS!!! The input item information "
            + "is not an integer number!\n"
            + "Please input the item information again! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_PROMPT_ITEM_PRICE = MESSAGE_LINE
            + "Please enter the price of the item.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_INVALID_ITEM_PRICE = MESSAGE_LINE
            + "OOPS!!! The item price is invalid!\n"
            + "Note: The price to be entered should be either 0 or a positive number "
            + "smaller than or equal to S$1000000000.\n"
            + "Also, The system supports a maximum scale of 2 (number of digits right after the decimal).\n"
            + "If you enter any number having a scale greater than 2, it will be automatically rounded up "
            + "to a number having an exact scale of 2.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NULL_ITEM_PRICE = MESSAGE_LINE
            + "OOPS!!! The input item price is null!\n"
            + "Please input again and complete the item price! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_PRICE = MESSAGE_LINE
            + "OOPS!!! The input item price is empty!\n"
            + "Please input again and complete the item price! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NON_NUMERIC_INPUT_FOR_ADD = MESSAGE_LINE
            + "OOPS!!! The input for stock/price is not a number!\n"
            + "Please retry items add command and give a number for stock/price! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NON_NUMERIC_INPUT_FOR_UPDATE = MESSAGE_LINE
            + "OOPS!!! The input item is not a number!\n"
            + "Please retry items update command and give a number for stock/price! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_PROMPT_ITEM_STOCK = MESSAGE_LINE
            + "Please enter the stock of the item.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_INVALID_ITEM_STOCK = MESSAGE_LINE
            + "OOPS!!! The item stock is invalid!\n"
            + "Note: The stock to be entered should be either 0 or a positive integer number "
            + "smaller than or equal to 100000000 "
            + "(The warehouse cannot store more than one hundred million items.)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_INVALID_TOTAL_ITEM_STOCK = MESSAGE_LINE
            + "OOPS!!! The total item stock is more than 1000000000!\n"
            + "Please input again and give a valid item stock! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NULL_ITEM_STOCK = MESSAGE_LINE
            + "OOPS!!! The input item stock is null!\n"
            + "Please input again and give a valid item stock! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_STOCK = MESSAGE_LINE
            + "OOPS!!! The input item stock is empty!\n"
            + "Please input again and complete the item stock! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_WRONG_UPDATE_COMMAND = MESSAGE_LINE
            + "OOPS!!! I'm sorry! I don't know what that means.\n"
            + "Do you mean \"items update\"? Alternatively, see \"items help\" for more information\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ASK_FOR_ITEM_INDEX = MESSAGE_LINE
            + "Below is the exhaustive list for all items.\n"
            + "May I know which item should be updated?\n"
            + "Please input the index of the item of interest only.\n";
    public static final String MESSAGE_ASK_FOR_ITEM_FIELD_TO_BE_UPDATED = MESSAGE_LINE
            + "What would you like to update, price or stock? (p/s)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ASK_FOR_REVISED_ITEM_PRICE = MESSAGE_LINE
            + "What is the revised item price?\n";
    public static final String MESSAGE_SHOW_UPDATE_ITEM_PRICE = MESSAGE_LINE
            + "Done! I just updated the item price for you.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_WRONG_ITEM_FIELD_COMMAND = MESSAGE_LINE
            + "OOPS!!! I'm sorry! I don't know what that means.\n"
            + "Please input either \"p\" for (item) price or s for (item) stock.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_ITEM_INDEX = MESSAGE_LINE
            + "OOPS!!! The item index is invalid!\n"
            + "Please input again and give a valid item index! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ITEM_INDEX = MESSAGE_LINE
            + "OOPS!!! The item index is empty!\n"
            + "Please input again and complete the item index! :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ASK_FOR_REVISED_ITEM_STOCK = MESSAGE_LINE
            + "What is the revised item stock?\n";
    public static final String MESSAGE_SHOW_UPDATE_ITEM_STOCK = MESSAGE_LINE
            + "Done! I just updated the item stock for you.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_EMPTY_ORDER = MESSAGE_LINE
            + "No items added to the order. Please input `orders add` "
            + "command again!\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_NOT_ENOUGH_STOCK = MESSAGE_LINE
            + "Not enough stock to be added into the order.\n"
            + "Please retry and type valid stock number.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_CONTINUE_ADDING_ITEM_TO_ORDER = MESSAGE_LINE
            + "Type <stop> to stop adding items to order,"
            + " else continue entering items in the same format.\n"
            + "Note that you need at least 1 item in the order.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_WHILE_ADDING_ITEM_TO_ORDER = MESSAGE_LINE
            + "Invalid input format while adding items to order.\n"
            + "Please retry adding items to the order.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_FORMAT_ORDERS_ADD = MESSAGE_LINE
            + "Invalid format for inputting of items into order.\n"
            + "Please retry orders add command.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ITEM_NOT_FOUND = MESSAGE_LINE
            + "Sorry! No relevant item is found in the warehouse.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ORDER_NOT_FOUND = MESSAGE_LINE
            + "Sorry! No relevant order is found.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SAVE_DATA_LOADING = "Loading save data.\n";
    public static final String MESSAGE_LOOKING_FOR_SAVE_DATA = "Looking for save data.\n";
    public static final String MESSAGE_SAVE_DATA_LOADED = "Save data loaded.\n" + MESSAGE_LINE;
    public static final String MESSAGE_SAVE_DATA_CREATED = MESSAGE_LINE
            + "Save data created as there is no existing save data\n";
    public static final String MESSAGE_SAVE_DATA_SAVED = MESSAGE_LINE + "Save data saved.\n";
    public static final String MESSAGE_SAVE_DATA_NOT_FOUND = "Save data not found.\n" + MESSAGE_LINE;
    public static final String MESSAGE_INVALID_FILE_INPUT_LINE = "Invalid file input at line : ";
    public static final String MESSAGE_ERROR_WHILE_SAVING = "Error while saving. Save file may or may not be "
            + "saved correctly\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_REPEAT_ITEM = MESSAGE_LINE
            + "OOPS!! This item already exist.\n"
            + "Please use update function to make modification or use a different name.\n"
            + "Thank you!\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_REPEAT_ORDER = MESSAGE_LINE
            + "OOPS!! This order already exist.\n"
            + "Please use a different name for ordering. Thank you!\n"
            + "To update an Order, please delete the original order and recreate a new one.\n"
            + "For completed order, please delete and create a new order to proceed on.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_ITEM_IS_ALREADY_EXISTING = MESSAGE_LINE
            + "The item entered already exists in the system.\n"
            + "What is the new stock to be added?\n";
    public static final String MESSAGE_PROMPT_ADDITIONAL_ITEM_STOCK = "Please enter the additional stock of the item.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_MOST_POPULAR_ITEM = MESSAGE_LINE + "The most popular item is ";
    public static final String MESSAGE_SHOW_MOST_POPULAR_ITEMS = MESSAGE_LINE + "The most popular items are ";
    public static final String SHOW_CONSIDER_STOCK_UP_IF_MOST_POPULAR_ITEM_IS_NOT_ENOUGH = ". Please consider stocking "
            + "it up if it is not enough :)\n"
            + MESSAGE_LINE;
    public static final String SHOW_CONSIDER_STOCK_UP_IF_MOST_POPULAR_ITEMS_ARE_NOT_ENOUGH = ". Please consider "
            + "stocking them up if they are not enough :)\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_SHOW_NO_ITEMS_TIPS_CAN_BE_GIVEN = MESSAGE_LINE
            + "No item-related tips can be given.\n"
            + "As you have not sold any single item yet.\n"
            + MESSAGE_LINE;
    public static final String MESSAGE_RECEIPT_HEADER = MESSAGE_LINE + "Order details as shown below\n";
}

