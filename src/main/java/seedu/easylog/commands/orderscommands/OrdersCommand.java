package seedu.easylog.commands.orderscommands;

import seedu.easylog.item.ItemManager;
import seedu.easylog.order.OrderManager;
import seedu.easylog.ui.Ui;
import seedu.easylog.parser.OrdersParser;

public abstract class OrdersCommand {

    public Ui ui = new Ui();
    public OrdersParser ordersParser = new OrdersParser();
}
