package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private static String[] ELEMENTS;
    private static ListIterator listIterator;

    @Before
    public void initializeListIterator() throws OperationNotSupportedException {
        ELEMENTS = new String[]{"one", "two", "three"};
        listIterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createInvalidIteratorObject() throws OperationNotSupportedException {
        String[] elements = null;
        listIterator = new ListIterator(elements);
    }

    @Test
    public void testMoveHasNext(){
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testMoveDoesNotHaveNext() throws OperationNotSupportedException {
        listIterator = new ListIterator("oneElement");
        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void testHasNextIfThereIsNext(){
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNextIfThereIsNoNext(){
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void testPrintIfListIsNotEmpty(){
        Assert.assertEquals(ELEMENTS[0], listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintIfThereIsNoElements() throws OperationNotSupportedException {
        String[] fakeElements = new String[0];
        listIterator = new ListIterator(fakeElements);
        listIterator.print();
    }
}