/*
* Student Name: Jordan Tache-Smith(041-114-885)
* Lab Professor: Howard Rosenblum
* Due Date: 2024-02-11
* Description: InventoryManager class for Assignment 1
*/
package inventorymanager;

//SECONDARY METHODS FOR GROCERYSTORE CLASS METHODS
public class InventoryManager {
	
//START findItemIndex
public static int findItemIndex(String[][] inventory, String itemName) {
	for(int i = 0; i < inventory.length; i++) {
		if (inventory[i][0].equalsIgnoreCase(itemName)){
			return i;
		}
	}
return -1; //IF ITEM WASNT FOUND
}
//END findItemIndex

//START updateInventory
public static void updateInventory(String[][] inventory, int itemIndex, int quantity) {
if (itemIndex >= 0 && itemIndex < inventory.length) {
	int currentQuantity = Integer.parseInt(inventory[itemIndex][1]);
	int newQuantity = currentQuantity + quantity;
	if (newQuantity >= 0) {
		inventory[itemIndex][1] = String.valueOf(newQuantity);

}
}
}
//END updateInventory 
}

