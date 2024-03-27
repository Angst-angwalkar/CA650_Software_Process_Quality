package io.aniket;

import io.aniket.BinarySearch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;


public class TestBinarySearch {

    private BinarySearch searcher = new BinarySearch();

    private List<Integer> shuffledList = new ArrayList<Integer>();

    private List<Integer> sortedList = new ArrayList<Integer>();

    private List<Integer> emptyList = new ArrayList<Integer>();

    private List<Integer> singleElementList = new ArrayList<Integer>();

    private Vector<Integer> unmatchingList = new Vector<Integer>();

    @Before
    public void init(){
        for (int i = 0; i < 2000; i++){
            shuffledList.add(i);
            sortedList.add(i);
            unmatchingList.add(i);

        }
        Collections.shuffle(shuffledList);
        singleElementList.add(21);
    }


    @Test
    public void testBinarySearchSortedList(){
        Assert.assertEquals(98, searcher.search(sortedList, 99));
    }

    @Test
    public void testBinarySearchShuffledList(){
        Assert.assertNotEquals(99, searcher.search(shuffledList, 99));
    }

    @Test
    public void testBinarySearchEmptyList(){
        try{
            searcher.search(emptyList, 33);
            Assert.fail("Expected an IndexOutOfBoundsException");
        }
        catch (IndexOutOfBoundsException exception)
        {
            Assert.assertEquals("Invalid Array Size", exception.getMessage());
        }
    }

    @Test
    public void testBinarySearchArrayType(){
        try{
            searcher.search(unmatchingList, 33);
            Assert.fail("Expected an IllegalArgumentsException");
        }
        catch (IllegalArgumentException exception)
        {
            Assert.assertEquals("Invalid Array Type", exception.getMessage());
        }
    }

    @Test
    public void testBinarySearchSingleElementList(){
        Assert.assertEquals(-1, searcher.search(singleElementList, 33));
        Assert.assertNotEquals(0, searcher.search(singleElementList, 22));
    }
}
