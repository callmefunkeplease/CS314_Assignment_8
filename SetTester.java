
/*
 * Student information for assignment:
 *
 * Number of slip days used: 1
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

/* 

Unsorted Set
File          Size (kb)   Total Words   Increase from Previous Row   Unique Words   Inc. Prev. Row   Actual Time   Inc. Prev. Row
HoBask.html   418         65947          -                            10173           -                0.16 sec.    -
FStein.html   468         80517          1.2x                         12523           1.2x             0.23 sec.    1.4x
Odyssey.html  776         138010         1.7x                         15467           1.2x             0.43 sec.    1.9x
MobyDick.html 1500        224626         1.6x                         34086           2.2x             1.85 sec.    4.3x

Sorted Set
File          Size (kb)   Total Words   Increase from Previous Row   Unique Words   Inc. Prev. Row   Actual Time   Inc. Prev. Row
HoBask.html   418         65947          -                            10173           -                0.06 sec.    -
FStein.html   468         80517          1.2x                         12523           1.2x             0.04 sec.    0.67x
Odyssey.html  776         138010         1.7x                         15467           1.2x             0.05 sec.    1.25x
MobyDick.html 1500        224626         1.6x                         34086           2.2x             0.11 sec.    2.2x

HashSet
File          Size (kb)   Total Words   Increase from Previous Row   Unique Words   Inc. Prev. Row   Actual Time   Inc. Prev. Row
HoBask.html   418         65947          -                            10173           -                0.02 sec.    -
FStein.html   468         80517          1.2x                         12523           1.2x             0.02 sec.    1.0x
Odyssey.html  776         138010         1.7x                         15467           1.2x             0.03 sec.    1.5x
MobyDick.html 1500        224626         1.6x                         34086           2.2x             0.05 sec.    1.7x

TreeSet
File          Size (kb)   Total Words   Increase from Previous Row   Unique Words   Inc. Prev. Row   Actual Time   Inc. Prev. Row
HoBask.html   418         65947          -                            10173           -                0.03 sec.    -
FStein.html   468         80517          1.2x                         12523           1.2x             0.03 sec.    1.0x
Odyssey.html  776         138010         1.7x                         15467           1.2x             0.04 sec.    1.33x
MobyDick.html 1500        224626         1.6x                         34086           2.2x             0.06 sec.    1.5x

What do you think the order (Big O) of the two processText methods are for each kind of Set? Assume N = total number of words in a file and M = number of distinct words in the file. M = the size of the set when finished.
- O(N)

What are the orders (Big O) of your add methods? What do you think the Big O of the HashSet and TreeSet add methods are?
- Our add methods are both O(N). Hashset is probably O(1) and treeset is probably O(log(N))

What are the differences between HashSet and TreeSet when printing out the contents of the Set?
- The difference is that there is no real order when the HashSet prints whereas the TreeSet prints out in lexographic order.
*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

/*
 * CS 314 Students, put your results to the experiments and answers to questions
 * here: CS314 Students, why is it unwise to implement all three of the
 * intersection, union, and difference methods in the AbstractSet314 class:
 */

public class SetTester {
        static int testNum = 0;
        static int passedTests = 0;
        static int failedTests = 0;
        static String testName;

        public static void main(String[] args) {

                // CS314 Students. Uncomment this section when ready to
                // run your experiments
                // try {
                // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                // } catch (Exception e) {
                // System.out.println("Unable to change look and feel");
                // }
                // Scanner sc = new Scanner(System.in);
                // String response = "";
                // do {
                // largeTest();
                // System.out.print("Another file? Enter y to do another file: ");
                // response = sc.next();
                // } while (response != null && response.length() > 0
                // && response.substring(0, 1).equalsIgnoreCase("y"));

                studentTests();
        }

