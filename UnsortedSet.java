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
	// TODO Note: I removed the internal size tracker because myCon has a size

	public UnsortedSet() {
		myCon = new ArrayList<>();
	}

	/*
	 * Makes a deep copy of otherSet
	 * 
	 * Efficiency: O(N)
	 * 
	 * TODO add pre and post con
	 */
	private UnsortedSet(ISet<E> otherSet) {
		// TODO check precon
		myCon = new ArrayList<>();
		for (E val : otherSet) {
			myCon.add(val);
		}
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
	public boolean add(E item) {
		if (item == null) {
			throw new IllegalArgumentException("Item cannot be null.");
		}
		if (contains(item)) {
			return false;
		}
		myCon.add(item);
		// TODO Note: I removed the internal size tracker because myCon has a size
		return true;
	}

	@Override
	/**
	 * Remove the specified item from this set if it is present.
	 * 
	 * Efficiency O(N)
	 * 
	 * pre: item != null
	 * @param item the item to remove from the set. item may not equal null.
	 * @return true if this set changed as a result of this operation,
	 *         false otherwise
	 */
	public boolean remove(E item) {
		if (item == null) {
			throw new IllegalArgumentException("Item cannot be null.");
		}
		// TODO Note: I condensed this code
		return myCon.remove(item);
	}

	@Override
	/**
	 * Return the number of elements of this set.
	 * 
	 * Efficiency O(1)
	 * 
	 * pre: none
	 * @return the number of items in this set
	 */
	public int size() {
		return myCon.size();
	}

    /**
     * Return an Iterator object for the elements of this set.
	 * 
	 * Efficiency: O(1)
	 * 
     * pre: none
     * @return an Iterator object for the elements of this set
     */
    public Iterator<E> iterator(){
		return myCon.iterator();
	}
    
	@Override
	/**
	 * Create a new set that is the difference of this set and otherSet.
	 * Return an ISet of elements that are in this Set but not in otherSet.
	 * Also called the relative complement.
	 * <br>
	 * Example: If ISet A contains [X, Y, Z] and ISet B contains [W, Z]
	 * then A.difference(B) would return an ISet with elements [X, Y] while
	 * B.difference(A) would return an ISet with elements [W].
	 * <br>
	 * pre: otherSet != null
	 * <br>
	 * post: returns a set that is the difference of this set and otherSet.
	 * Neither this set or otherSet are altered as a result of this operation.
	 * <br>
	 * pre: otherSet != null
	 * 
	 * Efficiency:
	 * O(N^2) if otherSet is unsorted
	 * O(Nlog(N)) if otherSet is sorted
	 * 
	 * @param otherSet != null
	 * @return a set that is the difference of this set and otherSet
	 */
	public ISet<E> difference(ISet<E> otherSet) {
		UnsortedSet<E> returnSet = new UnsortedSet<>();
		for (E val : this) {
			if(!otherSet.contains(val)){
				returnSet.myCon.add(val);
			}
		}
		return returnSet;
	}

	/**
	 * create a new set that is the intersection of this set and otherSet.
	 * <br>
	 * pre: otherSet != null<br>
	 * <br>
	 * post: returns a set that is the intersection of this set
	 * and otherSet.
	 * Neither this set or otherSet are altered as a result of this operation.
	 * <br>
	 * pre: otherSet != null
	 * 
	 * Efficiency:
	 * O(N^2) if otherSet is unsorted
	 * O(Nlog(N)) if otherSet is sorted
	 * 
	 * @param otherSet != null
	 * @return a set that is the intersection of this set and otherSet
	 */
	public ISet<E> intersection(ISet<E> otherSet) {
		UnsortedSet<E> returnSet = new UnsortedSet<>();
		for (E val : this) {
			// otherSet might be sorted. this set definitely is not. Therefore, the
			// potentially better contains method shall be used
			if (otherSet.contains(val)) {
				returnSet.myCon.add(val);
			}
		}
		return returnSet;
	}

	/**
	 * Create a new set that is the union of this set and otherSet.
	 * <br>
	 * pre: otherSet != null
	 * <br>
	 * post: returns a set that is the union of this set and otherSet.
	 * Neither this set or otherSet are altered as a result of this operation.
	 * <br>
	 * pre: otherSet != null
	 * 
	 * Efficiency:
	 * O(N^2) if otherSet is unsorted
	 * O(Nlog(N)) if otherSet is sorted
	 * 
	 * @param otherSet != null
	 * @return a set that is the union of this set and otherSet
	 */
	public ISet<E> union(ISet<E> otherSet) {
		UnsortedSet<E> returnSet = new UnsortedSet<>(otherSet);
		for (E val : this) {
			// Uses myCon.add instead of built in add because myCon is O(1), while the built
			// in method is O(N)
			if (!otherSet.contains(val)) {
				returnSet.myCon.add(val);
			}
		}
		return returnSet;
	}
}
