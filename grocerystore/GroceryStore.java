/*
* Student Name: Jordan Tache-Smith(041-114-885)
* Lab Professor: Howard Rosenblum
* Due Date: 2024-02-11
* Description: GroceryStore class for Assignment 1
*/
package grocerystore;
import java.util.Scanner;
import inventorymanager.InventoryManager;
import inventoryexception.InventoryException;

//PRIMARY UTILITY CLASS
public class GroceryStore {
private String[][] inventory;

Scanner scanner = new Scanner(System.in);

//CONSTRUCTOR
public GroceryStore() {
	inventory = new String[][] {
		  {"Broccoli", "14"},
          {"Sausages", "35"},
          {"Bread", "20"},
          {"Tortilla", "40"},
          {"Eggs", "48"}
	};
}

//START displayInventory
public void displayInventory() {
	for(String[] item : inventory) {
System.out.println(item[0] + ": " + item[1]);
	}
}
//END displayInventory
	
//START purchaseItems
public void purchaseItems() {
	while(true) {
		System.out.println("Enter the name of the item you want to purchase (or 'exit' to quit):");
        String itemName = scanner.nextLine();
        
        if (itemName.equalsIgnoreCase("exit")) break;
        
        int itemIndex = -1;
        
        itemIndex = InventoryManager.findItemIndex(inventory, itemName);
        
        if (itemIndex == -1) {
        	System.out.println("Invalid item name. Please try again.");
        	continue;
        }
        
        System.out.println("Enter the quantity you wish to purchase:");
        int quantityToBuy = scanner.nextInt();
        scanner.nextLine();
        
        try {
        	if (quantityToBuy <= 0) {
        		throw new InventoryException("Invalid quantity. Please enter a positive value.");
        	}
        	int availableQuantity = Integer.parseInt(inventory[itemIndex][1]);
        	if (quantityToBuy > availableQuantity) {
        		throw new InventoryException("Not enough stock available. Please choose a smaller quantity.");
        	}
        	
        	int newQuantity = availableQuantity - quantityToBuy;
        	inventory[itemIndex][1] = String.valueOf(newQuantity);
        	System.out.println("Purchase successful! Updated Inventory:");
        	displayInventory();
        	
        	} catch (InventoryException e) {
        		System.out.println(e.getMessage());
        }
      }
	}
//END purchaseItems

//START restockItem
    public void restockItems() {
    	while(true) {
        try {
            System.out.println("Enter item name to restock or 'exit' to exit:");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("exit")) break;

            int itemIndex = -1;

          itemIndex = InventoryManager.findItemIndex(inventory, itemName);
          
            if (itemIndex == -1) {
                System.out.println("Invalid item name. Please try again.");
                continue;
            }
            
            System.out.println("Enter the quantity to restock:");
            int quantityToRestock = scanner.nextInt();
            scanner.nextLine();
            
            if (quantityToRestock <= 0) {
                throw new InventoryException("Invalid quantity. Please enter a positive number.");
            }
       
            InventoryManager.updateInventory(inventory, itemIndex, quantityToRestock);
            System.out.println("Restock successful! Updated Inventory: ");
            displayInventory();
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        }
    }
    }
//END restockItems

//START manageInventory
public void manageInventory() {
	String choice;
	do {
		System.out.println("Menu:");
		System.out.println("1. Purchase items");
		System.out.println("2. Restock items");
		System.out.println("3. Exit");
		System.out.print("Choose an option:");
		choice = scanner.nextLine();
		switch(choice) {
		case "1":
			purchaseItems();
			break;
		case "2":
			restockItems();
			break;
		case "3":
			System.out.println("...exiting...bye...");
			break;
		default:
			System.out.println("Invalid entry: enter an integer between 1 and 3");
		}
	} while (!choice.equals("3"));
}		
//END manageInventory

//START operationsMenu
public void operationsMenu() {
      manageInventory();
	scanner.close();
}
//END operationsMenu

}