        public static void studentTests() {
                SortedSet<Integer> s1 = new SortedSet<>(); // s is for sorted set
                SortedSet<Integer> s2 = new SortedSet<>();
                SortedSet<Integer> s3 = new SortedSet<>();
                UnsortedSet<Integer> u1 = new UnsortedSet<>(); // u is for unsorted set
                UnsortedSet<Integer> u2 = new UnsortedSet<>();
                UnsortedSet<Integer> u3 = new UnsortedSet<>();
                AbstractSet314<Integer> as = new SortedSet<>(); // as is for sorted abstract set
                AbstractSet314<Integer> au = new UnsortedSet<>(); // au is for unsorted abstract set
                ISet<Integer> is = new SortedSet<>(); // is is for Sorted ISet
                ISet<Integer> iu = new UnsortedSet<>(); // iu is for Unsorted ISet

                testName = "add for sortedSet";
                for (int i = 9; i > -4; i -= 3) {
                        s1.add(i);
                        s1.add(i + 3);
                        s1.add(i + 2);
                }
                quickTest("(-3, -1, 0, 2, 3, 5, 6, 8, 9, 11, 12)", s1.toString());

                quickTest(true, s2.add(11));
                quickTest(false, s2.add(11));
                quickTest(true, s2.add(1));
                s2.add(1);
                s2.add(11);
                quickTest(false, s2.add(1));
                quickTest(true, s2.add(-9));
                s2.add(11);
                quickTest("(-9, 1, 11)", s2);

                testName = "add for UnsortedSet";
                for (int i = 9; i > -4; i -= 3) {
                        u1.add(i);
                        u1.add(i + 3);
                        u1.add(i + 2);
                }
                quickTest("(9, 12, 11, 6, 8, 3, 5, 0, 2, -3, -1)", u1.toString());

                quickTest(true, u2.add(11));
                quickTest(false, u2.add(11));
                quickTest(true, u2.add(1));
                u2.add(1);
                u2.add(11);
                quickTest(false, u2.add(1));
                quickTest(true, u2.add(-9));
                u2.add(11);
                quickTest("(11, 1, -9)", u2);

                testName = "adding null to Sorted Set explicitly";
                testNum++;
                System.out.print("Test " + testNum + ", " + testName + "\nexpected result: an error is thrown"
                                + "\n  actual result: ");
                try {
                        s1.add(null);
                } catch (Exception e) {
                        System.out.println("an error is thrown");
                        passedTests++;
                }

                testName = "adding null to Unsorted Set explicitly";
                testNum++;
                System.out.print("Test " + testNum + ", " + testName + "\nexpected result: an error is thrown"
                                + "\n  actual result: ");
                try {
                        u1.add(null);
                } catch (Exception e) {
                        System.out.println("an error is thrown");
                        passedTests++;
                }

                testName = "SortedSet constructor, constructing w/ another set";
                s3 = new SortedSet<>(u1);
                quickTest(s1.toString(), s3);
                s3 = new SortedSet<>(s2);
                quickTest(s2.toString(), s3);

                // making the unknown* sets real bigish
                String expectedSort = "(";
                String expectedUnsort = "(";
                for (int i = 50; i > -50; i--) {
                        as.add(i);
                        au.add(i);
                        is.add(i);
                        iu.add(i);
                        expectedUnsort = expectedUnsort.concat(i + ", ");
                        expectedSort = expectedSort.concat((-1 * i) + ", ");
                }
                expectedUnsort = expectedUnsort.concat("-50)");
                expectedSort = expectedSort.concat("50)");
                as.add(-50);
                au.add(-50);
                is.add(-50);
                iu.add(-50);

                testName = "adding to an abstract set";
                quickTestBigStrings(expectedSort, as);
                quickTestBigStrings(expectedUnsort, au);
                testName = "adding to an Iset";
                quickTestBigStrings(expectedSort, is);
                quickTestBigStrings(expectedUnsort, iu);

                testName = "sorted set constructor with an abstractSet or Iset";
                quickTestBigStrings(expectedSort, new SortedSet<>(au));
                quickTestBigStrings(expectedSort, new SortedSet<>(iu));

                testName = "addAll, adding unsorted set to empty unsorted set";
                quickTest(true, u3.addAll(u1));
                quickTest("(9, 12, 11, 6, 8, 3, 5, 0, 2, -3, -1)", u3);

                testName = "addAll, adding unsorted set to unsorted set";
                quickTest(true, u3.addAll(u2));
                quickTest("(9, 12, 11, 6, 8, 3, 5, 0, 2, -3, -1, 1, -9)", u3);

                testName = "addAll, adding present unsorted set to unsorted set";
                quickTest(false, u3.addAll(u2));
                quickTest("(9, 12, 11, 6, 8, 3, 5, 0, 2, -3, -1, 1, -9)", u3);

                testName = "clear for an unsortedSet";
                u3.clear();
                quickTest("()", u3);

                testName = "addAll, adding sorted set to empty unsorted set";
                quickTest(true, u3.addAll(s1));
                quickTest("(-3, -1, 0, 2, 3, 5, 6, 8, 9, 11, 12)", u3);

                testName = "addAll, adding sorted set to unsorted set";
                quickTest(true, u3.addAll(s2));
                quickTest("(-3, -1, 0, 2, 3, 5, 6, 8, 9, 11, 12, -9, 1)", u3);

                testName = "addAll, adding present sorted set to unsorted set";
                quickTest(false, u3.addAll(s2));
                quickTest("(-3, -1, 0, 2, 3, 5, 6, 8, 9, 11, 12, -9, 1)", u3);

                testName = "clear for an unsortedSet";
                u3.clear();
                quickTest("()", u3);

                testName = "clear for a sortedSet";
                s3.clear();
                quickTest("()", s3);

                testName = "addAll, adding unsorted set to empty sorted set";
                quickTest(true, s3.addAll(u1));
                quickTest("(-3, -1, 0, 2, 3, 5, 6, 8, 9, 11, 12)", s3);

                testName = "addAll, adding unsorted set to sorted set";
                quickTest(true, s3.addAll(u2));
                quickTest("(-9, -3, -1, 0, 1, 2, 3, 5, 6, 8, 9, 11, 12)", s3);

                testName = "addAll, adding present unsorted set to sorted set";
                quickTest(false, s3.addAll(u1));
                quickTest("(-9, -3, -1, 0, 1, 2, 3, 5, 6, 8, 9, 11, 12)", s3);

                testName = "clear for a sortedSet";
                s3.clear();
                quickTest("()", s3);

                testName = "addAll, adding sorted set to empty sorted set";
                quickTest(true, s3.addAll(s1));
                quickTest("(-3, -1, 0, 2, 3, 5, 6, 8, 9, 11, 12)", s3);

                testName = "addAll, adding sorted set to sorted set";
                quickTest(true, s3.addAll(s2));
                quickTest("(-9, -3, -1, 0, 1, 2, 3, 5, 6, 8, 9, 11, 12)", s3);

                testName = "addAll, adding present sorted set to sorted set";
                quickTest(false, s3.addAll(s1));
                quickTest("(-9, -3, -1, 0, 1, 2, 3, 5, 6, 8, 9, 11, 12)", s3);

                testName = "clear for a sortedSet";
                s3.clear();
                quickTest("()", s3);

                testName = "UnsortedSet contains";
                quickTest(false, u1.contains(1));
                quickTest(true, u1.contains(-1));
                quickTest(false, u3.contains(1));

                testName = "SortedSet contains";
                quickTest(false, s1.contains(1));
                quickTest(true, s1.contains(-1));
                quickTest(false, s3.contains(1));

                testName = "ContainsAll, unsorted contains all unsorted";
                quickTest(false, u1.containsAll(u2));
                quickTest(false, u2.containsAll(u1));
                quickTest(true, u1.containsAll(u1));
                quickTest(true, u1.containsAll(u3));
                quickTest(true, iu.containsAll(u1));
                quickTest(true, au.containsAll(u1));
                quickTest(true, iu.containsAll(au));

                testName = "ContainsAll, unsorted contains all sorted";
                quickTest(false, u1.containsAll(s2));
                quickTest(false, u2.containsAll(s1));
                quickTest(true, u1.containsAll(s1));
                quickTest(true, u1.containsAll(s3));
                quickTest(true, iu.containsAll(s1));
                quickTest(true, au.containsAll(s1));
                quickTest(true, iu.containsAll(as));

                testName = "ContainsAll, sorted contains all unsorted";
                quickTest(false, s1.containsAll(u2));
                quickTest(false, s2.containsAll(u1));
                quickTest(true, s1.containsAll(u1));
                quickTest(true, s1.containsAll(u3));
                quickTest(true, is.containsAll(u1));
                quickTest(true, as.containsAll(u1));
                quickTest(true, is.containsAll(au));

                testName = "ContainsAll, sorted contains all sorted";
                quickTest(false, s1.containsAll(s2));
                quickTest(false, s2.containsAll(s1));
                quickTest(true, s1.containsAll(s1));
                quickTest(true, s1.containsAll(s3));
                quickTest(true, is.containsAll(s1));
                quickTest(true, as.containsAll(s1));
                quickTest(true, is.containsAll(as));

                testName = "Difference, unsorted.difference(unsorted)";
                quickTest("()", u3.difference(u1));
                quickTest("()", u3.difference(au));
                quickTest("()", u1.difference(u1));
                SortedSet e1 = new SortedSet<>(s1);
                e1.remove(11);
                quickTest(e1, u1.difference(u2));
                SortedSet e2 = new SortedSet<>(u2);
                e2.remove(11);
                quickTest(e2, u2.difference(u1));

                testName = "Difference, unsorted.difference(sorted)";
                quickTest("()", u3.difference(s1));
                quickTest("()", u3.difference(as));
                quickTest("()", u1.difference(s1));
                quickTest(e1, s1.difference(u2));
                quickTest(e2, u2.difference(s1));

                testName = "Difference, sorted.difference(unsorted)";
                quickTest("()", s3.difference(u1));
                quickTest("()", s3.difference(au));
                quickTest("()", s1.difference(u1));
                quickTest(e1, s1.difference(u2));
                quickTest(e2, s2.difference(u1));

                testName = "Difference, sorted.difference(sorted)";
                quickTest("()", s3.difference(s1));
                quickTest("()", s3.difference(as));
                quickTest("()", s1.difference(s1));
                quickTest(e1, s1.difference(s2));
                quickTest(e2, s2.difference(s1));

                testName = "Equals, unsorted.equals(unsorted)";
                quickTest(false, u3.equals(u1));
                quickTest(false, u1.equals(u3));
                quickTest(false, u1.equals(u2));
                quickTest(false, u1.equals(iu));
                quickTest(true, au.equals(iu));
                quickTest(true, iu.equals(au));
                quickTest(true, u3.equals(u3));
                quickTest(true, u1.equals(u1));

                testName = "Equals, unsorted.equals(sorted)";
                quickTest(false, u3.equals(s1));
                quickTest(false, u1.equals(s3));
                quickTest(false, u1.equals(s2));
                quickTest(false, u1.equals(is));
                quickTest(true, u1.equals(s1));
                quickTest(true, au.equals(is));
                quickTest(true, iu.equals(as));
                quickTest(true, u3.equals(s3));
                quickTest(true, u1.equals(s1));

                testName = "Equals, sorted.equals(unsorted)";
                quickTest(false, s3.equals(u1));
                quickTest(false, s1.equals(u3));
                quickTest(false, s1.equals(u2));
                quickTest(false, s1.equals(iu));
                quickTest(true, as.equals(iu));
                quickTest(true, is.equals(au));
                quickTest(true, s3.equals(u3));
                quickTest(true, s1.equals(u1));

                SortedSet s4 = new SortedSet<>(s1);
                testName = "Equals, sorted.equals(sorted)";
                quickTest(false, s3.equals(s1));
                quickTest(false, s1.equals(s3));
                quickTest(false, s1.equals(s2));
                quickTest(false, s1.equals(is));
                quickTest(true, s1.equals(s4));
                quickTest(true, as.equals(is));
                quickTest(true, is.equals(as));
                quickTest(true, s3.equals(s3));
                quickTest(true, s1.equals(s1));

                e1 = new SortedSet<>();
                e1.add(11);
                testName = "Intersection, unsorted.intersection(unsorted)";
                quickTest("()", u3.intersection(u1));
                quickTest("()", u1.intersection(u3));
                quickTest("()", u3.intersection(u3));
                quickTest(s1, u1.intersection(u1));
                quickTest(s1, u1.intersection(au));
                quickTest(s1, iu.intersection(u1));
                quickTest(s2, iu.intersection(u2));
                quickTest(e1, u1.intersection(u2));
                quickTest(e1, u2.intersection(u1));
                quickTestBigStrings(au, iu.intersection(au));

                testName = "Intersection, unsorted.intersection(sorted)";
                quickTest("()", u3.intersection(s1));
                quickTest("()", u1.intersection(s3));
                quickTest("()", u3.intersection(s3));
                quickTest(s1, u1.intersection(s1));
                quickTest(s1, u1.intersection(as));
                quickTest(s1, iu.intersection(s1));
                quickTest(s2, iu.intersection(s2));
                quickTest(e1, u1.intersection(s2));
                quickTest(e1, u2.intersection(s1));
                quickTestBigStrings(au, iu.intersection(as));

                testName = "Intersection, sorted.intersection(unsorted)";
                quickTest("()", s3.intersection(u1));
                quickTest("()", s1.intersection(u3));
                quickTest("()", s3.intersection(u3));
                quickTest(u1, s1.intersection(u1));
                quickTest(u1, s1.intersection(au));
                quickTest(u1, is.intersection(u1));
                quickTest(s2, is.intersection(u2));
                quickTest(e1, s1.intersection(u2));
                quickTest(e1, s2.intersection(u1));
                quickTestBigStrings(au, is.intersection(au));

                testName = "Intersection, sorted.intersection(sorted)";
                quickTest("()", s3.intersection(s1));
                quickTest("()", s1.intersection(s3));
                quickTest("()", s3.intersection(s3));
                quickTest(u1, s1.intersection(s1));
                quickTest(u1, s1.intersection(as));
                quickTest(u1, is.intersection(s1));
                quickTest(s2, is.intersection(s2));
                quickTest(e1, s1.intersection(s2));
                quickTest(e1, s2.intersection(s1));
                quickTestBigStrings(au, is.intersection(as));

                testName = "Iterator test I guess";
                Iterator it = s1.iterator();
                int counts = 0;
                while (it.hasNext()) {
                        quickTest(true, s1.contains((Integer) it.next()));
                        counts++;
                }
                quickTest(s1.size(), counts);

                it = u1.iterator();
                counts = 0;
                while (it.hasNext()) {
                        quickTest(true, s1.contains((Integer) it.next()));
                        counts++;
                }
                quickTest(s1.size(), counts);

                it = s3.iterator();
                counts = 0;
                while (it.hasNext()) {
                        quickTest(true, s1.contains((Integer) it.next()));
                        counts++;
                }
                quickTest(s3.size(), counts);

                it = u3.iterator();
                counts = 0;
                while (it.hasNext()) {
                        quickTest(true, s1.contains((Integer) it.next()));
                        counts++;
                }
                quickTest(s3.size(), counts);

                it = iu.iterator();
                quickTest(true, it.hasNext());

                testName = "size";
                quickTest(11, u1.size());
                quickTest(11, s1.size());
                quickTest(3, u2.size());
                quickTest(3, s2.size());
                quickTest(0, u3.size());
                quickTest(0, s3.size());
                quickTest(101, iu.size());
                quickTest(101, is.size());
                quickTest(101, au.size());
                quickTest(101, as.size());

                e1.addAll(u1);
                e1.addAll(u2);
                testName = "union, Unsorted.union(unsorted)";
                quickTest(e1, u1.union(u2));
                quickTest(e1, u2.union(u1));
                quickTest(u1, u1.union(u1));
                quickTest(s2, u2.union(u2));
                quickTest(u1, u1.union(u3));
                quickTest(s2, u2.union(u3));
                quickTest(u1, u3.union(u1));
                quickTest(s2, u3.union(u2));
                quickTest(iu, u1.union(iu));
                quickTest(iu, iu.union(iu));
                quickTest(iu, iu.union(u2));

                testName = "union, Unsorted.union(sorted)";
                quickTest(e1, u1.union(s2));
                quickTest(e1, u2.union(s1));
                quickTest(u1, u1.union(s1));
                quickTest(s2, u2.union(s2));
                quickTest(u1, u1.union(s3));
                quickTest(s2, u2.union(s3));
                quickTest(u1, u3.union(s1));
                quickTest(s2, u3.union(s2));
                quickTest(iu, u1.union(is));
                quickTest(iu, iu.union(is));
                quickTest(iu, iu.union(s2));

                testName = "union, sorted.union(unsorted)";
                quickTest(e1, s1.union(u2));
                quickTest(e1, s2.union(u1));
                quickTest(u1, s1.union(u1));
                quickTest(s2, s2.union(u2));
                quickTest(u1, s1.union(u3));
                quickTest(s2, s2.union(u3));
                quickTest(u1, s3.union(u1));
                quickTest(s2, s3.union(u2));
                quickTest(iu, s1.union(iu));
                quickTest(iu, is.union(iu));
                quickTest(iu, is.union(u2));

                testName = "union, sorted.union(sorted)";
                quickTest(e1, s1.union(s2));
                quickTest(e1, s2.union(s1));
                quickTest(u1, s1.union(s1));
                quickTest(s2, s2.union(s2));
                quickTest(u1, s1.union(s3));
                quickTest(s2, s2.union(s3));
                quickTest(u1, s3.union(s1));
                quickTest(s2, s3.union(s2));
                quickTest(iu, s1.union(is));
                quickTest(iu, is.union(is));
                quickTest(iu, is.union(s2));

                e1 = new SortedSet<>(s1);
                e1.remove(11);
                e1.remove(9);
                e1.remove(2);
                testName = "remove, unsortedSet";
                quickTest(true, u1.remove(11));
                quickTest(true, u1.remove(9));
                quickTest(true, u1.remove(2));
                quickTest(false, u1.remove(2));
                quickTest(e1, u1);

                testName = "remove, sortedSet";
                quickTest(true, s1.remove(11));
                quickTest(true, s1.remove(9));
                quickTest(true, s1.remove(2));
                quickTest(false, s1.remove(2));
                quickTest(e1, s1);

                UnsortedSet<String> stringSet=new UnsortedSet<>();
                stringSet.add("-3");
                stringSet.add("5");
                stringSet.add("3");
                stringSet.add("12");
                stringSet.add("6");
                stringSet.add("0");
                stringSet.add("-1");
                stringSet.add("8");
                SortedSet<String> strSorted=new SortedSet<>(stringSet);
                testName="Equals, different generic types";
                quickTest(false, s1.equals(stringSet));
                quickTest(false, u1.equals(stringSet));
                quickTest(false, s1.equals(strSorted));
                quickTest(false, u1.equals(strSorted));

                testResults();
        }

