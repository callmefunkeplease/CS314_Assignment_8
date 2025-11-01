/*  Student information for assignment:
 *
 *  On our honor, Funke and Pranav), 
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
 *  UTEID: psp782
 *  email address: psp782@my.utexas.edu
 */

import java.util.Iterator;

import javax.print.attribute.standard.MediaSize.Other;

/**
 * Students are to complete this class.
 * Students should implement as many methods
 * as they can using the Iterator from the iterator
 * method and the other methods.
 *
 */
public abstract class AbstractSet314<E> implements ISet<E> {

    /*
     * DELETE THIS COMMENT FROM YOUR SUBMISSION.
     * 
     * RECALL:
     * 
     * NO INSTANCE VARIABLES ALLOWED.
     * 
     * NO DIRECT REFERENCE TO UnsortedSet OR SortedSet ALLOWED.
     * (In other words the data types UnsortedSet and SortedSet
     * will not appear any where in this class.)
     * 
     * NO DIRECT REFERENCES to ArrayList or other Java Collections.
     * 
     * NO METHODS ADDED other than those in ISet and Object.
     */

    /**
     * Return a String version of this set.
     * Format is (e1, e2, ... en)
     * 
     * @return A String version of this set.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0) {
            result.setLength(result.length() - seperator.length());
        }

        result.append(")");
        return result.toString();
    }

    /**
     * Add an item to this set.
     * <br>
     * item != null
     * 
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation,
     *         false otherwise.
     */
    public abstract boolean add(E item);

    /**
     * A union operation. Add all items of otherSet that
     * are not already present in this set to this set.
     * 
     * Effeciency O(N^2)
     * 
     * @param otherSet != null
     * @return true if this set changed as a result of this operation,
     *         false otherwise.
     */
    public boolean addAll(ISet<E> otherSet){
        // TODO Add precondition checks
        int originalSize=size();
        for(E val:otherSet){
            add(val);
        }
        return originalSize==size();
    }

    /**
     * Make this set empty.
     * <br>
     * pre: none
     * <br>
     * post: size() = 0
     */
    public void clear() {
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    /**
     * Determine if item is in this set.
     * <br>
     * pre: item != null
     * 
     * Efficiency:O(N)
     * 
     * @param item element whose presence is being tested.
     *             Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    public boolean contains(E item) {
        // TODO Add precondition checks
        for (E val : this) {
            if (val.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * TODO Hey Pranav, double check this method specifically to make sure that the
     * TODO logic holds for when this contains everything other has to offer and not
     * TODO the opposite case. I'm 95% sure that I did it right, but this is the
     * TODO most likely to have a dumb logic error out of everything so far.
     * 
     * Determine if all of the elements of otherSet are in this set.
     * <br>
     * pre: otherSet != null
     * 
     * Efficiency:
     * O(N^2) if otherSet is an unsorted Set 
     * O(Nlog(N)) if otherSet is a sorted Set
     * 
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet,
     *         false otherwise.
     */
    public boolean containsAll(ISet<E> otherSet) {
        // TODO Add precondition checks
        for (E otherVal : otherSet) {
            if (!contains(otherVal)) {
                return false;
            }
        }
        return true;
    }

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
     * Efficiency: O(N^2)
     * 
     * @param otherSet != null
     * @return a set that is the difference of this set and otherSet
     */
    public ISet<E> difference(ISet<E> otherSet) {
        // TODO Add precondition checks
        ISet<E> returnSet = union(otherSet);
        // We want everything otherSet doesn't have
        for (E unwantedVal : otherSet) {
            returnSet.remove(unwantedVal);
        }
        return returnSet;
    }

    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>
     * pre: none
     * 
     * @param other the object to compare to this set
     * @return true if other is a Set and has the same elements as this set
     */
    public boolean equals(Object other){
        if(other==null||other.getClass()!=)
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
     * @param otherSet != null
     * @return a set that is the intersection of this set and otherSet
     */
    public ISet<E> intersection(ISet<E> otherSet){
        ISet<E> returnSet=union(otherSet);
        for(E val:returnSet){
            if(!(contains(val)&&otherSet.contains(val))){
                returnSet.remove(val);
            }
        }
        return returnSet;
    }

    /**
     * Return an Iterator object for the elements of this set.
     * pre: none
     * 
     * @return an Iterator object for the elements of this set
     */
    public Iterator<E> iterator();

    /**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * 
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation,
     *         false otherwise
     */
    public boolean remove(E item);

    /**
     * Return the number of elements of this set.
     * pre: none
     * 
     * @return the number of items in this set
     */
    public int size();

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
     * @param otherSet != null
     * @return a set that is the union of this set and otherSet
     * 
     * Note: Union is used in both difference and intersection. If we were to declare it abstractly, it would allow the client to not declare their own version of it, resulting in an infinite loop. 
     */
    public abstract ISet<E> union(ISet<E> otherSet);
}
