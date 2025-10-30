/*  Student information for assignment:
 *
 *  On <MY|OUR> honor, <NAME1> and <NAME2),
 *  this programming assignment is <MY|OUR> own work
 *  and <I|WE> have not provided this code to any other student.
 *
 *  Number of slip days used:
 *
 *  Student 1 (Student whose Canvas account is being used)
 *  UTEID:
 *  email address:
 *  TA name:
 *
 *  Student 2
 *  UTEID:
 *  email address:
 */

import java.util.Iterator;
import java.util.ArrayList;

/**
 * In this implementation of the ISet interface the elements in the Set are
 * maintained in ascending order.
 *
 * The data type for E must be a type that implements Comparable.
 *
 * Implement methods that were not implemented in AbstractSet314
 * and override methods that can be done more efficiently. An ArrayList must
 * be used as the internal storage container. For methods involving two set,
 * if that method can be done more efficiently if the other set is also a
 * SortedSet, then do so.
 */
public class SortedSet<E extends Comparable<? super E>> extends AbstractSet314<E> {

    /*
     * DELETE THIS COMMENT WHEN FINISHED.
     * RECALL: When merging two SortedSets (most likely in the union, difference,
     * intersection,
     * and addAll methods) you are required to adapt the merge code from the slides
     * on Faster sorting.
     * https://www.cs.utexas.edu/~scottm/cs314/handouts/slides/Topic17FastSorting.
     * pdf Slide number 14.
     * You must deal with the internal ArrayList and uses primitive ints to track
     * positions in the list.
     * Do not use iterators when merging. Failure to meet this requirement
     * may result in a 0 on the assignment.
     */

    private ArrayList<E> myCon;

    /**
     * create an empty SortedSet
     */
    public SortedSet() {

    }

    /**
     * Create a copy of other that is sorted.<br>
     * 
     * @param other != null
     */
    public SortedSet(ISet<E> other) {

    }

    /**
     * Return the smallest element in this SortedSet.
     * <br>
     * pre: size() != 0
     * 
     * @return the smallest element in this SortedSet.
     */
    public E min() {

        return null; // TODO MAKE this good
    }

    /**
     * Return the largest element in this SortedSet.
     * <br>
     * pre: size() != 0
     * 
     * @return the largest element in this SortedSet.
     */
    public E max() {

    }

}