        public static void quickTest(Object expected, Object actual) {
                testNum++;
                System.out.println("Test " + testNum + ", " + testName + "\nexpected value: "
                                + expected + "\n  actual value: " + actual);
                if (expected.equals(actual)) {
                        System.out.println("passed Test " + testNum + ", " + testName);
                        passedTests++;
                } else {
                        // If i don't want to write .toString in the expected value, I don't have to.
                        if (expected instanceof String && expected.equals(actual.toString())) {
                                System.out.println("passed Test " + testNum + ", " + testName);
                                passedTests++;
                        } else {
                                System.out.println(" ***** FAILED ***** Test " + testNum + ", " + testName);
                                failedTests++;
                        }
                }
        }

        public static void quickTestBigStrings(Object expected, Object actual) {
                testNum++;
                if (expected.equals(actual)) {
                        System.out.println("passed Test " + testNum + ", " + testName);
                        passedTests++;
                } else {
                        // If i don't want to write .toString in the expected value, I don't have to.
                        if (expected instanceof String && expected.equals(actual.toString())) {
                                System.out.println("passed Test " + testNum + ", " + testName);
                                passedTests++;
                        } else {
                                System.out.println("Test " + testNum + ", " + testName + "\nexpected value: "
                                                + expected + "\n  actual value: " + actual);
                                System.out.println(" ***** FAILED ***** Test " + testNum + ", " + testName);
                                failedTests++;
                        }
                }
        }

