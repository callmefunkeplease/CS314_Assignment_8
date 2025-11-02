/*  Student information for assignment:
 *
 *  On our honor, Funke and <NAME2), 
 *  this programming assignment is our own work
 *  and we have not provided this code to any other student.
 *
 *  Number of slip days used: 0
 *
 *  Student 1 (Student whose Canvas account is being used)
 *  UTEID: jof369
 *  email address: jof369@eid.utexas.edu
 *  TA name:Karnika Choudhury
 *  
 *  Student 2 
 *  UTEID:
 *  email address:   
 */

import java.util.Iterator;
import java.util.ArrayList;

/**
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet314 and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */
public class UnsortedSet<E> extends AbstractSet314<E> {

    private ArrayList<E> myCon;
	private int size;

	public UnsortedSet(){
		myCon = new ArrayList<>();
	}

	@Override
    /**
     * Add an item to this set.
     * <br>
     * item != null
	 * 
	 * Efficiency O(N)
     * 
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation,
     *         false otherwise.
     */
    public boolean add(E item){
		if(item == null){
			throw new IllegalArgumentException("Item cannot be null.");
		}
		if(contains(item)){
			return false;
		}
		myCon.add(item);
		size++;
		return true;
	}

	@Override
    /**
     * Remove the specified item from this set if it is present.
     * pre: item != null
	 * Efficiency O(N)
     * 
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation,
     *         false otherwise
     */
    public boolean remove(E item){
		if(item == null){
			throw new IllegalArgumentException("Item cannot be null.");
		}
		boolean removed = myCon.remove(item);
		if(removed){
			size--;
		}
		return removed;
	}

	@Override
	/**
     * Return the number of elements of this set.
     * pre: none
     * 
     * Efficiency O(1)
     * 
     * @return the number of items in this set
     */
    public int size() {
        return size;
    }

	@Override
	public ISet<E> union(ISet<E> otherSet) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'union'");
	}

}
