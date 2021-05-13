package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    public Integer[] elements = {1, 2, 3, 4};
    public static Database database;

    @Before
    public void initializeDatabase() throws OperationNotSupportedException {
        database = new Database(elements);
    }
    //testConstructor
    @Test
    public void testConstructorWorking() throws OperationNotSupportedException {
        Assert.assertEquals(elements.length ,database.getElements().length);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorNotWorkingWithLengthZero() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        database = new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorNotWorkingWithLengthSeventeen() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        database = new Database(numbers);
    }

    @Test
    public void testIfAddWorks() throws OperationNotSupportedException {
        Integer elementToAdd = 5;
        database.add(elementToAdd);
        Assert.assertEquals(elementToAdd, database.getElements()[4]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfAddFailsWithNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testIfRemovesTheLastIndex() throws OperationNotSupportedException {
        Integer expected = database.getElements()[database.getElements().length - 2];
        database.remove();
        Assert.assertEquals(expected, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfElementCanBeRemovedFromEmptyDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }

    @Test
    public void testIfDatabasesFetchesArray() throws OperationNotSupportedException {
        database = new Database(elements);
        Assert.assertArrayEquals(elements, database.getElements());
    }
    //testAddWork
    //testAddNull
    //testRemoveWithElements
    //testRemoveWithoutElements
    //testFetchMethod
}