        public static void quickTestNullExpected(Object actual) {
                testNum++;
                System.out.println("Test " + testNum + ", " + testName + "\nexpected value: "
                                + "null" + "\n  actual value: " + actual);
                if (actual == null) {
                        System.out.println("passed test " + testNum + ", " + testName);
                        passedTests++;
                } else {
                        System.out.println(" ***** FAILED ***** test " + testNum + ", " + testName);
                        failedTests++;
                }
        }

        public static void testResults() {
                System.out.println();
                System.out.println();
                System.out.println("Total  Tests: " + testNum);
                System.out.println("Passed Tests: " + passedTests);
                System.out.println("Failed Tests: " + failedTests);
                if (failedTests > 0) {
                        System.out.println("    YO EVERYBODY LOOK OVER HERE. THIS BUCKO FAILED A TEST. \n"
                                        + "THEY AINT PERFECT. LETS ALL GATHER IN A CIRCLE AND LAUGH AT THEM");
                }
                System.out.println("Success Rate: " +
                                (double) ((passedTests * 10000 / testNum + 5) / 10) / 10 + "%");
                System.out.println();
        }

        // print out results of test
        private static <E> void showTestResults(boolean actualResult, boolean expectedResult,
                        int testNumber, ISet<E> set1, ISet<E> set2, String testDescription) {
                if (actualResult == expectedResult) {
                        System.out.println("Passed test " + testNumber);
                } else {
                        System.out.print("Failed test ");
                        System.out.println(testNumber + ": " + testDescription);
                        System.out.println("Expected result: " + expectedResult);
                        System.out.println("Actual result  : " + actualResult);
                        System.out.println("Set 1: " + set1);
                        if (set2 != null) {
                                System.out.println("Set 2: " + set2);
                        }
                }

        }

