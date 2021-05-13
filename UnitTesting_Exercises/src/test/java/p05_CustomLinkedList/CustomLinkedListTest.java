package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class CustomLinkedListTest {
    private static CustomLinkedList<Integer> customLinkedList;
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void init(){
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
    }

    @Test
    public void testGetMethodWithValidIndex(){
        Integer expectedValue = 2;
        Assert.assertEquals(expectedValue , customLinkedList.get(1));
    }

    @Test()
    public void testGetMethodWithInvalidIndex(){
        int index = 3;
        thrown.expectMessage("Invalid index: " + index);
        customLinkedList.get(index);
    }

    @Test
    public void testSetMethodWithValidIndex(){
        int validIndex = 1;
        Integer numberToSet = 5;
        customLinkedList.set(validIndex, numberToSet);
        Assert.assertEquals(numberToSet, customLinkedList.get(validIndex));
    }

    @Test
    public void testSetMethodWithInvalidIndex(){
        int invalidIndex = 3;
        Integer number = 5;
        thrown.expectMessage("Invalid index: " + invalidIndex);
        customLinkedList.set(invalidIndex, number);
    }

    @Test
    public void testAddMethod(){
        Integer expectedValue = 4;
        customLinkedList.add(expectedValue);
        Assert.assertEquals(expectedValue, customLinkedList.get(3));
    }

    @Test
    public void testRemoveAtMethodWithValidIndex(){
        int validIndex = 2;
        Integer expected = customLinkedList.get(validIndex);
        Assert.assertEquals(expected, customLinkedList.removeAt(validIndex));
    }

    @Test
    public void testRemoveAtMethodWithInvalidIndex(){
        int invalidIndex = 5;
        thrown.expectMessage("Invalid index: " + invalidIndex);
        customLinkedList.removeAt(invalidIndex);
    }

    @Test
    public void testRemoveItemWithValidItem(){

        int expectedNumber = customLinkedList.get(0);
        Assert.assertTrue(customLinkedList.remove(expectedNumber) != -1);
    }

    @Test
    public void testRemoveItemWithInvalidItem(){
        Integer item = 14;
        Assert.assertEquals(-1, customLinkedList.remove(item));
    }

    @Test
    public void testIndexOfWithValidItem(){
        Integer item = 1;
        Assert.assertEquals(0, customLinkedList.indexOf(item));
    }

    @Test
    public void testIndexOfWithInvalidItem(){
        Integer invalidItem = 6;
        Assert.assertEquals(-1, customLinkedList.indexOf(invalidItem));
    }

    @Test
    public void testContainsMethodWithValidItem(){
        Integer validItem = customLinkedList.get(0);
        Assert.assertTrue(customLinkedList.contains(validItem));
    }

    @Test
    public void testContainsMethodWithInvalidItem(){
        Integer validItem = 6;
        Assert.assertFalse(customLinkedList.contains(validItem));
    }

}