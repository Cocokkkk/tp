package seedu.easylog.commands.itemscommands;

import seedu.easylog.common.Constants;

import seedu.easylog.exceptions.EmptyItemNameException;
import seedu.easylog.exceptions.EmptyItemStockException;
import seedu.easylog.exceptions.InvalidItemStockException;
import seedu.easylog.exceptions.InvalidTotalItemStockException;
import seedu.easylog.exceptions.NonIntegerItemStockException;
import seedu.easylog.exceptions.NonNumericItemPriceException;
import seedu.easylog.exceptions.NullItemNameException;
import seedu.easylog.exceptions.NullItemStockException;
import seedu.easylog.exceptions.ItemNameTooLongException;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;

import java.util.ArrayList;

public class ItemsAddCommand extends ItemsCommand {

    /**
     * Adds items to the system.
     *
     * @param itemDescription       description of an item
     * @param itemManager           item manager
     * @param itemDescriptionRecord ArrayList of item descriptions
     */
    public void execute(String itemDescription, ItemManager itemManager, ArrayList<String> itemDescriptionRecord)
            throws EmptyItemNameException, NonIntegerItemStockException, NonNumericItemPriceException,
            InvalidTotalItemStockException, NullItemNameException, NullItemStockException, EmptyItemStockException,
            InvalidItemStockException, ItemNameTooLongException {
        if (itemDescription == null) {
            throw new NullItemNameException();
        }

        if (itemDescription.equals("")) {
            throw new EmptyItemNameException();
        }

        if (itemDescription.length() > Constants.ITEM_NAME_LENGTH_LIMIT) {
            throw new ItemNameTooLongException();
        }

        if (itemDescriptionRecord.contains(itemDescription)) {
            handleAnItemWhichAlreadyExists(itemDescriptionRecord, itemDescription, itemManager);
            return;
        }

        Item item = itemsParser.promptAndProcessItemPriceAndStock(itemDescription);
        itemManager.addItem(item);

        assert itemManager.getLatestItemAdded().equals(item);
        ui.showAddItem(item);
    }

    /**
     * Handles an item which already exists. That is,
     * the user will be prompted to enter the additional stock to be increment
     * the total number of stock.
     *
     * @param itemDescriptionRecord the arrayList of all item descriptions in the system
     * @param itemDescription       the description of an item
     * @param itemManager           item manager
     */
    private void handleAnItemWhichAlreadyExists(ArrayList<String> itemDescriptionRecord, String itemDescription,
                                                ItemManager itemManager) throws InvalidItemStockException,
            NullItemStockException, NonIntegerItemStockException, EmptyItemStockException,
            InvalidTotalItemStockException {
        ui.showItemIsAlreadyExisting();

        boolean itemAlreadyExists = true;
        ItemsPromptStockCommand itemsPromptStockCommand = new ItemsPromptStockCommand();
        int itemStock = itemsPromptStockCommand.execute(itemAlreadyExists);

        int itemIndex = itemDescriptionRecord.indexOf(itemDescription);
        Item itemWhichAlreadyExists = itemManager.getItem(itemIndex);

        int revisedStock = itemStock + itemManager.getItemStock(itemWhichAlreadyExists);
        if (revisedStock > Constants.MAXIMUM_ITEM_STOCK) {
            throw new InvalidTotalItemStockException();
        }
        itemManager.setRevisedItemStock(itemIndex, revisedStock);
        ui.showUpdateItemStock(itemManager.getItem(itemIndex));
    }
}