        /*
         * Method asks user for file and compares run times to add words from file
         * to various sets, including CS314 UnsortedSet and SortedSet and Java's
         * TreeSet and HashSet.
         */
        private static void largeTest() {
                System.out.println();
                System.out.println("Opening Window to select file. "
                                + "You may have to minimize other windows.");
                String text = convertFileToString();
                Scanner keyboard = new Scanner(System.in);
                System.out.println();
                System.out.println("***** CS314 SortedSet: *****");
                processTextCS314Sets(new SortedSet<String>(), text, keyboard);
                System.out.println("****** CS314 UnsortedSet: *****");
                processTextCS314Sets(new UnsortedSet<String>(), text, keyboard);
                System.out.println("***** Java HashSet ******");
                processTextJavaSets(new HashSet<String>(), text, keyboard);
                System.out.println("***** Java TreeSet ******");
                processTextJavaSets(new TreeSet<String>(), text, keyboard);
        }

        /*
         * pre: set != null, text != null Method to add all words in text to the
         * given set. Words are delimited by white space. This version for CS314
         * sets.
         */
        private static void processTextCS314Sets(ISet<String> set, String text, Scanner keyboard) {
                Stopwatch s = new Stopwatch();
                Scanner sc = new Scanner(text);
                int totalWords = 0;
                s.start();
                while (sc.hasNext()) {
                        totalWords++;
                        set.add(sc.next());
                }
                s.stop();

                showResultsAndWords(set, s, totalWords, set.size(), keyboard);
        }

