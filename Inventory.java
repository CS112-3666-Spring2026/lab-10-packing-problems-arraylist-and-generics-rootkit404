import java.util.List;
import java.util.NoSuchElementException;

public class Inventory<T extends Supplies> {

	/*     STEP 3 
	*        
	*      Create this bounded type generic class with everything you 
	*      would expect in a class (instance variable, constructor,
	*      get/set methods) and then make two additional generic methods:
	*
	*      Go to Transfer.java for STEP 4
	*/

	// INSTANCE VARIABLES
	private T genericVariable;

	// Default Constructor
	public Inventory() {

	}

	// Full Constructor
	public Inventory(T genericVariable) {
		this.genericVariable = genericVariable;
	}

	// SETTER & GETTER

	public void setObject(T genericVariable) {
		this.genericVariable = genericVariable;
	}

	public T getObject() {
		return this.genericVariable;
	}

	/*     STEP 5
	*
	*      Create a method called searchByName() that takes two parameters:
	*          - The input List<T> of generic type T
	*          - A String "name" that we will use to search in the input List
	*
	*      This method should iterate through all the objects in our List
	*      and use the getName() method of Supplies to compare against the
	*      input String "name", use the indexOf() method to return the 
	*      index. If no match is found, return -1. 
	*/
	public int searchByName(List<T> inputList, String name) throws NoSuchElementException {
		name = name.trim();

		for (T element : inputList) 
		{
			if (element.getName().equalsIgnoreCase(name)) {
				return inputList.indexOf(element);
			} else {
				throw new NoSuchElementException("Sorry! Item \"" + name + "\" not found!");
			}
		}

		// System.out.println("Sorry! Item \"" + name + "\" not found!");

		return -1;
	}


	/*     STEP 7:
	* 
	*      Create a method called checkQty() that takes three parameters:
	*           - The input List<T>
	*           - The String name of the object we want to check
	*           - The int desiredQuantity that we want to check/change for 
	*             the item
	*           
	*      Use our method searchByName() to be able to get the index of 
	*      the object we are looking for and use the index to access the 
	*      object within the List<T>. If the object is not found, or if
	*      our searchByName() method returns -1, return null.
	*
	*      Once our object is found, check the quantity via the .get() 
	*      method from the List class and by using the .getQuantity()
	*      from the Supplies class. Compare the value with the parameter 
	*      desiredQuantity, if they match then return the object as-is
	*      and notify user that the quantity matches. If it does not 
	*      match the quantity in the list, then update using .setQuantity
	*      and return the object with the new quantity.
	*/
	public T checkQty(List<T> inputList, String name, int desiredQty) throws NoSuchElementException {
		int indexOfItem = searchByName(inputList, name);

		if (indexOfItem == -1) 
		{
			throw new NoSuchElementException("Sorry! Item \"" + name + "\" not found!");
		}

		if (inputList.get(indexOfItem).getQuantity() != desiredQty) 
		{
			inputList.get(indexOfItem).setQuantity(desiredQty);
			return inputList.get(indexOfItem);
		} else {
			return inputList.get(indexOfItem);
		}
	}

}