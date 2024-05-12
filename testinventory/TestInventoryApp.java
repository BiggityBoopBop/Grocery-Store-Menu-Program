/*
* Student Name: Jordan Tache-Smith(041-114-885)
* Lab Professor: Howard Rosenblum
* Due Date: 2024-02-11
* Description: TestInventoryApp class for Assignment 1
*/
package testinventory;
import grocerystore.GroceryStore;

//MAIN CLASS TO TEST PROGRAM
public class TestInventoryApp {

	public static void main(String[] args) {

//CREATES GROCERY STORE 
GroceryStore store = new GroceryStore();

System.out.println("Initial Inventory: ");
store.displayInventory();
store.operationsMenu();
	}

}