        /*
         * pre: set != null, text != null Method to add all words in text to the
         * given set. Words are delimited by white space. This version for Java
         * Sets.
         */
        private static void processTextJavaSets(Set<String> set, String text,
                        Scanner keyboard) {
                Stopwatch s = new Stopwatch();
                Scanner sc = new Scanner(text);
                int totalWords = 0;
                s.start();
                while (sc.hasNext()) {
                        totalWords++;
                        set.add(sc.next());
                }
                s.stop();
                sc.close();

                showResultsAndWords(set, s, totalWords, set.size(), keyboard);
        }

        /*
         * Show results of add words to given set.
         */
        private static <E> void showResultsAndWords(Iterable<E> set, Stopwatch s, int totalWords,
                        int setSize, Scanner keyboard) {

                System.out.println("Time to add the elements in the text to this set: " + s.toString());
                System.out.println("Total number of words in text including duplicates: " + totalWords);
                System.out.println("Number of distinct words in this text " + setSize);

                System.out.print("Enter y to see the contents of this set: ");
                String response = keyboard.next();

                if (response != null && response.length() > 0
                                && response.substring(0, 1).equalsIgnoreCase("y")) {
                        for (Object o : set) {
                                System.out.println(o);
                        }
                }
                System.out.println();
        }

        /*
         * Ask user to pick a file via a file choosing window and convert that file
         * to a String. Since we are evaluating the file with many sets convert to
         * string once instead of reading through file multiple times.
         */
        private static String convertFileToString() {
                // create a GUI window to pick the text to evaluate
                JFileChooser chooser = new JFileChooser(".");
                StringBuilder text = new StringBuilder();
                int retval = chooser.showOpenDialog(null);

                chooser.grabFocus();

                // read in the file
                if (retval == JFileChooser.APPROVE_OPTION) {
                        File source = chooser.getSelectedFile();
                        Scanner s = null;
                        try {
                                s = new Scanner(new FileReader(source));

                                while (s.hasNextLine()) {
                                        text.append(s.nextLine());
                                        text.append(" ");
                                }

                                s.close();
                        } catch (IOException e) {
                                System.out.println("An error occured while trying to read from the file: " + e);
                        } finally {
                                if (s != null) {
                                        s.close();
                                }
                        }
                }

                return text.toString();
        }
}