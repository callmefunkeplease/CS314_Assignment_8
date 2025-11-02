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
    private static final int SIZE_WHEN_INSERTION_SORT_IS_FASTER_THAN_QUICK_SORT = 7;

    private ArrayList<E> myCon;

    /**
     * create an empty SortedSet
     * 
     * Efficiency: O(1);
     */
    public SortedSet() {
        myCon = new ArrayList<>();
    }

    /**
     * Create a copy of other that is sorted.<br>
     * 
     * Efficiency:
     * O(N) if other is secretly a SortedSet
     * O(Nlog(N)) if other isn't a SortedSet
     * 
     * @param other != null
     */
    public SortedSet(ISet<E> other) {
        myCon = new ArrayList<>();
        if (other instanceof SortedSet<E>) {
            for (E val : ((SortedSet<E>) other).myCon) {
                myCon.add(val);
            }
        } else {
            for (E val : other) {
                myCon.add(val);
            }
            if (myCon.size() > 1) {
                quickSort(0, myCon.size() - 1);
            } // else{ I'm good. The empty/single val is sorted }
        }
    }

    /*
     * Very quick helper Constructor.
     * 
     * Efficiency: O(1)
     * 
     * Pre: sortedSetList is an arrayList that follows all the rules of a SortedSet.
     * Post: Constructs a sortedSetList with the parameter as the container.
     * 
     * VERY IMPORTANT NOTE* DO NOT USE UNLESS YOU ALREADY SORTED AND FILTERED
     * sortedSetList. THERE ARE NO PRECONDITION CHECKERS BECAUSE IT'S STUPID TO HAVE
     * CHECKING THE PRECONDITIONS TAKE LONGER THAN RUNNING THE METHOD.
     */
    private SortedSet(ArrayList<E> sortedSetList) {
        myCon = sortedSetList;
    }

    /*
     * Private helper Constructor that makes a deep copy of a SortedSet
     * 
     * Efficiency: O(N)
     * 
     * TODO add pre and post con
     */
    private SortedSet(SortedSet<E> otherSet) {
        myCon = new ArrayList<>();
        for (E val : otherSet) {
            myCon.add(val);
        }
    }

    /*
     * TODO move this method out of where all the constructors are
     * Note to Karnika, I chose to use QuickSort over mergeSort because I'm already
     * using and know how to do mergeSort. I want to learn quickSort better
     * 
     * TODO add pre and post conditions
     */
    private void quickSort(int low, int high) {
        // TODO check preconditions
        // Base case where virtual list is empty or has one element
        if (high - low < SIZE_WHEN_INSERTION_SORT_IS_FASTER_THAN_QUICK_SORT) {
            insertionSort(low, high);
        }
        int pivotPoint = medianOfThree(low, low + (high - low) / 2, high);
        E pivotVal = myCon.get(pivotPoint);
        swap(low, pivotPoint);
        int leftPoint = low + 1;
        int rightPoint = high;
        while (leftPoint <= rightPoint) {
            // swaps first because previous loop
            swap(leftPoint, rightPoint);

            while (myCon.get(leftPoint).compareTo(pivotVal) < 0) {
                leftPoint++;
            }
            // The left pos is now 100% at something that should be on the right side

            while (myCon.get(rightPoint).compareTo(pivotVal) < 0) {
                rightPoint++;
            }
            // The right pos is now 100% at something that should be on the left side
        }
        swap(low, rightPoint);
        quickSort(low, rightPoint - 1);
        quickSort(rightPoint + 1, high);
    }

    /*
     * TODO move this along with quick sort
     * 
     * TODO add pre and post conditions
     */
    public void insertionSort(int minIndex, int maxIndex) {
        // TODO check preconditions
        int unsortedPos = minIndex + 1;
        E curVal;
        while (unsortedPos <= maxIndex) {
            int comparePos = unsortedPos - 1;
            curVal = myCon.get(unsortedPos);
            while (curVal.compareTo(myCon.get(comparePos)) < 0 && comparePos >= minIndex) {
                myCon.set(comparePos + 1, myCon.get(comparePos--));
            }
            myCon.set(comparePos + 1, curVal);
        }
    }

    /*
     * TODO move this wherever quicksort goes
     * TODO add pre and post conditions
     */
    private void swap(int posOne, int posTwo) {
        E temp = myCon.get(posTwo);
        myCon.set(posTwo, myCon.get(posOne));
        myCon.set(posOne, temp);
    }

    /*
     * TODO move this wherever quicksort goes
     * 
     * TODO add pre and post conditions
     */
    private int medianOfThree(int x, int y, int z) {
        // I need to return the number that wins once, loses once
        int winner = Math.max(x, y);
        if (Math.max(winner, z) != winner) {
            // the original winner lost :)
            return winner;
        } else {
            // both these numbers have lost once
            return Math.max(Math.min(x, y), z);
        }
    }

    /**
     * Add an item to this set.
     * <br>
     * item != null
     * 
     * Efficiency:N
     * 
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation,
     *         false otherwise.
     */
    public boolean add(E item) {
        // TODO add precon checks
        int searchResult = get(item);
        if (searchResult < 0) {
            myCon.add((searchResult + 1) * -1, item);
            return true;
        }
        return false;
    }

    /**
     * A union operation. Add all items of otherSet that
     * are not already present in this set to this set.
     * 
     * Efficiency:
     * O(N) if otherSet is internally a sortedSet
     * O(NlogN) if otherSet is not a sortedSet
     * 
     * @param otherSet != null
     * @return true if this set changed as a result of this operation,
     *         false otherwise.
     */
    public boolean addAll(ISet<E> otherSet) {
        if (otherSet instanceof SortedSet<E>) {
            int originalSize = size();
            myCon = merge(myCon, ((SortedSet<E>) otherSet).myCon);
            return !(originalSize == size());
        } else {
            // else make otherSet sorted then run the program again
            return addAll(new SortedSet<>(otherSet));
        }
    }

    /*
     * TODO move this method to be more organized
     * TODO add pre and post conditions
     * pre: myCon.size() != 0
     */
    private void mergeSort() {
        ArrayList<ArrayList<E>> splitLists = new ArrayList<>();
        // This part goes through myCon O(N) and splits it into sorted segments
        splitLists.add(new ArrayList<>());
        splitLists.getLast().add(myCon.get(0));
        for (int i = 1; i < myCon.size(); i++) {
            if (myCon.get(i - 1).compareTo(myCon.get(i)) > 0) {
                splitLists.add(new ArrayList<>());
            }
            splitLists.getLast().add(myCon.get(i));
        }

        myCon = merge(splitLists);
    }

    /*
     * TODO add pre and post conditions
     */
    private ArrayList<E> merge(ArrayList<ArrayList<E>> splitLists) {
        // base case; all of the lists in splitLists are merged
        if (splitLists.size() == 1) {
            return splitLists.getFirst();
        }
        ArrayList<ArrayList<E>> newSplit = new ArrayList<>();
        for (int i = 0; i < splitLists.size(); i += 2) {
            newSplit.add(merge(splitLists.get(i), splitLists.get(i + 1)));
        }
        return merge(newSplit);
    }

    /*
     * TODO move the merge and mergeSort methods out of the way to be more organized
     * TODO add pre and post conditions
     * TODO do we need merge sort? Idk.
     */
    private ArrayList<E> merge(ArrayList<E> listOne, ArrayList<E> listTwo) {
        ArrayList<E> newList = new ArrayList<>();
        int listOnePos = 0;
        int listTwoPos = 0;
        while (listTwoPos < listTwo.size() && listOnePos < listOne.size()) {
            if (listOne.get(listOnePos).compareTo(listTwo.get(listTwoPos)) < 0) {
                newList.add(listOne.get(listOnePos));
                listOnePos++;
            } else if (listOne.get(listOnePos).equals(listTwo.get(listTwoPos))) {
                newList.add(listOne.get(listOnePos));
                listOnePos++;
                listTwoPos++;
            } else {
                newList.add(listOne.get(listTwoPos));
                listTwoPos++;
            }
        }

        // adds the vals at the end of either list (one/none while loops will trigger)
        while (listTwoPos < listTwo.size()) {
            newList.add(listTwo.get(listTwoPos));
            listTwoPos++;
        }
        while (listOnePos < listOne.size()) {
            newList.add(listOne.get(listOnePos));
            listOnePos++;
        }
        return newList;
    }

    /*
     * Efficiency: O(log(N))
     * 
     * Pre: target!=null
     * Post: nothing is mutated
     * Returns: the index of target in myCon, or if it's not in myCon, where
     * ((target would be if it was in myCon/Where to insert target)*-1)-1
     */
    private int get(E target) {
        // TODO Check preconditions.
        return binarySearch(0, myCon.size() - 1, target);
    }

    /**
     * Return the number of elements of this set.
     * 
     * Efficiency: O(1)
     * 
     * pre: none
     * 
     * @return the number of items in this set
     */
    public int size() {
        return myCon.size();
    }

    /*
     * Efficiency: O(log(N))
     * 
     * Pre: target!=null
     * Post: nothing is mutated
     * Returns: the index of target in myCon, or if it's not in myCon, where
     * ((target would be if it was in myCon/Where to insert target)*-1)-1
     */
    private int binarySearch(int low, int high, E target) {
        // TODO Check preconditions.
        if (low > high) {
            return (low * -1) - 1;
        }
        int mid = low + (high - low) / 2;
        if (target.equals(myCon.get(mid))) {
            return mid;
        } else if (target.compareTo(myCon.get(mid)) < 0) {
            return binarySearch(low, mid - 1, target);
        } else {
            return binarySearch(mid + 1, high, target);
        }
    }

    /**
     * Determine if item is in this set.
     * <br>
     * pre: item != null
     * 
     * Efficiency: O(log(N))
     * 
     * @param item element whose presence is being tested.
     *             Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    public boolean contains(E item) {
        return get(item) >= 0;
    }

    /**
     * Determine if all of the elements of otherSet are in this set.
     * <br>
     * pre: otherSet != null
     * 
     * Efficiency:
     * O(N) if otherSet is secretly a SortedSet
     * O(Nlog(N)) if otherSet isn't a SortedSet
     * 
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet,
     *         false otherwise.
     */
    public boolean containsAll(ISet<E> otherSet) {
        // O(N) if this is true
        if (otherSet instanceof SortedSet<E>) {
            int thisPos = 0;
            int otherPos = 0;
            while (otherPos < otherSet.size()) {
                if (myCon.get(thisPos).compareTo(((SortedSet<E>) otherSet).myCon.get(otherPos)) < 0) {
                    thisPos++;
                } else if (myCon.get(thisPos).equals(((SortedSet<E>) otherSet).myCon.get(otherPos))) {
                    thisPos++;
                    otherPos++;
                } else {
                    return false;
                }
            }
            return true;
        }
        // O(Nlog(N)) if above was false
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
     * Efficiency:
     * O(N) if otherSet is secretly a SortedSet
     * O(NlogN) if otherSet isn't a SortedSet
     * 
     * @param otherSet != null
     * @return a set that is the difference of this set and otherSet
     */
    public ISet<E> difference(ISet<E> otherSet) {
        if (otherSet instanceof SortedSet<E>) {
            ArrayList<E> newCon = new ArrayList<>();
            int thisPos = 0;
            int otherPos = 0;

            // find everything "this" that is less than the otherSet.max()
            while (otherPos < otherSet.size()) {
                if (myCon.get(thisPos).compareTo(((SortedSet<E>) otherSet).myCon.get(otherPos)) < 0) {
                    newCon.add(myCon.get(thisPos));
                    thisPos++;
                } else if (myCon.get(thisPos).equals(((SortedSet<E>) otherSet).myCon.get(otherPos))) {
                    thisPos++;
                    otherPos++;
                } else {
                    otherPos++;
                }
            }
            // Finds and adds everything greater than otherSet.max()
            while (thisPos < size()) {
                newCon.add(myCon.get(thisPos));
                thisPos++;
            }
            return new SortedSet(newCon);
        } else {
            // If otherSet isn't a SortedSet, sort it
            SortedSet<E> returnSet = new SortedSet<>(otherSet);
            // then
            return difference(returnSet);
        }
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
     * Efficiency: O(N)
     * 
     * @param otherSet != null
     * @return a set that is the difference of this set and otherSet
     */
    public ISet<E> difference(SortedSet<E> otherSet) {
        ArrayList<E> newCon = new ArrayList<>();
        int thisPos = 0;
        int otherPos = 0;

        // find everything "this" that is less than the otherSet.max()
        while (otherPos < otherSet.size()) {
            if (myCon.get(thisPos).compareTo(otherSet.myCon.get(otherPos)) < 0) {
                newCon.add(myCon.get(thisPos));
                thisPos++;
            } else if (myCon.get(thisPos).equals(otherSet.myCon.get(otherPos))) {
                thisPos++;
                otherPos++;
            } else {
                otherPos++;
            }
        }
        // Finds and adds everything greater than otherSet.max()
        while (thisPos < size()) {
            newCon.add(myCon.get(thisPos));
            thisPos++;
        }

        return new SortedSet(newCon);
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
    public ISet<E> intersection(ISet<E> otherSet) {
        ArrayList<E> newCon = new ArrayList<>();
        if (otherSet instanceof SortedSet<E>) {
            ArrayList<E> otherCon = ((SortedSet) otherSet).myCon;
            int thisPos = 0;
            int otherPos = 0;

            while (thisPos < size() && otherPos < otherSet.size()) {
                if (myCon.get(thisPos).compareTo(otherCon.get(otherPos)) < 0) {
                    thisPos++;
                } else if (myCon.get(thisPos).equals(otherCon.get(otherPos))) {
                    thisPos++;
                    otherPos++;
                } else {
                    otherPos++;
                }
            }
        } else {
            for (E val : otherSet) {
                if (contains(val)) {
                    newCon.add(val);
                }
            }
        }
        return new SortedSet<>(newCon);
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
    public boolean equals(Object other) {
        if (other == null || !(other instanceof ISet<?>) || size() != ((ISet) other).size()) {
            return false;
        }
        if (other instanceof SortedSet) {
            int curIndex = 0;
            for (E val : (SortedSet<E>) other) {
                if (!val.equals(myCon.get(curIndex))) {
                    return false;
                }
                curIndex++;
            }
            return true;
        } else {
            for (E val : (ISet<E>) other) {
                if (!contains(val)) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Return the smallest element in this SortedSet.
     * <br>
     * pre: size() != 0
     * 
     * Efficiency: O(1)
     * 
     * @return the smallest element in this SortedSet.
     */
    public E min() {
        return myCon.get(0);
    }

    /**
     * Return the largest element in this SortedSet.
     * <br>
     * pre: size() != 0
     * 
     * Efficiency: O(1)
     * 
     * @return the largest element in this SortedSet.
     */
    public E max() {
        return myCon.getLast();
    }

    /**
     * Return an Iterator object for the elements of this set.
     * pre: none
     * 
     * @return an Iterator object for the elements of this set
     */
    public Iterator<E> iterator() {
        return myCon.iterator();
    }

    // TODO DELETE THIS ENTIRE METHOD WHEN DONE
    public String toString() {
        return myCon.toString();
    }

    /*
     * TODO add pre and post con
     */
    public boolean remove(E item) {
        int removePos = get(item);
        if (removePos >= 0) {
            myCon.remove(removePos);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ISet<E> union(ISet<E> otherSet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'union'");
    }

}
